package edu.kh.inheritance.model.dto;

public /*final*/ class Employee extends Person {
	// final 클래스 -> 제공되는 클래스 그대로 사용해야 하는 경우
	// String 클래스 : final 클래스 임!

	// 필드, 멤버변수
	private String company;
	
	// 생성자
	// (1) 기본생성자
	public Employee() {}
	
	// (2) 매개변수 생성자 alt shift s -> o -> 맨 윗 부분에서 부모의 매개변수 생성자로 선택 가능!
	public Employee(String name, int age, String nationality, String company) {
		super(name, age, nationality);
		this.company = company;
	}
	
	// 메서드
	
	/* final 메서드 -> 오버라이딩이 불가함!
	 * - 메서드의 기능이 변하면 안되는 경우(재정의되면 안되는 경우)
	 * */
	public final void onlyEmployee() {
		System.out.println("final 메서드 입니다. 수정불가능!!!");
	}
	
	// @Override 어노테이션 : 해당 메서드가 오버라이딩 되었음을 컴파일러에게 알려주는 역할
	// -> 컴파일러에게 문법체크 등을 하도록 알림
	
	// 어노테이션(Annotation) : 컴파일러 인식용 주석
	
	@Override	// 부모(Person)으로부터 상속받은 메서드 중 move() 메서드를 Employee 에 맞게 재정의
	public void move() {
		System.out.println("오버라이딩된 move()");
		System.out.println("효율적으로 빨리 일하고 퇴근한다.");
	}

	@Override
	public String toString() {
		return super.toString() + " / " + company;
	}
	
	// getter/ setter
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
