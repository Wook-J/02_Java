package edu.kh.oarr.model.vo;

public class Member {

	// 속성(필드, 멤버변수)
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String region;		// 지역(서울, 경기, ...)
	
	// 생성자 : 객체를 만들어주는 기능을 하는 메서드
	// 1. 생성자 이름은 클래스명과 같다.
	// 2. 반환형이 없다.
	// ** 기본생성자는 컴파일러가 자동으로 생성해주는데,
	//	  다른 생성자가 하나라도 있으면 기본생성자를 자동생성 안해줌
	// -> 매개변수 생성자가 있다면 기본생성자를 직접 작성해야 함
	
	// 1) : 기본생성자
	public Member() {}

	// 2) : 매개변수 생성자 : 오버로딩(매개변수의 타입, 순서, 개수) 적용 됨
	public Member(String memberId, String memberPw, String memberName, int memberAge, String region) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.region = region;
	}

	
	// 메서드
	
	// getter, setter  -> 왜 만들까?
	// 필드에 선언된 멤버변수들이 캡슐화 원칙에 의해 private 로 만들어져서, 다른 클래스에서 직접 접근 불가
	// -> 간접 접근 방식으로 값을 세팅/얻어올 수 있어야 함
	// -> 이를 이용하기 위해 getter/setter 는 접근제한자가 public 임.
	public String getMemberId() {
		// 반환형(String) : String 자료형을 해당 메서드를 호출한 쪽으로 돌려보내겠다
		
		return memberId;
		// 이 메서드를 호출한 쪽으로 memberId에 저장된 값을 돌려보냄
		// -> 매개변수가 없어서 중독된 이름의 memberId가 없기 때문에 this 참조변수 사용할 필요X
	}
	public void setMemberId(String memberId) {
		// 반환형(void) : 반환값이 없다, 작성된 코드를 수행하는 역할만 함
		this.memberId = memberId;
		// 모든 메서드는 종료 시 호출한 곳으로 돌아가는 return; 구문이 작성되어야 하지만,
		// 반환형이 void 일 경우 컴파일러가 자동으로 추가해줌
	}

	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}	
}
