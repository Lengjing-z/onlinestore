package com.cn.vo;

public class order {
	private int orderid;
	private int userid;
	private float ordersum;
	private int mum;
	private String person;
	private String orderdate;
	private String address;
	private int goodsid;
	private float goodsprice;
	private int qty;
	private String emailcode;
	private int status;
	private String note;
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailcode() {
		return emailcode;
	}
	public void setEmailcode(String emailcode) {
		this.emailcode = emailcode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getMum() {
		return mum;
	}
	public void setMum(int mum) {
		this.mum = mum;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public float getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(float goodsprice) {
		this.goodsprice = goodsprice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public float getOrdersum() {
		return ordersum;
	}
	public void setOrdersum(float ordersum) {
		this.ordersum = ordersum;
	}
	
	

}
