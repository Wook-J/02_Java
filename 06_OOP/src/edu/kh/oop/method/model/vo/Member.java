package edu.kh.oop.method.model.vo;

public class Member {		// 속성 + 기능
	
	// 필드
	private String memberId;	// 아이디
	private String memberPw;	// 비밀번호
	private String memberName;	// 이름
	private int memberAge;		// 나이
	
	// 생성자 : 오버로딩이 적용되어 같은 Member라도 오류 X (매개변수의 개수 or 타입 or 순서 다름)
	public Member() {}		// 기본 생성자, ctrl + space -> enter

	public Member(String memberId, String memberPw, String memberName, int memberAge) {	//매개변수 생성자
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
	}

	// 메서드
	
	
	
	
	// getter, setter (메서드 종류 중 하나임!, 자동완성기능 있음 alt shift s)
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

}
