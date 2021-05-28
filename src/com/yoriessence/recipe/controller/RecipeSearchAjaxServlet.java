package com.yoriessence.recipe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yoriessence.recipe.model.service.RecipeService;
import com.yoriessence.recipe.model.vo.Recipe;

/**
 * Servlet implementation class RecipeSearchAjaxServlet
 */
@WebServlet("/recipe/recipeSearchAjax")
public class RecipeSearchAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeSearchAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecipeService service=new RecipeService();
		String keyword=request.getParameter("keyword");
		String category=request.getParameter("category");
		String ingredient=request.getParameter("ingredient");
		String order=request.getParameter("order");
		System.out.println(keyword+"/"+category+"/"+order);
		List<Recipe> list=service.searchRecipe(keyword, category, ingredient, order);
		request.setAttribute("recipeList", list);
		request.getRequestDispatcher("/view/recipe/recipeSearchAjax.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
