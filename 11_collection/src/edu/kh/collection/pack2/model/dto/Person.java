package edu.kh.collection.pack2.model.dto;

import java.util.Objects;

public class Person {
	
	// 필드
	private String name;
	private int age;
	private char gender;
	
	// 생성자
	public Person() {}
	public Person(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	// 메서드 
	/**
	 * alt + shift + s 이용해서 toString Override 하는 방법 이용
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	// 객체가 같다(동일 또는 동등)는 것을 어떻게 비교할까?
	// - 동일 : 가리키고 있는 것이 같음
	// - 동등 : 값이 같음
	
	// 동일 객체 : 메모리 주소가 같은 완전히 같은 객체
	//	-> hashCode()는 주로 이런 객체를 식별하는 데 사용
	
	// 동등 객체 : 메모리 주소가 다르더라도, 각 개체의 내부 값들이 같다면 
	//			   동일한 객체로 간주하는 경우를 말함
	//	-> equals() 메서드는 이러한 객체가 같은지 판단할 때 사용
	
	
	// ==== alt shift s : generate hashCodes() and equals() ====

	// 동일 비교 : Object.hashCode() 메서드를 오버라이딩 해야 함
	// hash 함수 : 값을 넣으면 같은 길이의 문자열이 반환되는 함수
	// ex) 123 					-> qwerty
	//     asdfghfasefGAwQWEef 	-> asdfgh
	// 암호화에 많이 사용
	
	@Override
	public int hashCode() {
		// 필드에 저장된 값을 이용해서 hashCode 생성
		// hashCode : 객체별 식별 코드
		return Objects.hash(age, gender, name);
		// 필드값이 다 같으면 같은 해시코드를 만들어서 반환함
	}
	
	// 동등 비교 : Object.equals() 메서드를 오버라이딩 해야 함
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;		// 다운캐스팅 (Object 에서 Person 타입으로)
		return age == other.age && gender == other.gender && Objects.equals(name, other.name);
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

	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}
