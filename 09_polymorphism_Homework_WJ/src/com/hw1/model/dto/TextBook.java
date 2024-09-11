package com.hw1.model.dto;

public class TextBook extends Book {

	// 필드, 멤버변수
	private String subject;
	
	// 생성자
	public TextBook() {}
	
	public TextBook(String title, String author, String subject) {
		super(title, author);
		this.subject = subject;
	}

	// 메서드
	@Override
	public void displayInfo() {
		String str = "[전문서적] 제목 : " + super.getTitle() + " / 저자 : " + super.getAuthor() + " / 과목 : " + subject;
		System.out.println(str);
	}
	
	// getter, setter
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
