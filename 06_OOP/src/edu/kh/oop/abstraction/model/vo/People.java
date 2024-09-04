package edu.kh.oop.abstraction.model.vo;

// model : 프로그램 로직과 관련되어 있는 데이터를 저장하는 용도
// VO(Value Object) : 값 저장용 객체를 만들기 위한 클래스를 모아두는 패키지

// MVC(Model View Controller) 패턴 : 소프트웨어 개발에서 사용하는 디자인 패턴 중 하나
// Model - 데이터 비즈니스 로직 담당(데이터 상태관리, DB와 상호작용 등등)
//       - VO(Value Object) 또는 DTO(Data Transfer Object)

public class People {		// 국민(사람) 클래스

	// 클래스란? 객체의 특성(속성, 기능)을 정의한 것
	// == 객체를 만들기 위한 설계도
	
	// 속성 (== 값 혹은 data) : 값을 저장하기 위한 변수 선언
	// -> 국민이라면 공통적으로 가지고 있는 속성만 작성(추상화)
	// 이름, 성별, 주민번호, 주소, 전화번호, 나이 등
	// 필드 == 필드변수 == 멤버변수
	
	// 캡슐화
	// - 데이터(속성)와 기능을 하나로 묶어서 관리하는 기법
	// - 데이터의 직접적인 접근을 제한하는 것이 원칙
	// -> 직접 접근을 못하기 때문에 클래스 내부에
	//    간접 접근 방법을 제공하는 기능(메서드) 작성해둬야 함!
	// -> getter / setter
	
	// ** 데이터 직접 접근 제한 **
	// public(공공의) -> private(사적인, 개인적인) 으로 변경
	// [접근제한자] 자료형 변수명;
	private String name;		// 이름
	private char gender;		// 성별
	private String pNo;			// 주민번호
	private String address;		// 주소
	private String phone;		// 전화번호
	private int age;			// 나이
	
	// 기능 (== 행동 혹은 method[메서드])
	public void tax() {
		System.out.println("세금을 냅니다...");
	}
	
	// void : 반환할 값이 없다(반환형(자료형)이 없다)	
	public void vote() {
		System.out.println("투표를 합니다...꼭 하세요");
	}
	
	// 캡슐화에서 사용할 간접 접근 기능(getter/setter)
	// [접근제한자] 반환형 메서드명() {}

	// name 변수의 값을 호출한 쪽으로 돌려 보내주는 간접 접근 기능 중 getter

	public String getName() {
		return name;
	}
	
	// name 변수에 값을 세팅하는 간접 접근 기능 중 setter
	public void setName(String name) {
		// 매개변수 String name
		// -> String 타입의 데이터를 전달받아 저장하고 있는 변수
		
		// ** this : 현재 객체(클래스)
		this.name = name;
	}

	// alt + shift + s 또는 상단메뉴바에 첫번째 source
	// -> Generate Getters and Setters... 클릭
	// -> selectAll -> generate 클릭

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}