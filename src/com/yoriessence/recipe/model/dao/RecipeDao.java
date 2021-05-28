package com.yoriessence.recipe.model.dao;

import static com.yoriessence.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.yoriessence.recipe.model.vo.Recipe;
import com.yoriessence.recipe.model.vo.RecipeComment;
import com.yoriessence.recipe.model.vo.RecipeIngredient;
import com.yoriessence.recipe.model.vo.RecipePicture;

public class RecipeDao {
	
	private Properties prop=new Properties();
	
	public RecipeDao() {
		String path=RecipeDao.class.getResource("/sql/recipe_sql.properties").getPath();
		try {
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Recipe> selectRecipeList(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Recipe> list=new ArrayList();
		try{
			pstmt=conn.prepareStatement(prop.getProperty("selectRecipeList"));
			System.out.println(prop.getProperty("selectRecipeList"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Recipe r=new Recipe();
				r.setRecipeEnrollNo(rs.getInt("recipe_enroll_no"));
				r.setMemberId(rs.getString("member_id"));
				r.setRecipeTitle(rs.getString("recipe_title"));
				r.setRecipeIntro(rs.getString("recipe_intro"));
				r.setRepresentPicture(rs.getString("represent_picture"));
				r.setRecipeVideoAddress(rs.getString("recipe_video_address"));
				r.setRecipeCategory(rs.getString("recipe_category"));
				r.setRecipeInfoHowmany(rs.getInt("recipe_info_howmany"));
				r.setRecipeInfoTime(rs.getInt("recipe_info_time"));
				r.setRecipeDifficult(rs.getString("recipe_difficult"));
				r.setRecipeProcedure(rs.getString("recipe_procedure"));
				r.setRecipeTip(rs.getString("recipe_tip"));
				r.setRecipeViewCount(rs.getInt("recipe_view_count"));
				r.setRecipeEnrollDate(rs.getDate("recipe_enroll_date"));
				r.setRecipeTag(rs.getString("recipe_tag"));
				r.setMainIngredient(rs.getString("main_ingredient"));
				list.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	
	public int selectRecipeEnrollNo(Connection conn, Recipe r) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectRecipeEnrollNo"));
			pstmt.setString(1, r.getMemberId());
			pstmt.setString(2, r.getRecipeTitle());
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Recipe selectRecipe(Connection conn, int recipeEnrollNo) {
		Recipe r=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectRecipe"));
			pstmt.setInt(1, recipeEnrollNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				r=new Recipe();
				r.setRecipeEnrollNo(rs.getInt("recipe_enroll_no"));
				r.setMemberId(rs.getString("member_id"));
				r.setRecipeTitle(rs.getString("recipe_title"));
				r.setRecipeIntro(rs.getString("recipe_intro"));
				r.setRepresentPicture(rs.getString("represent_picture"));
				r.setRecipeVideoAddress(rs.getString("recipe_video_address"));
				r.setRecipeCategory(rs.getString("recipe_category"));
				r.setRecipeInfoHowmany(rs.getInt("recipe_info_howmany"));
				r.setRecipeInfoTime(rs.getInt("recipe_info_time"));
				r.setRecipeDifficult(rs.getString("recipe_difficult"));
				r.setRecipeProcedure(rs.getString("recipe_procedure"));
				r.setRecipeTip(rs.getString("recipe_tip"));
				r.setRecipeViewCount(rs.getInt("recipe_view_count"));
				r.setRecipeEnrollDate(rs.getDate("recipe_enroll_date"));
				r.setRecipeTag(rs.getString("recipe_tag"));
				r.setMainIngredient(rs.getString("main_ingredient"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return r;
	}
	
	public List<String> selectIngredientCategory(Connection conn, int recipeEnrollNo){
		List<String> list=new ArrayList();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectIngredientCategory"));
			pstmt.setInt(1, recipeEnrollNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<RecipeIngredient> selectIngredient(Connection conn, int recipeEnrollNo, String category){
		List<RecipeIngredient> list=new ArrayList();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectIngredient"));
			pstmt.setInt(1, recipeEnrollNo);
			pstmt.setString(2, category);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				RecipeIngredient ri=new RecipeIngredient();
				ri.setIngredientCategory(category);
				ri.setIngredientName(rs.getString("ingredient_name"));
				ri.setIngredientAmount(rs.getString("ingredient_amount"));
				list.add(ri);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	//추천수 가져오는 메소드
	public int selectRecommendCount(Connection conn, int recipeEnrollNo) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectRecommendCount"));
			pstmt.setInt(1, recipeEnrollNo);
			pstmt.setInt(2, recipeEnrollNo);
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public List<RecipeComment> selectComment(Connection conn, int recipeEnrollNo){
		List<RecipeComment> list=new ArrayList();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectComment"));
			pstmt.setInt(1, recipeEnrollNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				RecipeComment rc=new RecipeComment();
				rc.setRecipeCommentNo(rs.getInt("recipe_comment_no"));
				rc.setCommentEnrollDate(rs.getDate("comment_enroll_date"));
				rc.setRecipeCommentWriter(rs.getString("recipe_comment_writer"));
				rc.setRecipeComment(rs.getString("recipe_comment"));
				list.add(rc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<Recipe> searchRecipe(Connection conn, String keyword, String category, String ingredient, String order){
		List<Recipe> list=new ArrayList();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//정렬 기준에 따라 분기해 다른 쿼리문 가져옴
			String sqlKey=order.equals("recommend_count")?"recommendRecipeList":"dateRecipeList";
			pstmt=conn.prepareStatement(prop.getProperty(sqlKey).replace("#", category));
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, ingredient);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Recipe r=new Recipe();
				r.setRecipeEnrollNo(rs.getInt("recipe_enroll_no"));
				r.setMemberId(rs.getString("member_id"));
				r.setRecipeTitle(rs.getString("recipe_title"));
				r.setRecipeIntro(rs.getString("recipe_intro"));
				r.setRepresentPicture(rs.getString("represent_picture"));
				r.setRecipeVideoAddress(rs.getString("recipe_video_address"));
				r.setRecipeCategory(rs.getString("recipe_category"));
				r.setRecipeInfoHowmany(rs.getInt("recipe_info_howmany"));
				r.setRecipeInfoTime(rs.getInt("recipe_info_time"));
				r.setRecipeDifficult(rs.getString("recipe_difficult"));
				r.setRecipeProcedure(rs.getString("recipe_procedure"));
				r.setRecipeTip(rs.getString("recipe_tip"));
				r.setRecipeViewCount(rs.getInt("recipe_view_count"));
				r.setRecipeEnrollDate(rs.getDate("recipe_enroll_date"));
				r.setRecipeTag(rs.getString("recipe_tag"));
				r.setMainIngredient(rs.getString("main_ingredient"));
				list.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	

	public List<RecipePicture> selectProcedurePicture(Connection conn, int recipeEnrollNo) {
		List<RecipePicture> list=new ArrayList();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProcedurePicture"));
			pstmt.setInt(1, recipeEnrollNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				RecipePicture rp=new RecipePicture();
				rp.setRecipeImageNo(rs.getInt("recipe_image_no"));
				rp.setRecipeEnrollNo(rs.getInt("recipe_enroll_no"));
				rp.setRecipeEnrollPicture(rs.getString("recipe_enroll_picture"));
				list.add(rp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	public int insertRecipe(Connection conn, Recipe r) {
		int result=0;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertRecipe"));
			pstmt.setString(1, r.getMemberId());
			pstmt.setString(2, r.getRecipeTitle());
			pstmt.setString(3, r.getRecipeIntro());
			pstmt.setString(4, r.getRepresentPicture());
			pstmt.setString(5, r.getRecipeVideoAddress());
			pstmt.setString(6, r.getRecipeCategory());
			pstmt.setInt(7, r.getRecipeInfoHowmany());
			pstmt.setInt(8, r.getRecipeInfoTime());
			pstmt.setString(9, r.getRecipeDifficult());
			pstmt.setString(10, r.getRecipeProcedure());
			pstmt.setString(11, r.getRecipeTip());
			pstmt.setString(12, r.getRecipeTag());
			pstmt.setString(13, r.getMainIngredient());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertIngredient(Connection conn, RecipeIngredient ri, int recipeEnrollNo) {
		int result=0;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(prop.getProperty("insertIngredient"));
			pstmt.setInt(1, recipeEnrollNo);
			pstmt.setString(2, ri.getIngredientName());
			pstmt.setString(3, ri.getIngredientAmount());
			pstmt.setString(4, ri.getIngredientCategory());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertProcedurePicture(Connection conn, int recipeEnrollNo, int fileNo, String fileName) {
		int result=0;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertProcedurePicture"));
			pstmt.setInt(1, fileNo);
			pstmt.setInt(2, recipeEnrollNo);
			pstmt.setString(3, fileName);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	

	public int insertComment(Connection conn, RecipeComment c) {
		int result=0;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertComment"));
			pstmt.setInt(1, c.getRecipeEnrollNo());
			pstmt.setString(2, c.getRecipeComment());
			pstmt.setString(3, c.getRecipeCommentWriter());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateRecipe(Connection conn, Recipe r) {
		int result=0;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateRecipe"));
			pstmt.setString(1, r.getRecipeTitle());
			pstmt.setString(2, r.getRecipeIntro());
			pstmt.setString(3, r.getRecipeVideoAddress());
			pstmt.setString(4, r.getRecipeCategory());
			pstmt.setInt(5, r.getRecipeInfoHowmany());
			pstmt.setInt(6, r.getRecipeInfoTime());
			pstmt.setString(7, r.getRecipeDifficult());
			pstmt.setString(8, r.getRecipeProcedure());
			pstmt.setString(9, r.getRecipeTip());
			pstmt.setString(10, r.getRecipeTag());
			pstmt.setString(11, r.getMainIngredient());
			pstmt.setInt(12, r.getRecipeEnrollNo());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateRepresentPicture(Connection conn, String fileName, int recipeEnrollNo) {
		int result=0;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateRepresentPicture"));
			pstmt.setString(1, fileName);
			pstmt.setInt(2, recipeEnrollNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateProcedurePicture(Connection conn, int recipeEnrollNo, int fileNo, String fileName) {
		int result=0;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertProcedurePicture"));
			pstmt.setString(1, fileName);
			pstmt.setInt(2, fileNo);
			pstmt.setInt(3, recipeEnrollNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	public int deleteRecipe(Connection conn, int recipeNo) {
		int result=0;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteRecipe"));
			pstmt.setInt(1, recipeNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteIngredient(Connection conn, int recipeNo) {
		int result=0;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteIngredient"));
			pstmt.setInt(1, recipeNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	

}
