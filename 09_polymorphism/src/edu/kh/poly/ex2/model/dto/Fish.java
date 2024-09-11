package edu.kh.poly.ex2.model.dto;

public class Fish extends Animal {
	
	// 속성 (필드, 멤버변수)
	
	// 생성자
	public Fish() {}
	
	public Fish(String type, String eatType) {
		super(type, eatType);
	}

	// 메서드

	@Override	// alt shift s -> Override/implements method... -> OK도 가능!
	public void eat() {
		System.out.println("입을 뻐끔거리며 먹는다...");
	}

	@Override
	public void breath() {
		System.out.println("아가미 호흡을 한다.");
	}

	@Override
	public void move() {
		System.out.println("꼬리로 헤엄치며 움직인다.");
	}
	
	@Override
	public String toString() {
		return "Fish : " + super.toString();
	}
	
	// getter, setter
}
