package edu.kh.practice.snack.view;
/* MVC 모델 :
 * Model : vo(값 저장용 객체) , service
 * View : 사용자에게 보여줄 응답화면과 관련된 코드가 모인 패키지
 * Controller : 사용자의 요청을 받아 처리하고, 그 입력에 따라 
 *    Model(데이터 처리, 비즈니스 로직)과 View(화면출력)를 연결해주는 역할
 * */

/* 웹서비스의 기본 형태(사용자(클라이언트), 서버)
 * 사용자가 서버에 요청하면 서버가 사용자에게 응답
 * Controller 가 요청을 받음 -> 알맞은 Service 쪽으로 요청을 보냄
 * Service 쪽에서는 DB에서 조회 삭제 삽입 하는 등 역할을 요청
 * DB가 필요한 역할 수행하고, Service 쪽에 보냄
 * Controller 가 알맞은 View 를 선택하여 클라이언트에게 응답해줌
 * */

import java.util.Scanner;
import edu.kh.practice.snack.controller.SnackController;

public class SnackMenu {
	
	// 필드, 멤버변수
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	// 생성자
	
	// 메서드
	public void menu() {			
		// 사용자가 Snack객체에 데이터를 저장할 수 있도록 값을 받고 저장된 값을 출력하는 메서드
		System.out.println("스낵류를 입력하세요.");
		
		System.out.print("종류 : ");
		String inputKind = sc.next();
		
		System.out.print("이름 : ");
		String inputName = sc.next();
		
		System.out.print("맛 : ");
		String inputFlavor = sc.next();
		
		System.out.print("개수 : ");
		int inputNumOf = sc.nextInt();
		
		System.out.print("가격 : ");
		int inputPrice = sc.nextInt();
		
		System.out.print(scr.savaData(inputKind, inputName, inputFlavor, inputNumOf, inputPrice));
		
//		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
		char confirm = sc.next().charAt(0);			// String 으로 비교해도 됨!(선생님 풀이)
		
		if(confirm== 'y' || confirm =='Y') System.out.println(scr.confirmData());
		else if(confirm =='n' || confirm =='N') return;
		else System.out.println("잘못된 문자를 입력하셨습니다.");
		
	}

}
