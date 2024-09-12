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
		return "ID : " + id + " , 이름 : " + name + " , 직책 : " + position;	
//		id 와 name 을 Person 클래스에서 protected 로 만들어서 직접접근 가능!

//		String.format() 사용하는 경우
//		return String.format("ID : %s, 이름 : %s , 직책 : %s", id, name, position);
	}

	// getter, setter
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
