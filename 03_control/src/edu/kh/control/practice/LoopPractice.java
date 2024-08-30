package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {		// 숫자를 입력받아 1부터 그 숫자까지 모두 출력
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int inputNum = sc.nextInt();
		
		if(inputNum<1) System.out.println("1 이상의 숫자를 입력해주세요.");
		else {
			for(int i=1; i<=inputNum; i++) System.out.print(i+" ");
		}
	}
	
	public void practice2() {		// 숫자를 입력받아 그 숫자부터 1까지 모두 출력
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int inputNum = sc.nextInt();
		
		if(inputNum<1) System.out.println("1 이상의 숫자를 입력해주세요.");
		else {
			for(int i=0; i<inputNum; i++) System.out.print((inputNum-i) + " ");
		}
	}
	
	public void practice3() {		// 숫자를 입력받아 1부터 그 수까지의 정수들의 합

		System.out.print("정수를 하나 입력하세요 : ");
		int inputNum = sc.nextInt();
		int sum = 0;
		
		for(int i=1; i<=inputNum; i++) {
			sum += i;
			System.out.print(i+" ");
			if(i==inputNum) System.out.print("= "+ sum);
			else System.out.print("+ ");
		}
	}
	
	public void practice4() {		// 2개의 숫자를 입력받아 그 사이의 정수 출력
		
		System.out.print("첫 번째 숫자 : ");
		int inputNum1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int inputNum2 = sc.nextInt();
		
		if((inputNum1<=0) || (inputNum2<=0)) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else if(inputNum1 <= inputNum2) {
			for (int i= inputNum1; i<=inputNum2; i++) {
				System.out.print(i+" ");
			}
		} else {
			for (int i= inputNum2; i<=inputNum1; i++) {
				System.out.print(i+" ");
			}
		}
	}
	
	public void practice5() {		// 입력받은 숫자의 단을 출력
		
		System.out.print("숫자 : ");
		int inputNum = sc.nextInt();
		
		System.out.printf("===== %d단 =====\n", inputNum);
		for(int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %d\n", inputNum, i, inputNum*i);
		}
	}
	
	public void practice6() {		// 입력받은 숫자부터 9단까지 출력(2~9사이만)
		
		System.out.print("숫자 : ");
		int inputNum = sc.nextInt();
		
		if((inputNum<2) || (inputNum>9)) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
		} else {
			for(int i=inputNum; i<=9; i++){
				System.out.printf("===== %d단 =====\n", i);
				
				for(int j=1; j<=9; j++) {
					System.out.printf("%d * %d = %d\n", i, j, i*j);
				}
			}
		}	
	}
	
	public void practice7() {		// *찍기 예제1
		
		System.out.print("정수 입력 : ");
		int inputNum = sc.nextInt();
		
		for (int i=1; i<=inputNum; i++) {
			for(int j=1; j<=i; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice8() {		// *찍기 예제2
		
		System.out.print("정수 입력 : ");
		int inputNum = sc.nextInt();
		
		for(int i=inputNum; i>0; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice9() {		// *찍기 예제3
		
		System.out.print("정수 입력 : ");
		int inputNum = sc.nextInt();
		
		for(int i=1; i<=inputNum; i++) {
			for(int j=1; j<=inputNum; j++) {
				if(i+j<=inputNum) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice10() {		// *찍기 예제4
		
		System.out.print("정수 입력 : ");
		int inputNum = sc.nextInt();
		
		for (int i=1; i<=inputNum; i++) {
			for(int j=1; j<=i; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=(inputNum-1); i>0; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice11() {		// *찍기 예제5
		
		System.out.print("정수 입력 : ");
		int inputNum = sc.nextInt();
		
		for(int i=1; i<=inputNum; i++) {
			for(int j=1; j<=(2*inputNum-1); j++) {
				if((j>inputNum-i) && (j<inputNum+i)) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public void practice12() {		// *찍기 예제6
		
		System.out.print("정수 입력 : ");
		int inputNum = sc.nextInt();
		
		for(int i=1; i<=inputNum; i++) {
			for(int j=1; j<=inputNum; j++) {
				if((i==1) || (i==inputNum)) {
					System.out.print("*");
				}else {
					if((j==1)||(j==inputNum)) System.out.print("*");
					else System.out.print(" ");
				}
			}
			System.out.println();
		}	
	}
	
	public void practice13() {		// 2 또는 3의 배수, 2와 3의 공배수의 개수 출력
		
		System.out.print("자연수 하나를 입력하세요 : ");
		int inputNum = sc.nextInt();
		int count = 0;
		
		for(int i=1; i<=inputNum; i++) {
			if((i%2==0)||(i%3==0)) {
				System.out.print(i+" ");
			}
			if(i%6==0) count++;
		}
		System.out.println();
		System.out.println("count : "+count);
		
	}
}
