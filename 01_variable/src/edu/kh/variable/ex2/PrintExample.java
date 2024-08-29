package edu.kh.variable.ex2;

public class PrintExample {
	public static void main(String[] args) {

		// System.out.print() : 단순 출력용 메서드(출력 후 줄바꿈 X)
		// System.out.println() : 한줄 출력용 메서드(출력 후 줄바꿈 수행)
		// 줄바꿈 여부에 차이점은 있지만, 괄호 안의 내용이 그대로 출력되는 것은 똑같음!

		System.out.println("테스트1");
		System.out.println("테스트2");
		System.out.print("테스트3");
		System.out.println();			// 내용 없는 println() : 단순 줄바꿈
		System.out.print("테스트4");
		
		System.out.println();
		
		int iNum1 = 10;
		int iNum2 = 5;
		
		// 중간에 오타날 확률이 큼...!		
		System.out.println(iNum1 + " + " + iNum2 + " = " + (iNum1 + iNum2));

		// System.out.printf() : 출력될 문자열 형식을 패턴으로 지정하는 출력구문
		// System.out.printf("패턴", 패턴에 들어갈 값); 
		System.out.printf("%d + %d = %d\n", iNum1, iNum2, iNum1+iNum2);	
		
		/* printf에서 사용하는 패턴
		 * %d : 정수형, %o : 8진수, %x : 16진수
		 * %c : 문자, %s : 문자열
		 * %f : 실수(소수점아래6자리), %e : 지수형태표현, %g : 대입값그대로
		 * %A : 16진수실수
		 * %b : 논리형
		 * */
		
		// 10 + 10 * 5 / 2 = 35
		System.out.printf("%d + %d * %d / 2 = %d\n", iNum1, iNum1, iNum2, iNum1+iNum1*iNum2/2);
		
		// 패턴 연습
		int iNum3 = 3;
		System.out.printf("%d\n", iNum3);
		System.out.printf("%5d\n", iNum3);		// 5칸 공간 확보 후 오른쪽 정렬
		System.out.printf("%-5d\n", iNum3);		// 5칸 공간 확보 후 왼쪽 정렬

		// 소수점 자리 제어(반올림 처리)
		System.out.printf("%f\n", 10/4.0);		// 2.500000  (기본 소수점 6자리)
		System.out.printf("%.2f\n", 10/4.0);	// 2.50		 (소수점 2자리까지)
		System.out.printf("%.8f\n", 8/3.0);		// 2.66666667(소수점 8자리까지)
		System.out.printf("%.0f\n", 10/4.0);	// 소수점 아래 반올림
		
		// 문자, 문자열, boolean
		boolean isTrue = false;
		char ch = '가';
		String str = "안녕하세요~!";			// 참조형
		
		// false / 가 / 안녕하세요~! 띄우기
		System.out.printf("%b / %c / %s\n", isTrue, ch, str);
		
		// escape 문자 : 일반 문자가 아닌 특수문자 표현, \쓰고 표현하고자 하는 문자
		// 종류 : \n(줄바꿈), \t(탭), \'(홑따옴표), \"(쌍따옴표), \\(역슬래쉬) 등
		System.out.println("\\o/");				// \o/ 표현하기

		// tab : 한공간씩 표현X, 한번에 공간 차지
		System.out.println("a\tb\tc\td");		// \t 이용(문자끼리 붙어있어도 됨)
		
		// 유니코드(16진수) 이스케이프
		System.out.println("\u0041");			// A(65를 16진수로 표현)
	}
}
