package edu.kh.oarr.run;

import edu.kh.oarr.model.service.MemberService;

public class MemberRun {
	public static void main(String[] args) {
		
		// 기본생성자 이용하여 MemberService 생성!
		MemberService service = new MemberService();
		
		service.displayMenu();
	}
}
