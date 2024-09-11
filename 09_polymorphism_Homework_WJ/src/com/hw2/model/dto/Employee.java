package com.hw2.model.dto;

public class Employee extends Person {

	// 필드, 멤버변수
	private String position;
	
	// 생성자
	public Employee(String id, String name, String position) {
		super(id, name);
		this.position = position;
	}
	
	// 메서드
	@Override
	public String getInfo() {
		return "ID : " + super.getId() + " , 이름 : " + super.getName() + " , 직책 : " + position;
	}

	// getter, setter
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
