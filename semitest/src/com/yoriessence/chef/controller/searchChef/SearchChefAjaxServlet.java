package com.yoriessence.chef.controller.searchChef;

import com.google.gson.Gson;
import com.yoriessence.chef.model.service.UserService;
import com.yoriessence.chef.model.vo.Profile;
import com.yoriessence.chef.model.vo.RecipeComment;
import com.yoriessence.chef.model.vo.RecipeRecommend;
import com.yoriessence.chef.model.vo.User;
import com.yoriessence.recipe.model.vo.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SearchChefAjaxServlet", value = "/searchchefajax.do")
public class SearchChefAjaxServlet extends HttpServlet {
    private static final long serialVersionUID = 305761468582492401L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String chefId = request.getParameter("chefsearch");
        String sortVal = request.getParameter("sortVal");

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
            pageBar+="<span><a href='"+request.getContextPath()+"/rankchef.do?cPage="+(cPage-1)+"'>이전</a></span>";
        }

        while(!(pageNo>pageEnd||pageNo>totalPage)){
            if(cPage==pageNo){
                pageBar+="<span>"+pageNo+"</span>";
            }else{
                pageBar+="<span><a href='"+request.getContextPath()+"/rankchef.do?cPage="+pageNo+"'>"+pageNo+"</a></span>";
            }
            pageNo++;
        }

        if(pageNo>totalPage){
            pageBar+="<span></span>";
        }else{
            pageBar+="<span><a href='"+request.getContextPath()+"/chef/rankchef.do?cPage="+cPage+"'>다음</a></span>";
        }


        // 셰프가 올린 레시피에 달린 댓글 개수 가져옴
        List<RecipeComment> recipeComments = new UserService().recipeCommentNum(chefId);
        for(RecipeComment r : recipeComments){
            r.setMemberName(URLEncoder.encode(r.getMemberName(),"utf-8"));
            r.setMemberNickName(URLEncoder.encode(r.getMemberNickName(),"utf-8"));
        }

        // 댓글 수 포함 레시피를 정렬해서 가져옴
        List<RecipeRecommend> recipeRecommend = new UserService().recipeRecommendNum(chefId,sortVal,cPage,numPerPage);
        for(RecipeRecommend r : recipeRecommend){
            r.setRecipeTitle(URLEncoder.encode(r.getRecipeTitle(),"utf-8"));
            r.setMemberId(URLEncoder.encode(r.getMemberId(),"utf-8"));
        }
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");

        Map<String,Object> data = new HashMap<>();
        data.put("commentsNum",recipeComments);
        data.put("recommendsNum",recipeRecommend);
        data.put("pageBar",pageBar);

        out.println(gson.toJson(data));

        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
