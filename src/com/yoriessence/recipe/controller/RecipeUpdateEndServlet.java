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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yoriessence.recipe.model.service.RecipeService;
import com.yoriessence.recipe.model.vo.Recipe;
import com.yoriessence.recipe.model.vo.RecipeIngredient;

/**
 * Servlet implementation class RecipeUpdateEndServlet
 */
@WebServlet("/recipe/recipeUpdateEnd")
public class RecipeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값 받아오기
		String path=request.getServletContext().getRealPath("/upload/recipe/");
		int maxSize=1024*1024*10;
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		int recipeEnrollNo=Integer.parseInt(mr.getParameter("recipe_enroll_no"));
		
		//dao로 저장
		Recipe r=new Recipe();
		r.setMemberId(mr.getParameter("member_id"));
		r.setRecipeEnrollNo(recipeEnrollNo);
		r.setRecipeTitle(mr.getParameter("recipe_title"));
		r.setRecipeIntro(mr.getParameter("recipe_intro"));
		r.setRepresentPicture(mr.getFilesystemName("represent_picture"));
		r.setRecipeVideoAddress(mr.getParameter("recipe_video_address"));
		r.setRecipeCategory(mr.getParameter("recipe_category"));
		r.setRecipeInfoHowmany(Integer.parseInt(mr.getParameter("recipe_info_howmany")));
		r.setRecipeInfoTime(Integer.parseInt(mr.getParameter("recipe_info_time")));
		r.setRecipeDifficult(mr.getParameter("recipe_difficult"));
		r.setRecipeProcedure(mr.getParameter("recipe_procedure"));
		r.setRecipeTip(mr.getParameter("recipe_tip"));
		r.setRecipeTag(mr.getParameter("recipe_tag"));
		r.setMainIngredient(mr.getParameter("main_ingredient"));
		
		//재료 parsing
		Map<String, List<RecipeIngredient>> ingMap=new HashMap<String, List<RecipeIngredient>>();
		//bundle 이름 담은 배열 생성
		String[] bundle=mr.getParameter("hidden_name").split(",");
		for(String b:bundle) {
			if(b!=null) {
				//category명 통해 가져온 각 재료 배열
				String[] ing=mr.getParameter(b).split(",");
				List<RecipeIngredient> ingList=new ArrayList();
				//재료 순회해 list에 넣기
				for(String i:ing) {
					if(i!=null) {
						//각 bundle을 : 기준으로 나눠 얻은 재료의 이름, 양 배열
						String[] ingredient=i.split(":");
						RecipeIngredient ri=new RecipeIngredient();
						ri.setIngredientName(ingredient[0]);
						ri.setIngredientAmount(ingredient[1]);
						ingList.add(ri);
					}
				}
				//순회해 만든 list를 ingMap에 넣기
				ingMap.put(b, ingList);
			}
		}
		
		//과정 사진 parsing
		List<String> procedurePictures=new ArrayList();
		int length=Integer.parseInt(mr.getParameter("procedure_picture_count"));
		for(int i=0;i<length;i++) {
			String param="procedure_picture"+(i+1);
			procedurePictures.add(mr.getFilesystemName(param));
		}
	
		int result=new RecipeService().updateRecipe(r, ingMap, procedurePictures);
		
		//결과 출력
		String msg="";
		String loc="";
		if(result>0) {
			msg="등록을 성공했습니다.";
			loc="recipe/recipeView?recipeEnrollNo="+recipeEnrollNo;
		}else {
			msg="등록을 실패했습니다.";
			loc="/recipe/recipeList";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/view/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
