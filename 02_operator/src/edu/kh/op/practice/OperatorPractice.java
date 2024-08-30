package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice {		// 기능 제공용 클래스
	
	public void practice1() {		// 인원 수 + 사탕 개수 -> 1인당 사탕 개수 + 남은 사탕 개수
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int numPerson = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int numCandy = sc.nextInt();
		
		System.out.printf("1인 당 사탕 개수 : %d\n남은 사탕 개수 : %d", numCandy/numPerson, numCandy%numPerson);
	}
	
	public void practice2() {		// 이름 + 학년 + 반 + 번호 + 성별 + 성적 -> 결과
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String studentName = sc.next();
		
		System.out.print("학년(정수만) : ");
		int studentClass = sc.nextInt();
		
		System.out.print("반(정수만) : ");
		int studentClassNum = sc.nextInt();
		
		System.out.print("번호(정수만) : ");
		int studentNum= sc.nextInt();
		
		System.out.print("성별(남학생/여학생) : ");
		String studentGender = sc.next();
		// next() : 문자열(공백X)
		// nextLine() : 문자열(띄어쓰기, 공백) // nextInt(), nextDouble() 등등 뒤에는 쓰면안된다.
		// 굳이 필요하면 위쪽에 sc.nextLine()을 한번 더 써주면 됨!(입력버퍼 비워주는 역할, 개행문자 비우기)
		
		System.out.print("성적(소수점아래둘째자리까지) : ");
		double studentGrade= sc.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다.\n", studentClass, studentClassNum, studentNum, studentName, studentGender, studentGrade);
	}

	public void practice3() {		// 국어점수 + 영어점수 + 수학점수 -> 합계 + 평균
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int koreanScore = sc.nextInt();
		
		System.out.print("영어 : ");
		int englishScore = sc.nextInt();
		
		System.out.print("수학 : ");
		int mathScore = sc.nextInt();
		
		int result = koreanScore+englishScore+mathScore;
		
		System.out.printf("합계 : %d\n평균 : %.1f", result, result/3.0);
	}
}
