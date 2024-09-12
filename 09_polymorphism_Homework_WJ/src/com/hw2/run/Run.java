package com.hw2.run;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Prisoner;
import com.hw2.model.service.Company;
import com.hw2.model.service.ManagementSystem;
import com.hw2.model.service.Prison;

public class Run {

	public static void main(String[] args) {
		
		// 부모타입 참조변수 = 자식객체 (업캐스팅)
		ManagementSystem company = new Company(10);
		company.addPerson(new Employee("EMP001", "유재석", "기획팀"));		// 다형성 중 업캐스팅 사용
		company.addPerson(new Employee("EMP002", "정형돈", "개발팀"));		// 다형성 중 업캐스팅 사용
		company.addPerson(new Employee("EMP003", "하하", "총무팀"));		// 다형성 중 업캐스팅 사용
		company.displayAllPersons();										// 동적 바인딩
		System.out.println("==================================================================");
		
		ManagementSystem prisoner = new Prison(10);
		prisoner.addPerson(new Prisoner("1205", "정준하", "밥도둑"));		// 다형성 중 업캐스팅 사용
		prisoner.addPerson(new Prisoner("0705", "박명수", "웃음연쇄살인"));	// 다형성 중 업캐스팅 사용
		prisoner.displayAllPersons();										// 동적 바인딩
		System.out.println("==================================================================");
		
		company.removePerson("EMP001");
		prisoner.removePerson("1205");
		company.removePerson("EMP001");
		System.out.println("==================================================================");
		
		company.displayAllPersons();
		prisoner.displayAllPersons();
	}
}
