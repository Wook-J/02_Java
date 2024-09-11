package edu.kh.practice.snack.model.vo;

public class Snack {

	// 필드, 멤버변수
	private String kind;	// 종류
	private String name;	// 이름
	private String flavor;	// 맛
	private int numOf;		// 개수
	private int price;		// 가격
	
	// 생성자
	public Snack() {}

	public Snack(String kind, String name, String flavor, int numOf, int price) {
		super();
		this.kind = kind;
		this.name = name;
		this.flavor = flavor;
		this.numOf = numOf;
		this.price = price;
	}
	
	// 메서드
	public String information() {		// 담긴 데이터를 리턴
		return kind + "(" + name + " - " + flavor + ") " + numOf + "개 " + price + "원";
	}

	// getter/ setter ====================================================
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getNumOf() {
		return numOf;
	}
	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}