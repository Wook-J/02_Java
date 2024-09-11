package com.hw1.model.dto;

public abstract class Book {

	// 필드, 멤버변수
	private String title;
	private String author;
	
	// 생성자
	public Book() {}

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	// 메서드
	public abstract void displayInfo();
	
	// getter, setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
