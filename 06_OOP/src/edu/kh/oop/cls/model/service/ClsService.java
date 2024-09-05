package edu.kh.oop.cls.model.service;

import edu.kh.oop.cls.model.vo.Student;
//import edu.kh.oop.cls.model.vo.TestVO;
import edu.kh.oop.cls.model.vo.User;

// ClsService 와 Student 는 패키지가 서로 다름
public class ClsService /*extends Student*/ {
						// 부모로 Student 클래스를 상속받는 경우 사용!
						// Student(부모), ClsService(자식) 관계가 됨!!
	
	// public ClsService (){} // 기본생성자(작성한적 없음)
	
	public void ex1() {
		// 클래스 접근제한자 확인하기
		Student std = new Student();
		// public class 인 Student 는 import 가능(어디서든 접근 가능)
		
		//TestVO test = new TestVO();
		// (default) class 인 testVO는 import 불가능(다른 패키지라 불가능!)
		
		//-----------------------------------------------------------------
		// 필드 접근제한자 확인하기
		System.out.println(std.v1);		// 전체에서 직접접근 가능한 public
//		System.out.println(std.v2);		// 후손 클래스 아니므로 직접접근 불가능(상속 전)
//		System.out.println(std.v3);		// 같은 패키지 아니므로 직접접근 불가능
//		System.out.println(std.v4);		// 해당 클래스 아니므로 직접접근 불가능
		
		// 상속 관계에서 직접접근 가능 범위 테스트 extends Student 부분 주석 해제하는 경우
//		System.out.println(v1);			// public - 프로그램 전체에서 직접접근 가능
//		System.out.println(v2);			// Student 클래스 상속 받았으므로 Student 의
//										   protected 변수인 v2는 직접접근 가능
//		System.out.println(v3);			// (default) 같은 패키지 아니므로 직접접근 불가능
//		System.out.println(v4);			// private 해당 클래스 아니므로 직접접근 불가능
	}
	
	public void ex2() {
		// static 필드 확인 예제
		
		// 학생 객체 2개 생성
		Student std1 = new Student();
		Student std2 = new Student();
		
		// 학생 객체에 name 세팅
		std1.setName("홍길동");
		std2.setName("김영희");
		
		System.out.println(std1.schoolName);
		System.out.println(std2.schoolName);
		// schoolName에 노란줄(경고)이 뜨는 이유 : 제대로 작성X
		// static 이 붙은 필드(변수)는 '클래스명.변수명'으로 사용함!
		// 위에서는 객체명.schoolName으로 호출함
		System.out.println(Student.schoolName);		// 제대로 작성하는 경우
		
		Student.schoolName = "KH정보교육원";
		
		System.out.println(std1.schoolName);
		System.out.println(std2.schoolName);
		System.out.println(Student.schoolName);
		
		/* static : 공유 메모리 영역(또는 정적 메모리 영역)
		 * - 프로그램 시작 시 static 가 붙은 코드들이 모두 static 영역에 생성되고,
		 *   프로그램이 종료될 때까지 사라지지 않음 (정적)
		 *   
		 * - static 영역에 생성된 변수는 어디서든지 공유 가능 (공유)
		 * */
	}
	
	public void ex3() {
		// 생성자 확인 테스트
		
		// User 기본 생성자를 이용해서 객체 생성 u1
		User u1 = new User();
		
		System.out.println(u1.getUserId());
		System.out.println(u1.getUserPw());
		System.out.println(u1.getUserName());
		System.out.println(u1.getUserAge());
		System.out.println(u1.getUserGender());
		
		User u2 = new User();
		
		System.out.println(u2.getUserId());
		System.out.println(u2.getUserPw());
		System.out.println(u2.getUserName());
		System.out.println(u2.getUserAge());
		System.out.println(u2.getUserGender());
		
		// 문제점 : u1이 참조하고 있는 User 객체와 
		//			u2가 참조하고 있는 User 객체의 필드값이 모두 동일
		// 왜? 같은 기본생성자로 User 객체를 생성했기 때문!
		
		System.out.println("-----------------------------------");
		
		// 해결방법 1 : setter 를 이용해서 새로운 값 대입
		u2.setUserId("asd1234");
		u2.setUserPw("1q2w3e");
		u2.setUserName("김영희");
		u2.setUserAge(25);
		u2.setUserGender('여');
		
		System.out.println(u2.getUserId());
		System.out.println(u2.getUserPw());
		System.out.println(u2.getUserName());
		System.out.println(u2.getUserAge());
		System.out.println(u2.getUserGender());
		
		System.out.println("-----------------------------------");
		
		// 해결방법 2 : 매개변수 생성자를 이용해서 객체가 생성될 때부터
		//				다른 값으로 필드를 초기화
		User u3 = new User("test3","password33");		// 전달인자 있음!
		System.out.println(u3.getUserId());
		System.out.println(u3.getUserPw());
	}
	
	public void ex4() {
		// 매개변수 생성자 예제
		User u1 = new User();						// 기본생성자
		User u2 = new User("user02", "pass02");		// 매개변수 2개 생성자
		User u3 = new User("user03", "pass03", "김길동", 30, '남');	// 매개변수 5개 생성자(전부초기화)
		
		System.out.printf("u1 : %s / %s / %s / %d / %c\n", u1.getUserId(), u1.getUserPw(), u1.getUserName(), u1.getUserAge(), u1.getUserGender());
		System.out.printf("u2 : %s / %s / %s / %d / %c\n", u2.getUserId(), u2.getUserPw(), u2.getUserName(), u2.getUserAge(), u2.getUserGender());
		System.out.printf("u3 : %s / %s / %s / %d / %c\n", u3.getUserId(), u3.getUserPw(), u3.getUserName(), u3.getUserAge(), u3.getUserGender());
	}

}
