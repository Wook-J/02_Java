package com.hw1.model.vo;

public class Student extends Person {

	// 필드, 멤버변수
	private int grade;		// 학년
	private String major;	// 전공
	
	// 생성자
	public Student() {}

	public Student(String name, int age, double height, double weight, int grade, String major) {
		super(age, height, weight);
		this.name = name;		// protected 의 경우에는 this. 를 사용하여 대입가능!
		this.grade = grade;
		this.major = major;
	}
	
	// 메서드
	@Override
	public String information() {
		return super.information() + " / 학년 : " + grade + " / 전공 : " + major;
//		return super.information() + String.format(" / 학년 : %d / 전공 : %s", grade, major);
	}

	// getter, setter
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}