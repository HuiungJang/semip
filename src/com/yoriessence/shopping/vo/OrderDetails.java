package com.yoriessence.shopping.vo;

import java.util.Date;

public class OrderDetails {
	private int ORDERNUMBER;
	private String MEMBERID;
	private int ORDERAMOUTNT;
	private String PAYMENT;
	private String PAYMENTSTATUS;
	private Date ORDERDATE;
	private Date PAYMENTDATE;
	
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(int oRDERNUMBER, String mEMBERID, int oRDERAMOUTNT, String pAYMENT, String pAYMENTSTATUS,
			Date oRDERDATE, Date pAYMENTDATE) {
		super();
		ORDERNUMBER = oRDERNUMBER;
		MEMBERID = mEMBERID;
		ORDERAMOUTNT = oRDERAMOUTNT;
		PAYMENT = pAYMENT;
		PAYMENTSTATUS = pAYMENTSTATUS;
		ORDERDATE = oRDERDATE;
		PAYMENTDATE = pAYMENTDATE;
	}

	public int getORDERNUMBER() {
		return ORDERNUMBER;
	}

	public void setORDERNUMBER(int oRDERNUMBER) {
		ORDERNUMBER = oRDERNUMBER;
	}

	public String getMEMBERID() {
		return MEMBERID;
	}

	public void setMEMBERID(String mEMBERID) {
		MEMBERID = mEMBERID;
	}

	public int getORDERAMOUTNT() {
		return ORDERAMOUTNT;
	}

	public void setORDERAMOUTNT(int oRDERAMOUTNT) {
		ORDERAMOUTNT = oRDERAMOUTNT;
	}

	public String getPAYMENT() {
		return PAYMENT;
	}

	public void setPAYMENT(String pAYMENT) {
		PAYMENT = pAYMENT;
	}

	public String getPAYMENTSTATUS() {
		return PAYMENTSTATUS;
	}

	public void setPAYMENTSTATUS(String pAYMENTSTATUS) {
		PAYMENTSTATUS = pAYMENTSTATUS;
	}

	public Date getORDERDATE() {
		return ORDERDATE;
	}

	public void setORDERDATE(Date oRDERDATE) {
		ORDERDATE = oRDERDATE;
	}

	public Date getPAYMENTDATE() {
		return PAYMENTDATE;
	}

	public void setPAYMENTDATE(Date pAYMENTDATE) {
		PAYMENTDATE = pAYMENTDATE;
	}
	
	
	
	

}
