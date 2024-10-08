package edu.kh.control.branch;

import java.util.Scanner;

public class BranchExample {
	
	Scanner sc = new Scanner(System.in);

	public void ex1() {		// 1부터 10까지 1씩 증가하며 출력(단 5출력 시 종료)
		
		for(int i=1; i<=10; i++) {
			System.out.print(i + " ");
			if (i==5) break;
		}
	}
	
	public void ex2() {		// 입력받은 모든 문자열을 누적
							// 단, "exit@" 입력 시 문자열 누적을 종료하고 결과 출력
		String str="";		// 빈 문자열
		
		while(true) {
			System.out.print("문자열 입력(exit@ 입력 시 종료) : ");
			String input = sc.nextLine();
			
			// next() : 다음 한 단어 (띄어쓰기 포함 X)
			// nextLine() : 다음 한 줄 (띄어쓰기 포함O)
			
			// 자바에서 문자열(String) 비교는 == 연산자 사용불가(기본자료형만 가능)
			// String 은 기본자료형이 아닌 참조형!!!!!!
			
			// 문자열1.equals(문자열2) 의 형태로 씀!!!!! 잊지 말기!!!!!!!!!!
			// -> 문자열1과 문자열2가 같으면 true/ 다르면 false 반환
			if(input.equals("exit@")) break;
			
			str += input +"\n";
		}
		
		System.out.println("==================================");
		System.out.println(str);
	}
	
	public void ex3() {		// 1부터 10까지 1씩 증가하며 출력(단 3의 배수 제외)
		
		for(int i=1; i<=10; i++) {
			if (i%3==0) continue;
			
			System.out.print(i + " ");
		}
	}
	
	public void ex4() {		// 1부터 100까지 1씩 증가하며 출력(추가조건 있음)
							// 5의 배수는 건너뜀, 40이 되었을 때 반복 멈춤
		for(int i=1; i<=100; i++) {
			if(i==40) break;
			if(i%5==0) continue;
			System.out.print(i+" ");
		}
	}

	public void RSPGame() {	// 메서드명은 소문자로 시작하는 것이 관레임!
		
		// 가위바위보 게임
		// 몇 판 할지 입력받고, 입력받을 판수 만큼 반복
		// 컴퓨터 : Math.random() -> 0.0 <= x < 1.0 범위 내 난수 생성
		// 1~3 사이 난수 생성 : 1이면 가위, 2이면 바위, 3이면 보
		// 컴퓨터와 유저 가위바위보 판별
		// 플레이어 승! / 졌습니다ㅠㅠ
		// 매판마다 - 현재 기록 : 2승 1무 0패
		
		System.out.println("[가위 바위 보 게임~!!]");
		System.out.print("몇 판 ? : ");
		int round = sc.nextInt();
		
		int win = 0;
		int lose = 0;
		int draw = 0;
		
		for(int i=1; i<=round; i++) {
			System.out.println("\n"+i+"번째 게임");
			System.out.print("가위/바위/보 중 하나를 입력 : ");
			String input = sc.next();
			
			int random = (int) (Math.random()*3 + 1);	// int형으로 강제 형변환
			
			String com = null;		// null : 아무것도 참조하고 있지 않음

			switch(random) {
			case 1: com = "가위"; break;
			case 2: com = "바위"; break;
			case 3: com = "보"; break;
			}
			
			System.out.printf("컴퓨터는 [%s]를 선택했습니다.\n", com);
			
			if(input.equals(com)) {
				System.out.println("비겼습니다.");
				draw++;
			}else {
				boolean win1 = input.equals("가위") && com.equals("보");
				boolean win2 = input.equals("바위") && com.equals("가위");
				boolean win3 = input.equals("보") && com.equals("바위");
				
				if(win1 || win2 || win3) {
					System.out.println("플레이어 승!");
					win++;
				}else {
					System.out.println("졌습니다.");
					lose++;
				}
			}
			System.out.printf("현재 기록 : %d승 %d무 %d패\n", win, draw, lose);
		}	// for 문 끝
	}
}