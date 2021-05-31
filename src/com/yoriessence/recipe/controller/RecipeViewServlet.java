package com.yoriessence.recipe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yoriessence.member.vo.Member;
import com.yoriessence.recipe.model.service.RecipeService;
import com.yoriessence.recipe.model.vo.Recipe;
import com.yoriessence.recipe.model.vo.RecipeComment;
import com.yoriessence.recipe.model.vo.RecipeIngredient;
import com.yoriessence.recipe.model.vo.RecipeProcedure;
import com.yoriessence.recipe.model.vo.RecipeRecommend;

/**
 * Servlet implementation class RecipeViewServlet
 */
@WebServlet("/recipe/recipeView")
public class RecipeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//레시피 등록번호 가져옴
		int recipeEnrollNo=Integer.parseInt(request.getParameter("recipeEnrollNo"));
		
		RecipeService rs=new RecipeService();
		Recipe r=rs.selectRecipe(recipeEnrollNo);
		
		//로그인한 사람과 작성자 아이디 비교해 조회수 올리기
//		if(!(((Member)(request.getSession(false)).getAttribute("loginMember")).getUserId().equals(r.getMemberId()))) {
			rs.updateRecipeViewCount(r);
//		}
		
		//재료 분류 가져옴
		List<String> ingCategory=rs.selectIngredientCategory(recipeEnrollNo);
		
		//재료 분류를 통해 재료의 이름과 양을 list로 가져옴
		Map<String, List<RecipeIngredient>> ing=new HashMap();
		for(String s:ingCategory) {
			ing.put(s, rs.selectIngredient(s, recipeEnrollNo));
		}
		
		//레시피에 등록된 댓글 가져오기
		List<RecipeComment> comments=rs.selectComment(recipeEnrollNo);
		
		//댓글 작성자 가져오기
		for(RecipeComment c:comments) {
			c.setWriterProfile(rs.selectMemberProfile(c.getRecipeCommentWriter()));
		}
		
//		//레시피의 과정 사진 가져오기
//		List<RecipePicture> pictures=rs.selectProcedurePicture(recipeEnrollNo);
//		for(RecipePicture rp:pictures) {
//			System.out.println(rp.getRecipeEnrollPicture());
//			
//		}
		
		//레시피 과정 가져오기ㅏ
		List<RecipeProcedure> procedure=rs.selectProcedure(recipeEnrollNo);
		
		//레시피의 추천 목록 가져오기
		List<RecipeRecommend> recommend=rs.selectRecommendList(recipeEnrollNo);
		
		if(r!=null) {
			request.setAttribute("recipeView", r);
			request.setAttribute("category", ingCategory);
			request.setAttribute("ingredient", ing);
			request.setAttribute("comments", comments);
//			request.setAttribute("pictures", pictures);
			request.setAttribute("procedure", procedure);
			request.setAttribute("recommend", recommend);
			request.getRequestDispatcher("/view/recipe/recipeView.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "이미 삭제되었거나 존재하지 않는 레시피입니다.");
			request.setAttribute("loc", "/view/recipe/recipeList");
			request.getRequestDispatcher("/view/common/msg.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
