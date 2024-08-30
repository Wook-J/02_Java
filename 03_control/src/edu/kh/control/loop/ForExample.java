package edu.kh.control.loop;

public class ForExample {			// 기능 제공용 클래스

	public void ex1() {			// for문 이용하여 1부터 10까지 출력
		for(int i=1; i<=10; i++) System.out.println(i);
	}
	
	public void ex2() {			// 알파벳 A-Z까지 한 줄로 출력

		for(int i='A'; i<='Z'; i++) System.out.print((char)i);	// 강제 형변환 이용 시
		System.out.println("\n==========================");
		for(char i='A'; i<='Z'; i++) System.out.print(i);		// char 자료형 이용 시
		
	}
}
