package com.hw3.model.dto;

import java.util.Objects;
import java.util.Set;

public class Toy {

	// 필드
	private String name;			// 장난감 이름
	private int age;				// 사용 연령
	private int price;				// 가격
	private String color;			// 색상
	private String day;				// 제조년월일
	private Set<String> materials;	// 재료

	// 생성자
	public Toy() {}	
	public Toy(String name, int age, int price, String color, String day, Set<String> materials) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
		this.color = color;
		this.day = day;
		this.materials = materials;
	}


	// 메서드
	
	public String material() {
		
		String materialString = "";		// 배열 형태로 toString 되는 대신 재료1, 재료2, ...로 print 하려는 경우
		
		for(String material : materials) {
			if(materialString.length()==0) materialString += material;
			else materialString += ", " + material;
		}
		
		return materialString;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + " / 가격 : " + price + " / 색상 : " + color + " / 사용가능연령 : " + age +
				" / 제조연월일 : " + day + " / 재료 : " + material();
	} 
	
	@Override
	public int hashCode() {
		return Objects.hash(age, color, day, materials, name, price);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		return age == other.age && Objects.equals(color, other.color) && Objects.equals(day, other.day)
				&& Objects.equals(materials, other.materials) && Objects.equals(name, other.name)
				&& price == other.price;
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
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

	public Set<String> getMaterials() {
		return materials;
	}
	public void setMaterials(Set<String> materials) {
		this.materials = materials;
	}
	

}
