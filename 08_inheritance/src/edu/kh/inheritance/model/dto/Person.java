package edu.kh.inheritance.model.dto;
// DTO (Data Transfer Object) : 비즈니스 계층과 데이터 교환을 위해 사용하는 객체(vo 와 거의 같음)

public class Person /* extends Object */{
	// Object 클래스
	// - 모든 클래스의 최상위 부모
	// - class 선언부에 상속구문이 하나도 작성되어있지 않다면
	//   컴파일러가 extends Object 구문을 추가해 줌   

	// 필드, 멤버변수
	private String name;			// 이름
	private int age;				// 나이
	private String nationality;		// 국적
	
	
//	{	// 초기화 블록 : 객체가 생성될 때 변수들을 초기화하기 위해 사용
		// -> 생성자가 생기면서 초기화 블록을 잘 사용하지 않음
//	}
	
	// 생성자
	public Person() {}
	
	public Person(String name, int age, String nationality) {
		super();			// 부모의 생성자(여기선 Object 클래스의 기본 생성자)
		this.name = name;
		this.age = age;
		this.nationality = nationality;
	}

	// 메서드
	public void breath() {
		System.out.println("사람은 코나 입으로 숨을 쉰다");
	}
	
	public void move() {
		System.out.println("사람은 움직일 수 있다");
	}
	
	@Override	
	public String toString() {	// 부모(Object)의 toString() 을 재정의하겠다!
		return name + " / " + age + " / " + nationality;
	}

	// getter/ setter
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
	
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
