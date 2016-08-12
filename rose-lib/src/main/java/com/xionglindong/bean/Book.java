package com.xionglindong.bean;

import java.util.Date;

public class Book {
	public static final String BOOK_STATUS_STAY="stay";//保留
	public static final String BOOK_STATUS_LOAN_OUT="loan out";//借出
	
	private int id;
	private String bookId;
	private String name;
	private String author;
	private String price;
	private Date createTime;
	private String bookType;
	private String bookStatus;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id,String bookId,String name, String author, String price, 
			Date createTime, String bookType, String bookStatus) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.createTime = createTime;
		this.bookType = bookType;
		this.bookStatus = bookStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	

}
