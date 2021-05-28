package com.yoriessence.chef.controller.rankchef;

import com.yoriessence.chef.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "RankChefServlet", value = "/rankchef.do")
public class RankChefServlet extends HttpServlet {
    private static final long serialVersionUID = 3779996671072247270L;
    // 셰프랭킹 서블릿

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 회원 가져올때 추천수 30 이상은 셰프로 업데이트 시킴
        new UserService().updateChefGrade();

        // 셰프 리스트 받아와서 페이지 처리함
        new RankChefTemplateServlet().doPost(request,response);

        request.getRequestDispatcher("/view/searchChef/RankChef.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
