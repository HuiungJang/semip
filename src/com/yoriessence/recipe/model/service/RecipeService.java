package com.yoriessence.recipe.model.service;

import static com.yoriessence.common.JDBCTemplate.close;
import static com.yoriessence.common.JDBCTemplate.commit;
import static com.yoriessence.common.JDBCTemplate.getConnection;
import static com.yoriessence.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yoriessence.recipe.model.dao.RecipeDao;
import com.yoriessence.recipe.model.vo.Recipe;
import com.yoriessence.recipe.model.vo.RecipeComment;
import com.yoriessence.recipe.model.vo.RecipeIngredient;
import com.yoriessence.recipe.model.vo.RecipePicture;

public class RecipeService {
	
	private RecipeDao dao=new RecipeDao();
	
	//모든 레시피 가져오는 메소드
	public List<Recipe> selectRecipeList(){
		Connection conn=getConnection();
		List<Recipe> list=dao.selectRecipeList(conn);
		for(Recipe r:list) {
			r.setRecommendCount(dao.selectRecommendCount(conn, r.getRecipeEnrollNo()));
			r.setCommentCount(dao.selectComment(conn, r.getRecipeEnrollNo()).size());
		}
		close(conn);
		return list;
	}

	//특정 레시피의 등록번호 조회
	public int selectRecipeEnrollNo(Recipe r) {
		Connection conn=getConnection();
		int result=dao.selectRecipeEnrollNo(conn, r);
		close(conn);
		return result;
	}
	
	//특정 레시피의 재료 분류 조회
	public List<String> selectIngredientCategory(int recipeEnrollNo){
		Connection conn=getConnection();
		List<String> list=dao.selectIngredientCategory(conn, recipeEnrollNo);
		close(conn);
		return list;
	}
	
	//레시피 등록 메소드
	public int insertRecipe(Recipe r) {
		Connection conn=getConnection();
		int result=dao.insertRecipe(conn, r);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int insertIngredientMap(Map<String, List<RecipeIngredient>> map, int recipeEnrollNo) {
		Connection conn=getConnection();
		int result=0;
		Set set=map.entrySet();
		Iterator i=set.iterator();
		stop:
		while(i.hasNext()){
			Map.Entry e=(Map.Entry)i.next();
			String key=(String)e.getKey();
			List<RecipeIngredient> list=(List<RecipeIngredient>)e.getValue();
			for(RecipeIngredient ri:list) {
				ri.setIngredientCategory(key);
				result=dao.insertIngredient(conn, ri, recipeEnrollNo);
				if(!(result>0)) break stop;
			}
		}
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public List<RecipePicture> selectProcedurePicture(int recipeEnrollNo){
		Connection conn=getConnection();
		List<RecipePicture> list=dao.selectProcedurePicture(conn, recipeEnrollNo);
		close(conn);
		return list;
	}

	//요리과정의 사진 저장하는 메소드
	public int insertProcedurePicture(int recipeEnrollNo, int fileNo, String fileName) {
		Connection conn=getConnection();
		int result=dao.insertProcedurePicture(conn, recipeEnrollNo, fileNo, fileName);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	
//	public int insertIngredient(RecipeIngredient ri, int recipeEnrollNo) {
//		Connection conn=getConnection();
//		int result=dao.insertIngredient(conn, ri, recipeEnrollNo);
//		if(result>0) commit(conn);
//		else rollback(conn);
//		close(conn);
//		return result;
//	}
	
	//특정 레시피만 조회하는 메소드
	public Recipe selectRecipe(int recipeEnrollNo) {
		Connection conn=getConnection();
		Recipe r=dao.selectRecipe(conn, recipeEnrollNo);
		r.setRecommendCount(dao.selectRecommendCount(conn, recipeEnrollNo));
		r.setCommentCount(dao.selectComment(conn, r.getRecipeEnrollNo()).size());
		close(conn);
		return r;
	}
	
	//특정 레시피의 재료 이름과 양 조회
	public List<RecipeIngredient> selectIngredient(String category, int recipeEnrollNo){
		Connection conn=getConnection();
		List<RecipeIngredient> list=dao.selectIngredient(conn, recipeEnrollNo, category);
		close(conn);
		return list;
	}
	
	//특정 레시피 삭제
	public int deleteRecipe(int recipeEnrollNo) {
		Connection conn=getConnection();
		int result=dao.deleteRecipe(conn, recipeEnrollNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//특정 레시피의 재료 삭제
	public int deleteIngredient(int recipeEnrollNo) {
		Connection conn=getConnection();
		int result=dao.deleteIngredient(conn, recipeEnrollNo);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	//레시피 검색하기
	public List<Recipe> searchRecipe(String keyword, String category, String ingredient, String order){
		Connection conn=getConnection();
		List<Recipe> list=dao.searchRecipe(conn, keyword, category, ingredient, order);
		for(Recipe r:list) {
			r.setRecommendCount(dao.selectRecommendCount(conn, r.getRecipeEnrollNo()));
			r.setCommentCount(dao.selectComment(conn, r.getRecipeEnrollNo()).size());
		}
		close(conn);
		return list;
	}
	
	//레시피의 모든 댓글 가져오는 메소드
	public List<RecipeComment> selectComment(int recipeEnrollNo){
		Connection conn=getConnection();
		List<RecipeComment> list=dao.selectComment(conn, recipeEnrollNo);
		close(conn);
		return list;
	}
	
	//레시피 번호를 기준으로 댓글 등록하는 메소드
	public int insertComment(RecipeComment comment) {
		Connection conn=getConnection();
		int result=dao.insertComment(conn, comment);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//레시피 수정 메소드
	public int updateRecipe(Recipe r, Map<String, List<RecipeIngredient>> ingMap, List<String> pictures) {
		Connection conn=getConnection();
		int result=dao.updateRecipe(conn, r);
		if(result>0) {
			if(r.getRepresentPicture()!=null) {
				result=dao.updateRepresentPicture(conn, r.getRepresentPicture(), r.getRecipeEnrollNo());
			}
		}
		if(result>0) {
			result=dao.deleteIngredient(conn, r.getRecipeEnrollNo());
		}
		if(result>0) {
			commit(conn);
			Set set=ingMap.entrySet();
			Iterator it=set.iterator();
			stop:
			while(it.hasNext()){
				Map.Entry e=(Map.Entry)it.next();
				String key=(String)e.getKey();
				List<RecipeIngredient> list=(List<RecipeIngredient>)e.getValue();
				for(RecipeIngredient ri:list) {
					ri.setIngredientCategory(key);
					result=dao.insertIngredient(conn, ri, r.getRecipeEnrollNo());
					if(result==-1) break stop;
				}
			}
		}
		if(result>0) {
			for(int i=0;i<pictures.size();i++) {
				if(pictures.get(i)!=null) {
					result=dao.updateProcedurePicture(conn, r.getRecipeEnrollNo(), i+1, pictures.get(i));
					if(result==-1) break;
				}
			}
			if(result>0) {
				commit(conn);
				close(conn);
				return result;
			}
		}
		rollback(conn);
		close(conn);
		return result;
		
	}
	
	
}
