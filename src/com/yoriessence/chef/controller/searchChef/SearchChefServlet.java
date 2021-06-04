package com.yoriessence.chef.controller.searchChef;


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
import java.util.List;

@WebServlet(name = "SearchChefServlet", value = "/searchchef.do")
public class SearchChefServlet extends HttpServlet {
    private static final long serialVersionUID = -1448507338993502574L;
    // 셰프랭킹 화면에서 셰프검색 했을 때

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chefName = request.getParameter("chefsearch");
        String sortVal = request.getParameter("sortVal");

        if(sortVal == null){
            sortVal="최신순";
        }

        List<Profile> chefProfile = new UserService().chefProfile(chefName);
        // 셰프 닉네임으로 검색해서 프로필 가져옴
        request.setAttribute("chefProfile",chefProfile);

        if(chefProfile == null){
            String id = request.getParameter("memberId");
            new UserService().createProfile(id);
            // 기본 프로필 생성함
            // 로그인 후 프로필 눌렀을 때 프로필 없으면 생성
            // 넘어오는 값은 아이디로 고정
            // 다시 프로필 가져와서 저장함
            List<Profile> reGetChefProfile = new UserService().chefProfile(chefName);
            request.setAttribute("chefProfile",reGetChefProfile);

            // 프로필생성  실패시
            if(reGetChefProfile == null){
                request.setAttribute("msg","검색 결과가 존재하지 않습니다. 다시 검색해주세요");
                request.setAttribute("loc","/rankchef.do");
                request.getRequestDispatcher("/view/common/msg.jsp").forward(request,response);
            }
        }

        new SearchChefTemplate().doGet(request,response,chefName,sortVal);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
