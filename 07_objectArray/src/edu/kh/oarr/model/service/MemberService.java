package edu.kh.oarr.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {

	// 속성(필드, 멤버변수)
	private Scanner sc = new Scanner(System.in);
	private Member[] memberArr = new Member[5];		// Member 5칸짜리 객체배열 선언 및 할당
	private Member loginMember = null;	// 현재 로그인한 회원의 정보를 저장할 참조변수 선언
	
	// 생성자
	public MemberService() {			// 기본생성자 만들시 memberArr 배열의 0,1,2 인덱스 초기화
		memberArr[0] = new Member("user01", "pass01", "홍길동", 30, "서울");
		memberArr[1] = new Member("user02", "pass02", "계보린", 25, "경기");
		memberArr[2] = new Member("user03", "pass03", "고길동", 45, "강원");
	}
	
	// 메서드
	// (1) 메뉴출력용 메서드
	public void displayMenu() {
		int menuNum = 0;				// 메뉴선택용 변수
		
		do {							// 최초 1번은 무조건 실행
			System.out.println("===== 회원 정보 관리 프로그램 v2 =====");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 검색(지역)");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			menuNum = sc.nextInt();
			sc.nextLine(); 				// 입력 버퍼에 남은 개행문자 제거
			
			switch(menuNum) {
			case 1: System.out.println( signUp() ); break;		// (3) 회원 가입 메서드
			case 2: System.out.println( login() ); break;		// (4) 로그인 메서드
			case 3: System.out.println( selectMember() ); break;// (5) 회원 정보 조회 메서드
			case 4: 											// (6) 회원 정보 수정 메서드
				int result = updateMember();
				if(result == -1) System.out.println("로그인을 먼저 하세요!!\n");
				else if(result == 1) System.out.println("변경 성공!\n");
				else System.out.println("변경 실패!!! 비밀번호 불일치\n");
				break;					
			case 5: searchRegion(); break;						// (7) 회원 검색(지역) 메서드
			case 0: System.out.println("프로그램 종료..."); break;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력하세요!\n"); break;
			}
		}while(menuNum != 0);			// menuNum이 0이 되면 반복 종료
	}
	
	// (2) memberArr의 비어있는 인덱스 번호를 반환하는 메서드, 단 비어있는 인덱스가 없다면 -1 반환
	public int emptyIndex() {
		
		// memberArr 배열을 0번 인덱스부터 끝까지 접근해서 참조하는 값인지 null 인 경우 인덱스 반환
		for(int i=0; i<memberArr.length; i++) {
			if (memberArr[i] == null) return i;
		}
		
		return -1;		// for 문 수행했으나 return 되지 않은 경우(memberArr에 빈칸이 없는경우)
	}
	
	// (3) 회원 가입 메서드
	public String signUp() {
		System.out.println("\n======= 회원 가입 =======");
		
		// 객체배열 memberArr에 새로 가입할 회원정보를 저장할 예정
		// -> 새로운 회원 정보를 저장할 공간이 있는지 확인하고, 빈 공간에 인덱스 번호 얻어오기
		int index = emptyIndex();	// (2) 비어있는 인덱스 번호 반환 메서드
		
		if(index == -1)	return "회원가입 불가능합니다(인원수 초과)\n";
		
		// if 문 탈출! -> 회원가입 가능하므로 가입할 정보 입력받기
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
		
		System.out.print("지역 : ");
		String region = sc.next();
		
		// 비밀번호 일치하는 지 확인
		if(memberPw.equals(memberPw2)) {	// 일치하는 경우
			memberArr[index] = new Member(memberId, memberPw, memberName, memberAge, region);
			return "회원 가입 성공!!!\n";
		}else return "회원 가입 실패!!! (비밀번호 불일치)\n";
	}
	
	// (4) 로그인 메서드
	public String login() {
		System.out.println("\n======= 로그인 =======");
		
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
		
		// memberArr 배열 내 요소를 순서대로 접근하여 null 이 아닌지 확인
		for(int i=0; i<memberArr.length; i++) {
			if(memberArr[i] != null) {		// 회원정보가 있을 경우
				if(memberArr[i].getMemberId().equals(memberId) && memberArr[i].getMemberPw().equals(memberPw)) {
					// (로그인 회원 정보 객체를 참조할 변수 loginMember)에
					// (현재 접근중인 memberArr[i] 요소에 저장된 주소)를 얕은 복사
					loginMember = memberArr[i];
					break;	// 더 이상 같은 id, pw 가 없으므로 효율을 위해 for 문 종료
				}
			}
		}
		
		// 로그인 성공/실패 여부에 따라 결과 값 반환
		if(loginMember == null) return "아이디 또는 비밀번호가 일치하지 않습니다.\n";
		else return loginMember.getMemberName() + "님 환영합니다!\n";
	}
	
	// (5) 회원 정보 조회 메서드
	public String selectMember() {
		System.out.println("\n======= 회원 정보 조회 ======");
		
		if(loginMember != null) {
			return "이름 : " + loginMember.getMemberName()
					+ "\n아이디 : " + loginMember.getMemberId()
					+ "\n나이 : " + loginMember.getMemberAge() + "세"
					+ "\n지역 : " + loginMember.getRegion() + "\n";
		}else return "로그인을 먼저 하세요!!\n";
	}
	
	// (6) 회원 정보 수정 메서드
	public int updateMember() {
		System.out.println("\n======= 회원 정보 수정 =======");
		
		// 로그인 여부 판별
		if(loginMember == null) return -1;
		
		// 수정할 회원 정보 입력 받기 (이름, 나이, 지역)
		System.out.print("이름 : ");
		String inputName = sc.next();
		
		System.out.print("나이 : ");
		int inputAge = sc.nextInt();
		
		System.out.print("지역 : ");
		String inputRegion = sc.next();

		// 비밀번호를 입력받아서 로그인한 회원의 비밀번호와 일치하는지 확인
		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.next();
		
		if(loginMember.getMemberPw().equals(inputPw)) {
			loginMember.setMemberName(inputName);
			loginMember.setMemberAge(inputAge);
			loginMember.setRegion(inputRegion);
			return 1;
		}else return 0;
	}
	
	// (7) 회원 검색(지역) 메서드
	public void searchRegion() {
		System.out.println("\n======= 회원 검색(지역) =======");
		
		System.out.print("검색할 지역을 입력하세요 : ");
		String inputRegion = sc.next();
		
		boolean flag = true;	// 검색 결과 신호용 변수
		
		for(int i=0; i<memberArr.length; i++) {	// memberArr 의 모든 요소를 순차접근
			if(memberArr[i] == null) break;		// memberArr[i] == null 이면 반복 종료
			
			// memberArr[i] 요소에 저장된 지역(region)이 입력받은 지역(inputRegion)과 같을 경우,
			// memberArr[i] 요소에 저장된 객체의 회원의 아이디, 이름을 출력
			if(memberArr[i].getRegion().equals(inputRegion)) {
				System.out.printf("아이디 : %s, 이름 : %s\n", memberArr[i].getMemberId(), memberArr[i].getMemberName());
				flag = false;	// 찾았다는 신호 
			}
		}
		
		if(flag) System.out.println("일치하는 검색결과가 없습니다!");
		System.out.println();
	}
}