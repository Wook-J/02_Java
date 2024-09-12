package edu.kh.poly.ex2.run;

import edu.kh.poly.ex2.model.service.AbstractService;
import edu.kh.poly.ex2.model.service.Calculator;
import edu.kh.poly.ex2.model.service.WJCalculator;

public class AbstractRun {

	public static void main(String[] args) {

		AbstractService service = new AbstractService();
//		service.ex1();
		service.ex2();
		// ===============================================
		Calculator cal = new WJCalculator();
		System.out.println("합 : " + cal.plus(20, 30));
		System.out.println("차 : " + cal.minus(20, 30));
		System.out.println("곱 : " + cal.multiple(20, 30));
		System.out.println("몫 : " + cal.divide(20, 30));
		
		// 인터페이스 == 미완성 설계도 : 객체 생성 불가능
		// -> 참조변수로서는 사용 가능
		
		// 코드의 큰 수정 없이 객체 생성코드(new ~)만 바꾸면 새로운 클래스 코드를 수행할 수 있음
		
		// 인터페이스 특징
		// 1) 인터페이스를 부모 참조변수로 사용하면 다형성 중 업캐스팅이 적용되서
		//    상속받은 모든 클래스를 자식 객체로 참조할 수 있음
		//    -> 이를 이용해 중요한 메인 코드의 수정을 최소화할 수 있음!
		
		// 2) 자식 클래스에 공통된 메서드를 강제구현하라고 하기 때문에
		//    모든 자식 클래스가 동일한 형태를 띄게 됨
		//    -> 이를 이용해 공동작업(팀프로젝트)에 필요한 개발환경 조성이 용이함!
	}

}
