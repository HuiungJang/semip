package com.yoriessence.shopping.vo;

public class ShoppingCart {
	
	private String memberid;
	private String productname;
	private int productprice;
	private int productnumber;
	private int productshopify;
	
	
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}

	public ShoppingCart(String memberid, String productname, int productprice, int productnumber, int productshopify) {
		super();
		this.memberid = memberid;
		this.productname = productname;
		this.productprice = productprice;
		this.productnumber = productnumber;
		this.productshopify = productshopify;
	
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public int getProductnumber() {
		return productnumber;
	}

	public void setProductnumber(int productnumber) {
		this.productnumber = productnumber;
	}

	public int getProductshopify() {
		return productshopify;
	}

	public void setProductshopify(int productshopify) {
		this.productshopify = productshopify;
	}


	
	
	
	

}
