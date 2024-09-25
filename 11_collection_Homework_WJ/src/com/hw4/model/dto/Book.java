package com.hw4.model.dto;

public class Book {
	
	// 필드, 맴버변수
	private int bookNum;		// 책 번호
	private String title;		// 책제목
	private String writer;		// 저자
	private int price;			// 가격
	private String publisher;	// 출판사
	
	// 생성자
	public Book() {}

	public Book(int bookNum, String title, String writer, int price, String publisher) {
		this.bookNum = bookNum;
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.publisher = publisher;
	}

	// 일반 메서드
	
	@Override
	public String toString() {
		return bookNum + "번 도서 : [도서제목 : " + title + " /  도서저자 : " + writer + " / 도서가격 : " + price +
				"원 / 출판사 : " + publisher + "]";
	}
	
	
	
	
	// getter, setter
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
