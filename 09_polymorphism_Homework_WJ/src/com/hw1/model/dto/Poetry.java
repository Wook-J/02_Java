package com.hw1.model.dto;

public class Poetry extends Book {

	// 필드, 멤버변수
	private int numberOfPoems;
	
	// 생성자
	public Poetry() {}
	
	public Poetry(String title, String author, int numberOfPoems) {
		super(title, author);
		this.numberOfPoems = numberOfPoems;
	}

	// 메서드
	@Override
	public void displayInfo() {
		String str = "[시집] 제목 : " + super.getTitle() + " / 저자 : " + super.getAuthor() + " / 시 수 : " + numberOfPoems;
		System.out.println(str);
	}
	// super 안 써도 Book 에 있는 method 인 getTitle(), getAuthor() 쓸 수 있음!!
	
	// getter, setter
	public int getNumberOfPoems() {
		return numberOfPoems;
	}
	public void setNumberOfPoems(int numberOfPoems) {
		this.numberOfPoems = numberOfPoems;
	}
}
