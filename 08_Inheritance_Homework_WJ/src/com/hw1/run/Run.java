package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {

	public static void main(String[] args) {
	
		Student[] stdArr = new Student[3];
		stdArr[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
		stdArr[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
		stdArr[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");
		
//		for(int i=0; i<stdArr.length; i++) {
//			System.out.println(stdArr[i].information());
//		}
		
		/* 향상된 for 문
		 * 자바에서 배열, 컬렉션과 같은 데이터를 순차적으로 간단하게 반복할 수 있는 구조를 제공
		 * 일반적인 for 문 보다 코드가 간결하고 가독성이 좋아서 반복 작업을 더 쉽게 할 수 있음 
		 * 
		 * for(데이터타입 변수명 : 배열 또는 컬렉션){
		 * 		// 반복해서 실행할 코드(변수명 이용!)
		 * }
		 * */
		for(Student std : stdArr) {
			if(std == null) break;
			System.out.println(std.information());
		}
		
		System.out.println("===========================================");
		Scanner sc = new Scanner(System.in);
		Employee[] empArr = new Employee[10];
		int count = 0;
		
		while(true) {			
			// 강사님 github 찾아서 확인하기!
			// toUpperCase(), toLowerCase()는 String형만 가능!
			
			System.out.print("사원의 정보를 입력하시겠습니까?(y/n) : ");
			char input = sc.next().charAt(0);
			
			if(input =='y' || input =='Y') {
				if(count==empArr.length) {
					System.out.println("인원 수 초과(최대 10명)");
					break;
				}
				
				empArr[count] = new Employee();
				
				System.out.print("이름 : ");
				empArr[count].setName(sc.next());
				
				System.out.print("나이 : ");
				empArr[count].setAge(sc.nextInt());
				
				System.out.print("신장 : ");
				empArr[count].setHeight(sc.nextDouble());
				
				System.out.print("몸무게 : ");
				empArr[count].setWeight(sc.nextDouble());
				
				System.out.print("급여 : ");
				empArr[count].setSalary(sc.nextInt());
				
				System.out.print("부서 : ");
				empArr[count].setDept(sc.next());
				
				count++;
				System.out.println();
				
			}else if(input=='n' || input=='N') break;
			else System.out.println("올바른 문자를 입력하세요!\n");
		}
		
//		for(int i=0; i<count; i++) {
//			System.out.println(empArr[i].information());
//		}
		
		for(Employee emp : empArr) {
			if(emp==null) break;	// NullPointerException 방지
			System.out.println(emp.information());
		}
		
		
	}

}
