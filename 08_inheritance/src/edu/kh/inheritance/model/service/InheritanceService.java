package edu.kh.inheritance.model.service;

import edu.kh.inheritance.model.dto.Employee;
import edu.kh.inheritance.model.dto.Person;
import edu.kh.inheritance.model.dto.Student;

// 비즈니스 로직 처리하는 클래스
public class InheritanceService {

	// 상속 확인 예제
	public void ex1() {
		Person p = new Person();
		
		p.setName("홍길동");
		p.setAge(25);
		p.setNationality("대한민국");
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getNationality());
		System.out.println("===============================================");
		
		// Person 을 상속받은 Student 가 Person 의 필드, 메서드를 사용할 수 있는가?
		
		// Student 객체 생성
		Student std = new Student();
		
		// Student 만의 고유한 필드(캡슐화되어 직접접근은 불가), 메서드
		std.setGrade(3);
		std.setClassRoom(5);
		
		// Person 클래스로부터 상속받은 필드(캡슐화되어 직접접근은 불가), 메서드
		std.setName("고길동");
		std.setAge(19);
		std.setNationality("대한민국");
		
		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());
		
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		System.out.println("===============================================");
		
		Employee emp = new Employee();
		
		// Employee 만의 고유 메서드
		emp.setCompany("KH정보교육원");
		
		// Person 클래스로부터 상속받은 메서드
		emp.setName("조미현");
		emp.setAge(20);
		emp.setNationality("대한민국");
		
		System.out.println(emp.getCompany());
		
		System.out.println(emp.getName());
		System.out.println(emp.getAge());
		System.out.println(emp.getNationality());
		System.out.println("===============================================");
		
		p.breath();
		p.move();
		
		std.breath();
		std.move();
		
		emp.breath();
		emp.move();
		
		// 상속의 특징
		// 코드 길이 감소 및 중복제거 효과
	}
	
	// super() 생성자 이용방법 (상속에서)
	public void ex2() {
		
		// Student 객체 생성
		Student std = new Student("김철수", 17, "한국", 1, 3);
		
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		
		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());
		System.out.println("===============================================");
		
		// Employee 객체 생성
		Employee emp = new Employee("김노동", 30, "한국", "KH정보교육원");
		
		System.out.println(emp.getName());
		System.out.println(emp.getAge());
		System.out.println(emp.getNationality());
		
		System.out.println(emp.getCompany());
	}
	
	// 오버라이딩 확인 예제
	public void ex3() {
		
		Student std = new Student();
		Employee emp = new Employee();
		
		std.move();		// 오버라이딩 X -> 부모(Person) 클래스의 메서드 수행
		emp.move();		// 오버라이딩 O -> 자식(Employee) 클래스에서 재정의한 메서드 수행
	}
	
	// toString() 오버라이딩 예제
	public void ex4() {
		
		Person p = new Person("김철수", 17, "한국");
		System.out.println(p.toString());
		System.out.println(p);
		// print 구문 수행 시 "참조변수명"을 작성하면 자동으로 toString() 메서드를 호출해서 출력해줌
		
		Student std = new Student("강호동", 18, "미국", 2, 6);
		System.out.println(std.toString());
		
		Employee emp = new Employee("김노동", 36, "한국", "KH정보교육원");
		System.out.println(emp);
	}
}