package edu.kh.basic;

// 한 줄 주석 : 컴파일러가 해석하지 않는 부분
/*
 * 범위 주석
 * 
 * */

// class : 자바 코드가 작성되는 영역
public class JavaBasic {
	
	public static void main(String[] args) {
		// main method(메서드) : 자바 어플리케이션(프로그램)을 실행하기 위해 반드시 필요한 메서드
		// main 치고 ctrl+ space -> 맨 위에 main method 자동완성
		
		// 콘솔창에 출력할 때 쓰는 메서드, JS에서의 console.log()와 유사
		System.out.println("Hello world!!!");
		System.out.println("점심 뭐먹지");
		System.out.println("12345");
		// syso 치고 ctrl + space -> 		System.out.println(); 자동완성

		// ctrl + alt + 위/아래 방향키 : 위/아래방향으로 해당 줄 복사
		// 실행 : ctrl + F11 혹은 메뉴바에 재생버튼
		
		System.out.println("---------------------------------------");			// 구분선 역할
		
		// 숫자연산
		System.out.println("1 + 2");
		System.out.println(1 + 2);
		
		// " " 안에 작성된 코드는 단순 문자열로 인식
		// " " 안에 작성되지 않은 코드는 숫자, 변수로 인식
		
		System.out.println(50-23);
		System.out.println(12*13);
		System.out.println(327/3);
		System.out.println(12%2);
		
		// " "(문자열) + 숫자와 함께 작성하는 경우
		System.out.println("14 * 19 = " + 266);
		System.out.println("14 * 19 = " + 14 * 19);
		
		System.out.println("90 + 70 + 65 = " + (90 + 70 + 65));
		// 자바는 사칙연산의 우선순위를 그대로 따름 -> 우선 계산을 원하면 소괄호 사용!!
		
		// + 기호의 역할
		// -> 숫자 + 숫자 : 덧셈 연산의 결과
		// -> 문자열 + 숫자 or 문자열 + 문자열 : 이어쓰기
	}

}
