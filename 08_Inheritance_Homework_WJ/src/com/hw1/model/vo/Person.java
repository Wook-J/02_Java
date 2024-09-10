package com.hw1.model.vo;

public class Person {

	// 필드, 멤버변수
	protected String name;		// protected : 상속받은 후손클래스에서 직접접근 가능
	private int age;
	private double height;
	private double weight;
	/*
	 * private 필드는 상속을 통해 자식 클래스가 부모 클래스의 필드를 물려받더라도
	 * getter 와 setter 를 이용하여 "간접" 접근을 해야 함
	 * 
	 * protected 필드는 상속받은 자식이 마치 원래 본인 것이었던 것처럼 사용가능하므로
	 * 부모 필드에 "직접" 접근이 가능함!
	 * */
	
	// 생성자
	public Person() {}

	public Person(int age, double height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	// 메서드
	public String information() {
		return "이름 : " + name +" / 나이 : " + age + " / 신장 : " + height + " / 몸무게 : " + weight;
//		return String.format("이름 : %s / 나이 : %d / 신장 : %.1f / 몸무게 : %.1f", name, age, height, weight);
//		String.format : printf 구문에 사용되는 것을 바로 대입하여 나타낼 수 있는 메서드
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
