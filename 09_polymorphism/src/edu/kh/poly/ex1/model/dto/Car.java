package edu.kh.poly.ex1.model.dto;

public class Car {

	// 속성(필드, 멤버변수)
	private String engine;		// 엔진
	private String fuel;		// 연료
	private int wheel;			// 바퀴개수
	
	// 생성자
	public Car() {}

	public Car(String engine, String fuel, int wheel) {
		this.engine = engine;
		this.fuel = fuel;
		this.wheel = wheel;
	}

	// 메서드
	@Override	// 오버라이딩 했음을 컴파일러에게 알려주는 Override 어노테이션
	public String toString() {
		return engine + " / " + fuel + " / " + wheel;
	}
	
	// getter, setter
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getWheel() {
		return wheel;
	}
	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
}

// 컴파일 에러, 런타임 에러..??? 나중에 알려준다고 하심