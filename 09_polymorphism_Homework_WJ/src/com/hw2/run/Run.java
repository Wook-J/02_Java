package com.hw2.run;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Prisoner;
import com.hw2.model.service.Company;
import com.hw2.model.service.ManagementSystem;
import com.hw2.model.service.Prison;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ManagementSystem empSystem = new Company(10);
		empSystem.addPerson(new Employee("EMP001", "유재석", "기획팀"));
		empSystem.addPerson(new Employee("EMP002", "정형돈", "개발팀"));
//		empSystem.addPerson(new Employee("EMP003", "하하", "총무팀"));
		empSystem.displayAllPersons();
		System.out.println("==================================================================");
		
		ManagementSystem priSystem = new Prison(10);
		priSystem.addPerson(new Prisoner("1205", "정준하", "밥도둑"));
		priSystem.addPerson(new Prisoner("0705", "박명수", "웃음연쇄살인"));
		priSystem.displayAllPersons();
		System.out.println("==================================================================");
		
		empSystem.removePerson("EMP001");
		priSystem.removePerson("1205");
//		empSystem.removePerson("EMP001");
//		empSystem.removePerson("EMP003");

		System.out.println("==================================================================");
		empSystem.displayAllPersons();
		priSystem.displayAllPersons();
	}
}
