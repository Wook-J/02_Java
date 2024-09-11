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
		return "ID : " + super.getId() + " , 이름 : " + super.getName() + " , 죄목 : " + crime;
	}

	// getter, setter
	public String getCrime() {
		return crime;
	}
	public void setCrime(String crime) {
		this.crime = crime;
	}
}
