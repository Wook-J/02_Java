package com.hw2.model.dto;

public abstract class Animal {
	
	// 필드
	protected String name;
	
	// 생성자
	public Animal() {}
	public Animal(String name) {
		this.name = name;
	}
	
	// 메서드
	public abstract void sound();
	
	// getter, setter : protected 라 필요 없음

}
