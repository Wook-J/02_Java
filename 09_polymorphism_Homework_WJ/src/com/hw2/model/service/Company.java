package com.hw2.model.service;

import com.hw2.model.dto.Person;
import com.hw2.model.dto.Employee;

public class Company implements ManagementSystem{

	// 필드, 멤버변수
	private Employee[] employees;							// Employee 객체배열을 employees(참조형 변수)로 선언
	private int employeeCount;								// 직원수(배열 인덱스용)
	
	// 생성자
	public Company(int size) {
		// TODO Auto-generated constructor stub
		
		employees = new Employee[size];						// Employee 객체 배열을 size 크기로 생성 및 주소를 employees 에 할당
		employeeCount = 0;									// 0으로 초기화
	}
	
	// 메서드
	@Override
	public void addPerson(Person person) {		// ManagementSystem(interface)의 추상메서드 상속
		// TODO Auto-generated method stub
		
		if( employees.length >= employeeCount ) {			// employees(배열)에 공간이 있는 경우
			
			employees[employeeCount] = (Employee) person;	// Person 객체가 Employee 클래스의 인스턴스이고, 그 객체를 employees(배열)에 추가
			System.out.printf("직원이 추가되었습니다 - ID : %s , 이름 : %s , 직책 : %s\n", 		// 추가된 객체의 정보를 출력
					employees[employeeCount].getId(), employees[employeeCount].getName(), employees[employeeCount].getPosition());
			employeeCount++;								// employees(배열)의 다음 인덱스에 추가하기 위한 employeeCount 증가
			
		} else System.out.println("인원이 모두 충원되었습니다.");	// employees(배열)에 공간이 없는 경우
	}
	
	@Override
	public void removePerson(String id) {		// ManagementSystem(interface)의 추상메서드 상속
		// TODO Auto-generated method stub
		
		boolean flag = false;					// 동일 Id 가 있는지 판단하는 변수
		
		for(int i=0; i<employeeCount; i++) {				// i = 0 ~ (employeeCount-1) ... 총 employeeCount개
			if( id.equals(employees[i].getId()) ) {			// 매개변수로 전달된 Id 와 일치하는 employees[i]의 Id 가 있는 경우
				
				System.out.printf("직원이 삭제되었습니다 - ID : %s , 이름 : %s , 직책 : %s\n",	// 삭제될 객체의 정보를 출력
					employees[i].getId(), employees[i].getName(), employees[i].getPosition());
				
				for(int j=i+1; j<employeeCount; j++) employees[j-1] = employees[j];				// 1칸씩 당기면서 employees[i] 정보 덮어쓰기
				
				flag = true;								// 1개 삭제한 경우 employeeCount 변화시키기 위한 변수값 변화
				break;										// 바깥의 for 문 탈출 (1개 찾으면 이후 for 문 돌릴 필요 없음)
			} 
		}
		
		if(flag) {
			employeeCount--;							// index 와 employeeCount 는 1 차이(index 가 작음)므로 주의!!
			employees[employeeCount] = null;			// 하나 감소된 employeeCount 이므로 배열 인덱스가 존재
		} else System.out.printf("해당 ID(%s)를 가진 직원을 찾을 수 없습니다\n", id);		// 일치하는 Id 없는 경우
		
	}
	
	@Override
	public void displayAllPersons() {			// ManagementSystem(interface)의 추상메서드 상속
		// TODO Auto-generated method stub
		
		System.out.println("전체 직원 명단 : ");
		for(Employee emp : employees) {
			if( emp == null) break;							// nullPonterException 방지
			System.out.println(emp.getInfo());
		}
	}

	// getter, setter
	public Employee[] getEmployees() {
		return employees;
	}
	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
}
