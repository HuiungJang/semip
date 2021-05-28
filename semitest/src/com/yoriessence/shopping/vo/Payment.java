package com.yoriessence.shopping.vo;

import java.util.Date;

public class Payment {
	private int Ordernumber;
	private int productno;
	private String memberid;
	private String productname;
	private int productprice;
	private int productamount;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(int ordernumber, int productno, String memberid, String productname, int productprice,
			int productamount) {
		super();
		Ordernumber = ordernumber;
		this.productno = productno;
		this.memberid = memberid;
		this.productname = productname;
		this.productprice = productprice;
		this.productamount = productamount;
	}

	public int getOrdernumber() {
		return Ordernumber;
	}

	public void setOrdernumber(int ordernumber) {
		Ordernumber = ordernumber;
	}

	public int getProductno() {
		return productno;
	}

	public void setProductno(int productno) {
		this.productno = productno;
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

	public int getProductamount() {
		return productamount;
	}

	public void setProductamount(int productamount) {
		this.productamount = productamount;
	}
	
	
	
	
	
	
	
	

}
