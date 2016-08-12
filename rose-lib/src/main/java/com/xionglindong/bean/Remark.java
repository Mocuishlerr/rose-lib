package com.xionglindong.bean;

import java.util.Date;

public class Remark {
	private int id;
	private String userName;
	private int bookId;
	private String essay;
	private Date createTime;
	public Remark() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Remark(int id, String userName, int bookId, String essay, Date createTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.bookId = bookId;
		this.essay = essay;
		this.createTime = createTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getEssay() {
		return essay;
	}
	public void setEssay(String essay) {
		this.essay = essay;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

}
