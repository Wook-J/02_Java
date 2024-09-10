package edu.kh.inheritance.model.dto;

// 상속방법 : 자식  extends  부모
public class Student extends Person {
	// Student 클레스에 Person 클래스 내용을 연장한다
	// == Student 클래스에 Person 클래싀 필드, 메서드를 추가하여 확장함!!

	// 필드, 멤버변수
	/* 부모가 가지고 있는 멤버변수는 별도로 정의 필요X
	private String name;
	private int age;
	private String nationality;
	*/
	private int grade;				// 학년
	private int classRoom;			// 반
	
	// 생성자
	public Student() {}
	
	public Student(String name, int age, String nationality, int grade, int classRoom) {
		
		// this 참조변수는 본인 자신만을 의미함
		// -> 상속을 받았어도 name, age, nationality 는 부모(Person)의 고유필드이므로
		//    자식(Student)에서 this 참조변수를 이용해 직접 접근 불가
//		this.name = name;
		
		/* Person(부모)로부터 상속받은 메서드 중 setter
		setName(name);
		setAge(age);
		setNationality(nationality);
		-> 부모의 setter 를 이용할 수 있으나 비효율적임
		*/
		
//		super();						// 부모(Person)의 기본 생성자
		super(name, age, nationality);	// 부모(Person)의 매개변수 생성자, 부모의 매개변수 생성자의 개수와 타입 맞춰야함!
		this.grade = grade;
		this.classRoom = classRoom;
	}

	// 메서드
	@Override
	public String toString() {
		return super.toString() + " / " + grade + " / " + classRoom;
	}
	
	// getter/ setter
	/* 부모한테 상속받은 멤버변수는 getter, setter 필요없음!!
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
	*/
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
}
