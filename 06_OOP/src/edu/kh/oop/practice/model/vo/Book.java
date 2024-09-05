package edu.kh.oop.practice.model.vo;

public class Book {
	// 필드, 멤버변수
	private String title;			// 도서명
	private int price;				// 가격
	private double discountRate;	// 할인율
	private String author;			// 저자명
	
	// 생성자
	public Book() {}				// ctrl + space -> enter : 기본생성자
	
	// alt + shift + s -> Generate Constructor using Fields.. -> generate : 매개변수 생성자
	public Book(String title, int price, double discountRate, String author) {
//		super();				// 상속할 때 나오는거라 지금은 필요X
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
	}

	// 메서드
	
	// alt + shift + s -> Generate toString()
	
	// @ 어노테이션 : 컴파일러용 주석
	// Overriding : 재정의(메서드), 상속할 때 나온대
	@Override
	public String toString() {
		return title + " / " + price + " / " + discountRate + " / " + author;
	}
	
	// alt + shift + s -> Generate Getters and Setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

}
