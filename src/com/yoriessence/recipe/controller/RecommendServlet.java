package com.yoriessence.recipe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yoriessence.recipe.model.service.RecipeService;
import com.yoriessence.recipe.model.vo.Recipe;

/**
 * Servlet implementation class RecommendServlet
 */
@WebServlet("/recipe/recommend")
public class RecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String loginId=request.getParameter("loginId");
//		int recipeEnrollNo=Integer.parseInt("recipeEnrollNo");
//		String writer=new RecipeService().selectRecipe(recipeEnrollNo).getMemberId();
//		int result=0;
//		if(writer.equals(loginId)) {
//			request.setAttribute("result", );
//		}else {
//			result=new RecipeService().updateRecommend(loginId, recipeEnrollNo);			
//		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
