package com.hw1.model.dto;

public class Novel extends Book {

	// 필드, 멤버변수
	private String genre;
	
	// 생성자
	public Novel() {}
	
	public Novel(String title, String author, String genre) {
		super(title, author);
		this.genre = genre;
	}

	// 메서드
	@Override
	public void displayInfo() {
		String str = "[소설] 제목 : " + super.getTitle() + " / 저자 : " + getAuthor() + " / 장르 : " + genre;
		System.out.println(str);
	}
	// super 안 써도 Book 에 있는 method 인 getTitle(), getAuthor() 쓸 수 있음!! (상속받은 경우) 신기하군..!
	
	// getter, setter
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
