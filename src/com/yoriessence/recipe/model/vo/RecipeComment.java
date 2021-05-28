package com.yoriessence.recipe.model.vo;

import java.sql.Date;

/**
 * @author brjj3
 *
 */
public class RecipeComment {
	
	private int recipeCommentNo;
	private int recipeEnrollNo;
	private String recipeComment;
	private Date commentEnrollDate;
	private String recipeCommentWriter;
	
	public RecipeComment() {
		// TODO Auto-generated constructor stub
	}

	public RecipeComment(int recipeCommentNo, int recipeEnrollNo, String recipeComment, Date commentEnrollDate,
			String recipeCommentWriter) {
		super();
		this.recipeCommentNo = recipeCommentNo;
		this.recipeEnrollNo = recipeEnrollNo;
		this.recipeComment = recipeComment;
		this.commentEnrollDate = commentEnrollDate;
		this.recipeCommentWriter = recipeCommentWriter;
	}

	public int getRecipeCommentNo() {
		return recipeCommentNo;
	}

	public void setRecipeCommentNo(int recipeCommentNo) {
		this.recipeCommentNo = recipeCommentNo;
	}

	public int getRecipeEnrollNo() {
		return recipeEnrollNo;
	}

	public void setRecipeEnrollNo(int recipeEnrollNo) {
		this.recipeEnrollNo = recipeEnrollNo;
	}

	public String getRecipeComment() {
		return recipeComment;
	}

	public void setRecipeComment(String recipeComment) {
		this.recipeComment = recipeComment;
	}

	public Date getCommentEnrollDate() {
		return commentEnrollDate;
	}

	public void setCommentEnrollDate(Date commentEnrollDate) {
		this.commentEnrollDate = commentEnrollDate;
	}

	public String getRecipeCommentWriter() {
		return recipeCommentWriter;
	}

	public void setRecipeCommentWriter(String recipeCommentWriter) {
		this.recipeCommentWriter = recipeCommentWriter;
	}

	@Override
	public String toString() {
		return "RecipeComment [recipeCommentNo=" + recipeCommentNo + ", recipeEnrollNo=" + recipeEnrollNo
				+ ", recipeComment=" + recipeComment + ", commentEnrollDate=" + commentEnrollDate
				+ ", recipeCommentWriter=" + recipeCommentWriter + "]";
	}

	
	
	
	
	

}
