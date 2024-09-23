package com.hw2.model.dto;

public class Monkey extends Animal{
	
	// 필드 : 별도로 없음
	
	// 생성자
	public Monkey() {}
	public Monkey(String name) {
		super(name);
	}

	// 메서드
	@Override
	public void sound() {
		System.out.println(name + "가 우끼끼 소리를 냅니다.");
	}
	
	// getter, setter : protected 라 필요 없음
}
