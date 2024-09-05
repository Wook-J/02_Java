package edu.kh.oop.cls.model.vo;

public class User {

	// 속성 (필드)
	// 아이디, 비밀번호, 이름, 나이, 성별 (추상화 진행)
	// 데이터 직접접근 불가 원칙 -> 필드는 기본적으로 모두 private(캡슐화 진행)
	private String userId;
	private String userPw;
	private String userName;
	private int userAge;
	private char userGender;
	
	// 기능 (생성자 + 메서드)
	
	/*
	 * - new 연산자를 통해서 객체를 생성할 때 생성된 객체의
	 *   필드값을 초기화하고 지정된 기능을 수행하는 역할
	 */
	
	// 기본생성자(-> 매개변수 없는 생성자)
	public User() {
		// 기능
		System.out.println("기본생성자로 User 객체 생성");
		
		// 필드 초기화
		userId = "user01";
		userPw = "pass01";
		userName = "홍길동";
		userAge = 20;
		userGender = '남';
	}
	
	// 매개변수 생성자
	// ** 사용되는 기술, 변수 : 매개변수, Overloading(오버로딩), this
	
	// ** 매개변수 : 생성자나 메서드 호출 시 () 안에 작성되어 전달되어지는 값을 저장하고 있는 변수
	//    -> 전달받은 값을 저장하고 있는 매개체 역할의 변수
	
	public User(String userId, String userPw) {
		// 기능
		System.out.println("매개변수 생성자를 이용하여 User 객체 생성");
		System.out.println(userId + " / " + userPw);
		
		// 필드 초기화
		this.userId = userId;
		this.userPw = userPw;
		// 필드		= 매개변수
		
		// this 참조변수
		// - 객체가 자기 자신을 참조할 수 있도록 하는 변수
		// - 왜 사용?? -> 필드명과 매개변수명이 같은 경우 이를 구분하기 위함
		// - 기본생성자에서는 매개변수가 들어오지 않으므로 this 필요없음
	}
	
	// 필드를 전부 초기화하는 목적의 매개변수 생성자
	public User(String userId, String userPw, String userName, int userAge, char userGender) {
		
		// this() 생성자
		// 같은 클래스의 다른 생성자를 호출할 떄 사용
		// 생성자 내에서 반드시 첫줄에 있어야함!
		// 왜 사용? -> 중복코드 제거, 코드길이 감소, 재사용성 증가!!!
		// 단점 -> 가독성이 떨어지는 경우가 있음
		
		this(userId, userPw);		// 매개변수 2개짜리 생성자 찾아서 먼저 집어넣음!
//		this.userId = userId;
//		this.userPw = userPw;
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
	}
	
	// 자바는 기본적으로 필드명, 생성자명, 메서드명, 변수명 의 중복을 허용하지 않음!
//	private String userId;	// Duplicate field User.userId
//	public User() {}		// Duplicate method User() in type User
	
	// *** 오버로딩 (Overloading) ***
	// - 클래스 내에 동일한 이름의 메서드(생성자 포함)를 여러 개 작성하는 기법
	
	// [오버로딩 조건]
	// 1) 메서드의 이름이 동일
	// 2) 매개변수의 개수, 타입 또는 순서 중 1개라도 달라야 함!!!
	
//	public User() {}				// 기본생성자가 이미 작성되어 있어서 불가능!
	public User(String userId) {}	// 매개변수의 개수가 같은 생성자 없어서 가능!
	public User(int userAge) {}		// 매개변수 1개짜리 있으나 타입이 달라서 가능!
	public User(String userId, int userAge) {}	// 매개변수 2개짜리 있으나 타입 1개가 달라서 가능!
	public User(int userAge, String userId) {}	// 매개변수 2개+타입 있으나 순서가 달라서 가능!
//	public User(int userAge, String userName) {}// 매개변수 2개+타입+순서가 같아서 불가능! 변수명은 신경X

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPw() {
		return userPw;
	}
	
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getUserAge() {
		return userAge;
	}
	
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	public char getUserGender() {
		return userGender;
	}
	
	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}	
	
}
