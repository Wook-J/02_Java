package edu.kh.oop.method.model.service;

import java.util.Scanner;
import edu.kh.oop.method.model.vo.Member;

public class MemberService {
	
	// 속성 (필드)
	private Scanner sc = new Scanner(System.in);
	
	private Member memberInfo = null;		// 가입한 회원의 정보를 저장할 변수, 현실에선 DB에 저장됨
	private Member loginMember = null;		// 로그인한 회원의 정보를 저장할 변수
	
	// 기능(생성자, 메서드) 생성자 아무것도 안만들면 기본 생성자가 자동으로 생성됨!
	
	// 메뉴화면 출력
	public void displayMenu() {
		int menuNum = 0;					// 메뉴 선택용 변수
		
		do {								// do ~ while문 최초 1번은 무조건 수행
			System.out.println("===== 회원 정보 관리 프로그램 =====");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			menuNum = sc.nextInt();
			sc.nextLine();					// 입력버퍼에 남은 개행문자 제거용
			
			switch(menuNum) {
			case 1: System.out.println( signUp() ); break;			// 회원가입
			case 2: System.out.println( login() ); break;			// 로그인
			case 3: System.out.println( selectMember() ); break;	// 회원 정보 조회
			case 4: 
				int result = updateMember();
				
				if(result == -1 ) System.out.println("로그인 후 이용 바람\n");
				else if(result == 0 ) System.out.println("회원정보 수정 실패(비밀번호 불일치)\n");
				else System.out.println("회원정보가 수정되었습니다!\n");	// result == 1
				
				break;
			case 0: System.out.println("프로그램 종료..."); break;
			default: System.out.println("잘못 입력하셨습니다. 메뉴에 있는 번호만 입력해주세요!");  break;
			}
		}while(menuNum != 0);				// menuNum이 0이면 반복 종료
	}
	
	// 회원가입 기능
	public String signUp() {				// 메서드에 선언한 변수는 지역변수임
		System.out.println("\n****** 회원 가입 ******");
		
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		System.out.print("비밀번호 확인 : ");
		String memberPw2 = sc.next();
		
		System.out.print("이름 : ");
		String memberName = sc.next();
		
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		
		// (비밀번호 == 비밀번호확인) ? 회원가입 성공 : 회원가입 실패; (JS 표현)
		if(memberPw.equals(memberPw2)) {	// String 끼리의 비교는 Str1.equals(Str2)
			memberInfo = new Member(memberId, memberPw, memberName, memberAge);
			return "회원가입 성공!!!\n";
		}else return "회원가입 실패!! (비밀번호 불일치)\n";
	}
	
	// 로그인 기능
	public String login() {
		System.out.println("\n****** 로그인 ******");
		
		// 회원가입을 했는지 부터 확인 == memberInfo가 객체를 참조하고 있는지(null 인지 아닌지) 
		if(memberInfo == null) {			// 회원가입을 안한 경우
			return "회원가입부터 진행해주세요!\n";		// return 하면 그 값을 반환하면서 **해당 메서드 종료**
		}
		
		// 회원가입을 했다면, 로그인 기능을 수행
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		// 회원 가입 정보(memberInfo가 참조하는 Member객체)에 저장된 아이디, 비밀번호가
		// 입력받은 아이디, 비밀번호와 같으면 "로그인 성공"
		// 하나라도 같지 않으면 "아이디 또는 비밀번호 불일치"
		// -> 상세하게 풀어쓰면 아래와 같음
		// 로그인하려고 입력받은 (memberId)와 (memberInfo 필드에서 참조 중인 Member 객체의 memberId)가 같은지 및
		// 로그인하려고 입력받은 (memberPw)와 (memberInfo 필드에서 참조 중인 Member 객체의 memberPw)가 같은지 확인
		if( memberId.equals(memberInfo.getMemberId()) && memberPw.equals(memberInfo.getMemberPw()) ) {
			
			// loginMember에 memberInfo가 참조하고 있는 객체의 주소 대입 (얕은 복사)
			loginMember = memberInfo;
			
			// 회원가입 정보를 loginMember에 대입하여 어떤 회원이 로그인 했는지를 구분할 수 있게 함
			return loginMember.getMemberName()+ "님 환영합니다.\n";
		}else return "아이디 또는 비밀번호가 일치하지 않습니다!\n";

	}
	
	// 회원정보 조회 기능
	public String selectMember() {			// select : DB에서 조회라고 해석함
		
		System.out.println("\n******* 회원정보 조회 *******");

		if(loginMember == null) return "로그인 후 이용해주세요\n";	// 로그인 안한 경우
//		else {														// 로그인 한 경우
//			return "이름 : "+ loginMember.getMemberName() + 
//				   "\n아이디 : " + loginMember.getMemberId() +
//				   "\n나이 : " + loginMember.getMemberAge() + "\n";
//		} 내가 쓴 방법
		// return : 현재 메서드를 종료하고, 함수를 호출한 쪽으로 되돌아 가는 것
		// return 값 : 현재 메서드를 종료하고, 함수를 호출한 쪽으로 값을 가지고 되돌아 가는 것
		
		// 선생님 풀이, return 할때 변수로 하려는 경우
		String str ="이름 : "+ loginMember.getMemberName();
		str += "\n아이디 : " + loginMember.getMemberId();
		str += "\n나이 : " + loginMember.getMemberAge() + "세\n";
		
		return str;
	}

	// 회원정보 수정 기능
	public int updateMember() {			// return 형식의 다른 형태(호출한 곳에서 switch, if 등 사용)
		System.out.println("\n******* 회원정보 수정 *******");
		
		// 1) 로그인 여부 판별 : 로그인 되어있지 않으면 -1 반환
		if(loginMember == null) return -1;
		
		// 2) 수정할 회원정보 입력 받기(이름, 나이)
		System.out.print("수정할 이름 입력 : ");
		String inputName = sc.next();
		System.out.print("수정할 나이 입력 : ");
		int inputAge = sc.nextInt();
		
		// 3) 비밀번호를 입력받아 로그인한 회원의 비밀번호와 일치하는지 확인
		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.next();
		
		if(inputPw.equals(loginMember.getMemberPw()) ) {	// 일치하는 경우 
			loginMember.setMemberName(inputName);
			loginMember.setMemberAge(inputAge);
			return 1;
		} else return 0;									// 일치하지 않는 경우
	}

}

// CRUD(Create Read Update Delete) : 삽입 조회 수정 삭제