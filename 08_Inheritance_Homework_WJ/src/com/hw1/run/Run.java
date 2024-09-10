package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Student[] stdArr = new Student[3];
		stdArr[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
		stdArr[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
		stdArr[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");
		
		for(int i=0; i<stdArr.length; i++) {
			System.out.println(stdArr[i].information());
		}
		
		System.out.println("===========================================");
		int count = 0;
		Employee[] empArr = new Employee[10];
		
		while(true) {
			System.out.print("사원의 정보를 입력하시겠습니까?(y/n) : ");
			char input = sc.next().charAt(0);
			
			if(input =='y' || input =='Y') {
				if(count==10) {
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
		
		for(int i=0; i<count; i++) {
			System.out.println(empArr[i].information());
		}
		
		
	}

}
