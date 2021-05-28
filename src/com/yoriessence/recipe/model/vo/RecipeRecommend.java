package com.yoriessence.recipe.model.vo;

public class RecipeRecommend {
	
	private int recipeEnrollNo;
	private int recommendCount;
	
	public RecipeRecommend() {
		// TODO Auto-generated constructor stub
	}

	public RecipeRecommend(int recipeEnrollNo, int recommendCount) {
		super();
		this.recipeEnrollNo = recipeEnrollNo;
		this.recommendCount = recommendCount;
	}

	public int getRecipeEnrollNo() {
		return recipeEnrollNo;
	}

	public void setRecipeEnrollNo(int recipeEnrollNo) {
		this.recipeEnrollNo = recipeEnrollNo;
	}

	public int getRecommendCount() {
		return recommendCount;
	}

	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}
	
	

}
