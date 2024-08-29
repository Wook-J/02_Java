package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 나이는? : ");
		int personAge = sc.nextInt();
		String result1 = personAge >= 20 ? "저는 성인입니다" : "저는 미성년입니다";
		String result2 = ((personAge >= 13) && (personAge <= 19)) ? "true" : "false";
		String result3 = ((personAge >= 65) || (personAge <= 12)) ? "true" : "false";
		
		System.out.println(result1);
		System.out.printf("청소년 입니까? %s\n", result2);
		System.out.printf("노인이거나 어린이 입니까? %s\n", result3);

	}

}
