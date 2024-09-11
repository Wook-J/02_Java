package edu.kh.poly.ex2.model.dto;

public abstract class Animal {
	// 추상 클래스
	// 1. 미완성 메서드(추상 메서드)를 보유하고 있는 클래스(추상 메서드 0개도 됨)
	// 2. 객체로 만들 수 없는 클래스(new Animal()이 불가!)
	//   -> 여러 타입들을 관리하기 위한 상위 타입의 목적!
	//   -> 객체로 생성하여 사용하기 위한 목적이 아님!
	
	// 속성 (필드, 멤버변수)
	private String type;		// 종, 과
	private String eatType;		// 식성
	
	// 생성자
	// 추상클래스는 new 연산자를 통해 직접적인 객체 생성은 불가능하지만,
	// 상속받은 자식 객체 생성 시 내부에 부모 객체 부분이 생성될 때 사용됨!
	public Animal() {}

	public Animal(String type, String eatType) {
		this.type = type;
		this.eatType = eatType;
	}
	
	// 메서드
	@Override
	public String toString() {
		return type + " / " + eatType;
	}
	
	// 동물의 공통 기능 추출(추상화)
	// -> 동물은 공통적으로 먹고, 숨쉬고, 움직이지만 "어떤 동물"이냐에 따라 그 방법이 다름!
	// -> 해당 클래스에서 메서드 정의를 할 수 없음!
	// -> 미완성 상태로 만들어 상속받은 자식이 해당 메서드를
	//    자식 본인에게 맞는 정의를 하도록 오버라이딩을 강제화 시킴
	// -> 이럴 때 추상 메서드(abstract method)를 작성!
	
	// 추상 메서드에서는 { } 쓰면 안됨! + 자식 클래스에서 무조건 메서드 정의해야 함!
	public abstract void eat();
	public abstract void breath();
	public abstract void move();
	
	// getter, setter
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getEatType() {
		return eatType;
	}
	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
}
