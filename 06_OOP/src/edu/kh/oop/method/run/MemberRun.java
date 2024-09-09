package edu.kh.oop.method.run;

import edu.kh.oop.method.model.service.MemberService;

public class MemberRun {

	public static void main(String[] args) {
		
		MemberService service = new MemberService();	// 기본 생성자(매개변수가 없는 생성자)
		// MemberService의 기본 생성자가 작성되어 있지 않지만 컴파일러가 코드를 번역할 때
		// 클래스 내부에 생성자가 하나도 없다면 자동으로 기본 생성자를 추가해줌!
		// -> 문제없이 기본 생성자를 사용할 수 있음!
		
		// ** 주의사항 **
		// 만약 매개변수 생성자가 하나라도 있으면 기본 생성자를 자동생성하지 않음!
		
		service.displayMenu();
	}

}


// 메서드 정의, 호출, 반환하는 것은 java 하면서 절대 까먹으면 안됨!!!!
// 메서드 -> 매개변수, 전달인자
// 생성자 -> 기본 생성자, 매개변수 생성자
