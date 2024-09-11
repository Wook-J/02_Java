package edu.kh.poly.ex1.model.dto;

public class Spark extends Car {
	
	// 속성(필드, 멤버변수)
	private double discountOffer;	// 할인혜택

	// 생성자
	public Spark() {}
	
	public Spark(String engine, String fuel, int wheel, double discountOffer) {
		super(engine, fuel, wheel);
		this.discountOffer = discountOffer;
	}

	// 메서드
	@Override
	public String toString() {
		return super.toString() + " / " + discountOffer;
	}
	
	// getter, setter
	public double getDiscountOffer() {
		return discountOffer;
	}
	public void setDiscountOffer(double discountOffer) {
		this.discountOffer = discountOffer;
	}
}
