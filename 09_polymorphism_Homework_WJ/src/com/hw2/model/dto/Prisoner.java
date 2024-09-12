package com.hw2.model.dto;

public class Prisoner extends Person {

	// 필드, 멤버변수
	private String crime;
	
	// 생성자
	public Prisoner(String id, String name, String crime) {
		super(id, name);
		this.crime = crime;
	}
	
	// 메서드
	@Override
	public String getInfo() {
		return "ID : " + id + " , 이름 : " + name + " , 죄목 : " + crime;
//		id 와 name 을 Person 클래스에서 protected 로 만들어서 직접접근 가능!
		
//		String.format() 사용하는 경우
//		return String.format("ID : %s, 이름 : %s , 죄목 : %s", id, name, crime);
	}

	// getter, setter
	public String getCrime() {
		return crime;
	}
	public void setCrime(String crime) {
		this.crime = crime;
	}
}
