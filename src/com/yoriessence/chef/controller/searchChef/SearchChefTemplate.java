package com.yoriessence.chef.controller.searchChef;

import com.yoriessence.chef.model.service.UserService;
import com.yoriessence.chef.model.vo.Profile;
import com.yoriessence.chef.model.vo.RecipeComment;
import com.yoriessence.chef.model.vo.RecipeRecommend;
import com.yoriessence.chef.model.vo.User;
import com.yoriessence.recipe.model.vo.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/searchchefTemplate")
public class SearchChefTemplate extends HttpServlet {
    private static final long serialVersionUID = -1194330843584387851L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response, String chefName, String sortVal) throws ServletException, IOException{
        int cPage;
        int numPerPage = 12;

        try{
            cPage = Integer.parseInt(request.getParameter("cPage"));
        }catch (NumberFormatException e){
            cPage =1;
        }

        int totalData = new UserService().countRecipeList();
        int totalPage = (int)(Math.ceil((double)totalData/numPerPage));
        int pageBarSize = 5;
        int pageNo = ((cPage-1)/pageBarSize) * pageBarSize +1;
        int pageEnd = pageNo+pageBarSize-1;

        String pageBar = "";

        if(pageNo == 1){
            pageBar+="<span></span>";

        }else{
            pageBar+="<span><a href='"+request.getContextPath()+"/searchchef.do?cPage="+(cPage-1)+"&chefsearch="+chefName+"'>이전</a></span>";
        }

        while(!(pageNo>pageEnd||pageNo>totalPage)){
            if(cPage==pageNo){
                pageBar+="<span style='color:#1f695b'>"+pageNo+"</span>";
            }else{
                pageBar+="<span><a href='"+request.getContextPath()+"/searchchef.do?cPage="+pageNo+"&chefsearch="+chefName+"'>"+pageNo+"</a></span>";
            }
            pageNo++;
        }

        if(pageNo>totalPage){
            pageBar+="<span></span>";
        }else{
            pageBar+="<span><a href='"+request.getContextPath()+"/searchchef.do?cPage="+cPage+"&chefsearch="+chefName+"'>다음</a></span>";
        }
        request.setAttribute("pageBar",pageBar);


        // 셰프가 올린 레시피에 달린 댓글 개수 + 정보들 가져옴
        List<RecipeComment> recipeComments = new UserService().recipeCommentNum(chefName);
        request.setAttribute("countComment",recipeComments);

        if(recipeComments.size()==0){
            // 레시피가 없으면 저 로직이 안도니까
            // 프로필만 가져오는 로직추가
            List<Profile> recipeComment = new UserService().chefProfile(chefName);
            request.setAttribute("countComment2",recipeComment);

        }


        // 댓글 수 포함 레시피를 정렬해서 가져옴
        List<RecipeRecommend> recipeRecommend = new UserService().recipeRecommendNum(chefName,sortVal,cPage,numPerPage);

        if(recipeRecommend.size() == 0){
            recipeRecommend = new UserService().chefProfile2(chefName);
        }

        request.setAttribute("recipeRecommends",recipeRecommend);


        // 유저 정보를 가져옴
        User userInfo = new UserService().userInfo(chefName);
        request.setAttribute("userInfo",userInfo);



        List<Recipe> recipes = new UserService().getRecipe(chefName,cPage,numPerPage);
        // 그 셰프가 올린 레시피를 가져옴
        request.setAttribute("recipe",recipes);




        request.getRequestDispatcher("/view/searchChef/searchChefPage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }

}
