package com.yoriessence.chef.controller.recommendRecipe;

import com.yoriessence.chef.model.service.UserService;
import com.yoriessence.recipe.model.vo.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SortRecommendRecipeServlet", value = "/SortRecommendRecipeServlet")
public class SortRecommendRecipeServlet extends HttpServlet {
    private static final long serialVersionUID = -815244279286614654L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
