package com.hw2.model.dto;

public class Tiger extends Animal{

	// 필드 : 별도로 없음
	
	// 생성자
	public Tiger() {}
	public Tiger(String name) {
		super(name);
	}

	// 메서드
	@Override
	public void sound() {
		System.out.println(name + "가 어흥하며 포효합니다.");
	}
	
	// getter, setter : protected 라 필요 없음
}
