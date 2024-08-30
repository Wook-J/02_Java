package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {	// 기능 작성 클래스
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {		// 홀짝 판별기
		System.out.print("숫자를 한 개 입력하세요 : ");
		int number = sc.nextInt();
		
		String result;
		
		if(number <= 0) result = "양수만 입력해 주세요";
		else if(number%2 == 0) result = "짝수입니다.";
		else result = "홀수입니다.";
		
		System.out.println(result);
	}
	
	public void practice2() {		// 국어, 수학, 영어 점수를 입력받아 합불 판별
		System.out.print("국어 점수 : ");
		int koreanScore = sc.nextInt();
		System.out.print("수학 점수 : ");
		int mathScore = sc.nextInt();
		System.out.print("영어 점수 : ");
		int englishScore = sc.nextInt();
		
		int sum = koreanScore + mathScore + englishScore;
		double average = sum/3.0;
		
		if((koreanScore<40) || (mathScore<40) || (englishScore<40) || (average<60)) {
			System.out.println("합계 : "+ sum);
			System.out.println("평균 : "+ average);
			System.out.println("불합격입니다");
		} else {
			System.out.printf("국어 : %d\n수학 : %d\n영어 : %d\n합계 : %d\n평균 : %.1f\n축하합니다, 합격입니다!\n", koreanScore, mathScore, englishScore, sum, average);
		}
	}
	
	public void practice3() {		// 1 ~ 12 사이의 수 입력 받아 해당 달의 일수 출력
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int monthNumber = sc.nextInt();
		
		switch(monthNumber) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.printf("%d월은 31일까지 있습니다\n", monthNumber); break;
			
		case 2: System.out.printf("%d월은 28일까지 있습니다\n", monthNumber); break;
		
		case 4: case 6: case 9: case 11:
			System.out.printf("%d월은 30일까지 있습니다\n", monthNumber); break;
			
		default: System.out.printf("%d월은 잘못 입력된 달입니다\n", monthNumber); break;
		}
	}
	
	public void practice4() {		// 키, 몸무게를 입력 받아 BMI 및 비만여부 출력
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double bmi = weight/(height*height);
		String result;
		
		if(bmi<18.5) result = "저체중";
		else if(bmi<23) result = "정상체중";
		else if(bmi<25) result = "과체중";
		else if(bmi<30) result = "비만";
		else result = "고도비만";
		
		System.out.println("BMI 지수 : "+ bmi);
		System.out.println(result);
	}
	
	public void practice5() {		// 중간, 기말, 과제점수, 출석횟수 입력받아 P/F 출력
		
		System.out.print("중간 고사 점수 : ");
		double midScore = sc.nextDouble();
		System.out.print("기말 고사 점수 : ");
		double finalScore = sc.nextDouble();
		System.out.print("과제 점수 : ");
		double assignmentScore = sc.nextDouble();
		System.out.print("출석 횟수 : ");
		double attendanceNumber = sc.nextDouble();
		
		double totalScore = midScore*0.2 + finalScore*0.3 + assignmentScore*0.3 + attendanceNumber;
		
		// midScore *= 0.2; finalScore *= 0.3; assignmentScore *= 0.3;   // 이런식으로 미리 반영해서 넣어도 됨
		
		System.out.println("================= 결과 =================");
		
		if(attendanceNumber<=14) {
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]\n", (int)attendanceNumber);
			
		}else {
			
			System.out.printf("중간 고사 점수(20) : %.1f\n", midScore*0.2);
			System.out.printf("기말 고사 점수(30) : %.1f\n", finalScore*0.3);
			System.out.printf("과제 점수\t(30) : %.1f\n", assignmentScore*0.3);
			System.out.printf("출석 점수\t(20) : %.1f\n", attendanceNumber);
			System.out.printf("총점 : %.1f\n", totalScore);
			
			if(totalScore<70) {
				System.out.println("Fail [점수 미달]");
			}else {
				System.out.println("PASS");
			}
		}
	}
	
}
