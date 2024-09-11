package edu.kh.poly.ex2.model.service;

public class WJCalculator implements Calculator {
	// 자식 클래스 extends 부모 클래스 : 단일 상속만 가능!
	// 자식 인터페이스 extends 부모 인터페이스
	// 클래스 implements 인터페이스, 인터페이스, ... : 다중상속 가능!
	
	// 추상 클래스 : 공통적인 동작과 상태(일반 매서드, 일반 필드)를 공유하면서
	//				 일부 동작만 다르게 구현하고자 할 때 사용
	
	// 인터페이스 : 같은 메서드를 강제구현하면서 다른 동작만을 구현하고자 할 때 사용

	@Override
	public int plus(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int minus(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public int multiple(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		return num1 / num2;
	}

}
