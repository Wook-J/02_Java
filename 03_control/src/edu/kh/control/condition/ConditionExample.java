package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample {		// 기능 제공용 클래스
	
	Scanner sc = new Scanner(System.in);		// import 자동 단축기 : ctrl + shift + o
	
	public void ex1() {		// 단일 if 문 : 조건식이 true 일때만 내부코드 수행
		
		// 입력받은 정수가 양수인지 검사하여 양수이면 "양수입니다" 출력
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input > 0) System.out.println("양수입니다");
		if(input <= 0) System.out.println("양수가 아닙니다");
	}
	
	public void ex2() {		// if - else 문 : 조건식이 true 이면 if 문, false 이면 else 문 수행
		
		// 입력받은 정수값이 홀수이면 "홀수입니다", 0이면 "0 입니다", 짝수이면 "짝수입니다" 출력
		// else if 문 없이, 중첩 if 문 사용하기
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input % 2 != 0) System.out.println("홀수입니다");
		else {
			if(input == 0) System.out.println("0 입니다");
			else System.out.println("짝수입니다");
		}
	}
	
	public void ex3() {		// if(조건식) - else if(조건식) - else 문
		
		// 양수, 음수, 0 판별
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input > 0) System.out.println("양수 입니다");
		else if (input < 0 ) System.out.println("음수 입니다");	// 바로 위 if 문이 false 인 경우
		else System.out.println("0 입니다");					// 위 if 문, else if 문이 false 인 경우
	}
	
	public void ex4() {		// 달(month)을 입력받아 해당 달에 맞는 계절 출력(+a)
		// 1, 2, 12월 : 겨울 (-15도 이하 : "한파 경보"/ -12도 이하 : "한파 주의보")
		// 3, 4, 5월 : 봄
		// 6, 7, 8월 : 여름 (35도 이상 : "폭염 경보"/  33도 이상 : "폭염 주의보")
		// 9, 10, 11월 : 가을
		// 그 외 숫자 입력 : "해당되는 계절이 없다" 출력
		
		System.out.print("달 입력 : ");
		int month = sc.nextInt();
		String season;				// 아래 조건문 수행 결과를 저장할 변수 선언
		
		if((month == 1) || (month == 2) || (month == 12)) {		// 겨울
			season = "겨울";
			System.out.print("온도 입력 : ");
			double temperature = sc.nextDouble();
			
			if(temperature <= -15 ) season += " 한파 경보";			// 겨울 한파 경보
			else if (temperature <= -12) season += " 한파 주의보";	// 겨울 한파 주의보

		}else if ((month >= 3) && (month <= 5)) {				// 봄
			season = "봄";
			
		}else if ((month >= 6) && (month <= 8)) {				// 여름
			season = "여름";
			System.out.print("온도 입력 : ");
			double temperature = sc.nextDouble();
			
			if(temperature >= 35 ) season += " 폭염 경보";			// 여름 폭염 경보
			else if (temperature >= 33) season += " 폭염 주의보";	// 여름 폭염 주의보
			
		}else if ((month >= 9) && (month <= 11)) {				// 겨울
			season = "가을";
			
		}else {													// 그 외
			season = "해당되는 계절이 없습니다";
		}
		
		System.out.println(season);
	}

	public void ex5() {		// 나이를 입력받아 "어린이, 청소년, 성인 입니다" 출력
		System.out.print("나이를 입력 하세요 : ");
		int age = sc.nextInt();
		String result;
		
		if (age <= 13) result = "어린이 입니다";
		else if (age>13 && age<=19)  result = "청소년 입니다";
		else result = "성인 입니다";
		
		System.out.println(result);
	}
	
	public void ex6() {		// 점수를 입력받아 "A, B, C, D, F" 출력, 잘못입력 시 오류
		System.out.print("점수를 입력 하세요(100점 만점) : ");
		int score = sc.nextInt();
		String result;
		
		if((score < 0) || (score > 100)) result = "잘못 입력하셨습니다";
		else if(score < 60) result = "F";
		else if(score < 70) result = "D";
		else if(score < 80) result = "C";
		else if(score < 90) result = "B";
		else result = "A";
		
		System.out.println(result);
	}
	
	public void ex7() {		// 놀이기구 탑승 제한 검사
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		String result;
		
		if((age<0) || (age>100)) result = "잘못 입력 하셨습니다";
		else if(age<12) result = "적정 연령이 아닙니다";
		else {
			System.out.print("키를 입력하세요 : ");
			double height = sc.nextDouble();
			
			if(height<140.0) result = "적정 키가 아닙니다.";
			else result = "탑승 가능";
		}
		
		System.out.println(result);
		
	}
	
	public void ex8() {		// 놀이기구 탑승 제한 검사 프로그램
		String result;
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();

		if((age<0) || (age>100)) result = "나이를 잘못 입력하셨습니다";
		else {
			System.out.print("키를 입력하세요 : ");
			double height = sc.nextDouble();	
			
			if((height<0) || (height>250.0)) result = "키를 잘못 입력하셨습니다";
			else if ((age<12) && (height<140.0)) result = "나이와 키 모두 적절치 않음";
			else if ((age>=12) && (height<140.0)) result = "나이는 적절하나, 키가 적절치 않음";
			else if ((age<12) && (height>=140.0)) result = "키는 적절하나, 나이는 적절치 않음";
			else result = "탑승 가능";
		}
		
		System.out.println(result);
		
		
	}
}
