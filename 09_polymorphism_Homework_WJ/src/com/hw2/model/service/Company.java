package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem{

	// 필드, 멤버변수
	private Employee[] employees;
	private int employeeCount;
	
	// 생성자
	public Company(int size) {
		// TODO Auto-generated constructor stub
		employees = new Employee[size];
		employeeCount = 0;
	}
	
	// 메서드
	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		if( employees.length >= employeeCount ) {
			
			employees[employeeCount] = (Employee) person;
			System.out.printf("직원이 추가되었습니다 - ID : %s , 이름 : %s , 직책 : %s\n", 
					employees[employeeCount].getId(), employees[employeeCount].getName(), employees[employeeCount].getPosition());
			employeeCount++;
			
		} else System.out.println("인원이 모두 충원되었습니다.");
	}
	
	@Override
	public void removePerson(String id) {
		// TODO Auto-generated method stub
		for(int i=0; i<employeeCount; i++) {
			if( id.equals(employees[i].getId()) ) {
				System.out.printf("직원이 삭제되었습니다 - ID : %s , 이름 : %s , 직책 : %s\n",
					employees[i].getId(), employees[i].getName(), employees[i].getPosition());
				
				for(int j=i+1; j<employeeCount; j++) {
					employees[j-1] = employees[j];
				}
				
				employeeCount--;
				employees[employeeCount] = null;
			} else System.out.printf("해당 %s를 가진 직원을 찾을 수 없습니다\n", id);
		}
	}
	
	@Override
	public void displayAllPersons() {
		// TODO Auto-generated method stub
		System.out.println("전체 직원 명단 : ");
		for(Employee emp : employees) {
			if( emp == null) break;
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
