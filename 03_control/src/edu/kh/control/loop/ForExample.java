package edu.kh.control.loop;

import java.util.Scanner;

public class ForExample {			// 기능 제공용 클래스
	
	Scanner sc = new Scanner(System.in);

	public void ex1() {		// for 문 이용하여 1부터 10까지 출력
		for(int i=1; i<=10; i++) System.out.println(i);
	}
	
	public void ex2() {		// 알파벳 A-Z까지 한 줄로 출력

		for(int i='A'; i<='Z'; i++) System.out.print((char)i);	// 강제 형변환 이용 시
		System.out.println("\n==========================");
		for(char i='A'; i<='Z'; i++) System.out.print(i);		// char 자료형 이용 시
	}
	
	public void ex3() {		// 1부터 입력받은 수까지 1씩 증가하며 출력
		
		System.out.print("입력 번호 : ");
		int input = sc.nextInt();
		
		for(int i=1; i<=input; i++) {
			System.out.printf("%d ", i);
		}
	}
	
	public void ex4() {		// 정수 5개를 입력받아서 합계 구하기
		
		int sum=0;
		
		for(int i=1; i<=5; i++) {
			System.out.printf("입력 %d : ",i);
			int input = sc.nextInt();
			sum += input;		// sum 에 입력받은 input 값 누적
		}

		System.out.println("합계 : "+sum);		
	}
	
	public void ex5() {		// 1부터 20까지 1씩 증가하면서 출력
								// 단, 입력받은 수의 배수는 양쪽에 () 표시
		
		System.out.printf("괄호를 표시할 배수 : ");
		int num = sc.nextInt();
		
		for(int i=1; i<=20; i++) {
			if(i%num == 0) System.out.print("(" + i + ") ");
			else System.out.print(i+" ");
		}
	}
	
	public void ex6() {		// 구구단 출력(2 ~ 9 사이의 수 입력받아 해당 단 출력)
							// 2 ~ 9 이외의 수입력시 "잘못 입력하셨습니다"
		
		System.out.print("단 입력 : ");
		int inputDan = sc.nextInt();
		
		if ((inputDan <2) || (inputDan>9)) System.out.println("잘못 입력하셨습니다");
		else {
			for(int i =1; i<=9; i++) {
				System.out.printf("%d X %d = %d\n", inputDan, i, inputDan*i);
			}
			System.out.println("===========================");
		}
	}
	
	public void ex7() {		// 구구단 모두 출력, 역순 모두 출력
		
		// 구구단 모두 출력
		for(int dan = 2 ; dan<=9 ; dan++) {
			for( int num=1; num<=9; num++) {
				System.out.printf("%d X %d = %2d  ", dan, num, dan*num);
			}								// %nd n칸 마련 후 오른쪽 정렬
			System.out.println();
		}
		System.out.println("=================================================");
		
		// 구구단 역순 모두 출력
		for(int dan = 9; dan>=2; dan--) {
			for(int num=1; num<=9; num++) {
				System.out.printf("%d X %d = %2d  ", dan, num, dan*num);
			}
			System.out.println();
		}
	}
	
	public void ex8() {		// 숫자 세기 count(1 ~ 20 사이)
		// 1부터 20까지 1씩 증가하면서 입력받은 수의 배수의 총 개수 출력
		// 입력받은 수의 배수의 합계 출력

		int count = 0;
		int sum=0;
		String result = "";
		
		System.out.print("배수 입력 : ");
		int input = sc.nextInt();
		
		for(int i=1; i<=20; i++) {
			if(i%input ==0) {
				result += i+" ";
				count++;
				sum += i;
			}
		}
		
		System.out.printf("%s : %d개\n", result, count);
		System.out.printf("%d의 배수 합계 : %d\n", input, sum);
	}
}
