package com.hw1.model.vo;

public class Employee extends Person {

	// 필드, 멤버변수
	private int salary;		// 급여
	private String dept;	// 부서
	
	// 생성자
	public Employee() {}

	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(age, height, weight);
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}
	
	// 메서드
	@Override
	public String information() {
		return super.information() + " / 급여 : " + salary + "원 / 부서 : " + dept;
	}

	// getter, setter
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
}