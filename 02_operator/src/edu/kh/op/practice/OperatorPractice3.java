package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice3 {
	
	public void practice1() {	// true 일 때 문제 있음... -> 해결 완료

		Scanner sc = new Scanner(System.in);
		
		System.out.print("가격을 입력 하세요 : ");
		double price = sc.nextDouble();
		
		System.out.print("멤버십 있으세요? (있으면 true / 없으면 false 입력) : ");
		boolean membership = sc.nextBoolean();
		
		double result = membership == true ? price * 0.9 : price * 0.95;
		
		System.out.printf("할인을 포함한 최종금액 : %.1f원", result);
	}

	public void practice2() {	// 출금할 금액 입력시 최소 개수 지폐 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("출금할 금액 입력 : ");
		int withdrawal = sc.nextInt();
		
		int result50000 = withdrawal/50000;
		int result10000 = (withdrawal - 50000*result50000)/10000;
		int result5000 = (withdrawal - 50000*result50000 - 10000*result10000)/5000;
		int result1000 = (withdrawal - 50000*result50000 - 10000*result10000 - 5000*result5000)/1000;
		
		System.out.printf("50000원 : %d\n10000원 : %d\n5000원 : %d\n1000원 : %d", result50000, result10000, result5000, result1000);
	}
	
	public void practice3() {	// 두 개의 정수를 입력받아 배수인지 아니지 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 수 : ");
		int firstNum = sc.nextInt();
		System.out.print("두 번째 수 : ");
		int secondNum = sc.nextInt();
		
		String result = firstNum % secondNum == 0 ? "배수입니다" : "배수가 아닙니다";
		System.out.println(result);
	}
}
