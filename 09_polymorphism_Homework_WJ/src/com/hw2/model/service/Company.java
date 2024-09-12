package com.hw2.model.service;

import com.hw2.model.dto.Person;
import com.hw2.model.dto.Employee;

public class Company implements ManagementSystem {

	// 필드, 멤버변수
	private Employee[] employees;							// Employee 객체배열의 이름을 employees(참조변수)로 선언
	private int employeeCount;								// 직원수(배열 인덱스용)
	
	// 생성자
	public Company(int size) {
		
		employees = new Employee[size];						// Employee 객체 배열을 size 크기로 생성 및 주소를 employees 에 할당
		employeeCount = 0;									// 0으로 초기화
	}
	
	// 메서드
//	@Override
//	public void addPerson(Person person) {		// ManagementSystem(interface)의 추상메서드 상속
//		
//		if( employees.length > employeeCount ) {			// employees(배열)에 공간이 있는 경우
//			
//			employees[employeeCount] = (Employee) person;	// Person 객체가 Employee 클래스의 인스턴스이고, 그 객체를 employees(배열)에 추가
//			System.out.println("직원이 추가되었습니다 - " + employees[employeeCount].getInfo());	// 추가된 객체의 정보를 출력
//			employeeCount++;								// employees(배열)의 다음 인덱스에 추가하기 위한 employeeCount 증가
//			
//		} else System.out.println("인원이 모두 충원되었습니다.");	// employees(배열)에 공간이 없는 경우
//	}
	
	// 선생님 풀이
	@Override
	public void addPerson(Person person) {		// Employee 객체를 Person 객체로 업캐스팅
		
		// Person 객체가 Employee 클래스의 인스턴스인지 및 배열의 공간이 있는지 여부
		if(person instanceof Employee &&  employeeCount < employees.length)	{
			
			employees[employeeCount++] = (Employee) person;	// 다운캐스팅 및 인원추가 후 employeeCount 증가
			System.out.println("직원이 추가되었습니다 - " + person.getInfo());	// 동적바인딩(Employee.getInfo()로 바뀜)
			
		} else System.out.println("인원이 모두 충원되었습니다.");
	}
	
//	@Override
//	public void removePerson(String id) {		// ManagementSystem(interface)의 추상메서드 상속
//		
//		boolean flag = false;								// 동일 Id 가 있는지 판단하는 변수
//		
//		for(int i=0; i<employeeCount; i++) {				// i = 0 ~ (employeeCount-1) ... 총 employeeCount개
//			if( id.equals(employees[i].getId()) ) {			// 매개변수로 전달된 Id 와 일치하는 employees[i]의 Id 가 있는 경우
//				System.out.println("직원이 삭제되었습니다 - " + employees[i].getInfo());		// 삭제될 객체의 정보를 출력
//				for(int j=i+1; j<employeeCount; j++) employees[j-1] = employees[j];				// 1칸씩 당기면서 employees[i] 정보 덮어쓰기
//				flag = true;								// 1개 삭제한 경우 employeeCount 변화시키기 위한 변수값 변화
//				break;										// 바깥의 for 문 탈출 (1개 찾으면 이후 for 문 돌릴 필요 없음)
//			} 
//		}
//		
//		if(flag) {
//			employeeCount--;								// index 와 employeeCount 는 1 차이(index 가 작음)므로 주의!!
//			employees[employeeCount] = null;				// 하나 감소된 employeeCount 이므로 배열 인덱스가 존재
//		} else System.out.printf("해당 ID(%s)를 가진 직원을 찾을 수 없습니다\n", id);			// 일치하는 Id 없는 경우
//	}
	
	// 선생님 풀이
	@Override
	public void removePerson(String id) {
		
		for(int i=0; i<employeeCount; i++) {				// 현재 등록된 직원 수 만큼만 반복
			if(employees[i].getId().equals(id)) {			// 매개변수로 전달된 Id 와 일치하는 employees[i]의 Id 가 있는 경우
				System.out.println("직원이 삭제되었습니다 - " + employees[i].getInfo());		// 삭제될 객체의 정보를 출력
				employees[i] = null;						// i 번째 직원 삭제
				for(int j= i; j<employeeCount-1; j++) employees[j] = employees[j+1];			// 1칸씩 당기면서 employees[i] 정보 덮어쓰기
				employees[--employeeCount] = null;			// employeeCount 먼저 1 감소시키고 배열 마지막 요소를 null 대입
				return;										// 호출한 곳으로 바로 돌아가면서 메서드 종료
			}
		}
		
		System.out.println("ID : " + id + "인 직원을 찾을 수 없습니다.");
	}
	
	@Override
	public void displayAllPersons() {			// ManagementSystem(interface)의 추상메서드 상속

		System.out.printf("전체 직원 명단 : 총 %d명\n", employeeCount);
		for(Employee emp : employees) {
			if( emp == null) break;							// nullPointerException 방지
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
