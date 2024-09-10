package com.hw1.run;

import com.hw1.model.vo.Employee;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] empArr = new Employee[3];
		empArr[0] = new Employee();
		empArr[1] = new Employee(1, "홍길동", 19, 'M', "01022223333", "서울 잠실");
		empArr[2] = new Employee(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡");
		
		for(int i=0; i<empArr.length; i++) {
			System.out.printf("empArr[%d] : %s\n", i, empArr[i].information());
		}
		System.out.println("======================================================================");
		empArr[0].setEmpName("김말똥");
		empArr[0].setDept("영업부");
		empArr[0].setJob("팀장");
		empArr[0].setAge(30);
		empArr[0].setGender('m');
		empArr[0].setSalary(3000000);
		empArr[0].setBonusPoint(0.2);
		empArr[0].setPhone("01055559999");
		empArr[0].setAddress("전라도 광주");
		
		empArr[1].setDept("기획부");
		empArr[1].setJob("부장");
		empArr[1].setSalary(4000000);
		empArr[1].setBonusPoint(0.3);
		
		for(int i=0; i<empArr.length-1; i++) {
			System.out.printf("empArr[%d] : %s\n", i, empArr[i].information());
		}
		System.out.println("======================================================================");
		int totalYearWage = 0;
		
		for(int i=0; i<empArr.length; i++) {
			int yearWage = (int) ( (empArr[i].getSalary() + empArr[i].getSalary()*empArr[i].getBonusPoint() ) * 12);
			System.out.println(empArr[i].getEmpName() + "의 연봉 : " + yearWage + "원");
			totalYearWage += yearWage;
		}
		System.out.println("======================================================================");
		System.out.println("직원들의 연봉의 평균 : " + totalYearWage/3 + "원");
		
	}
}
