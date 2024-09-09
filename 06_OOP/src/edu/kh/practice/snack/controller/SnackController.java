package edu.kh.practice.snack.controller;
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

import edu.kh.practice.snack.model.vo.Snack;

public class SnackController {
	
	// 필드, 멤버변수
	private Snack s = new Snack();
	
	// 생성자
	public SnackController() {}		// 기본생성자, 없어도 됨(여기선 다른 매개변수 생성자 없으므로)
	
	// 메서드
	public String savaData(String kind, String name, String flavor, int numOf, int price) {
		
		// 데이터를 setter를 이용해 저장하고 저장완료되었다는 결과를 반환하는 메서드
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);;
		s.setPrice(price);
	
		return "저장 완료되었습니다.\n"
				+ "저장한 정보를 확인하시겠습니까?(y/n) : " ;
	}
	
	public String confirmData() {				// 저장된 데이터를 반환하는 메서드
		return s.information();
	}
}
