package edu.kh.oop.abstraction.model.service;	// Service : 특정 기능(비즈니스 로직)을 제공하는 클래스

import edu.kh.oop.abstraction.model.vo.People;

public class AbstractionService {

	public void ex1() {					// People 클래스를 이용하여 국민 객체 만들기
		
		People p1 = new People();
		// People p1 : People 객체의 주소를 저장하여 참조하는 변수 p1
		// new People() : 새로운 People 객체를 Heap 영역에 생성
		
		// * 클래스 이름이 자료형(int, boolean, String 등등)처럼 사용되고 있음
		// -> People()이라는 객체를 넣으려면 그 상자가 People 형 이어야 함
		// -> 그래서 클래스를 "사용자 정의 자료형" 이라고도 부름!!!!
		
		/*		private 으로 멤버변수 만들어서 직접접근 불가능!
		p1.name = "홍길동";		// The field People.name is not visible
		p1.gender = '남';
		p1.pNo = "123456-1234567";
		p1.address = "서울시 중구 남대문로 120 그레이츠청계 3층 E강의장";
		p1.phone = "010-1234-1234";
		p1.age = 20;
		
		p1.tax();
		p1.vote();
		
		System.out.println("p1의 name : " + p1.name);
		System.out.println("p1의 gender : " + p1.gender);
		System.out.println("p1의 pNo : " + p1.pNo);
		System.out.println("p1의 address : " + p1.address);
		System.out.println("p1의 phone : " + p1.phone);
		System.out.println("p1의 age : " + p1.age);
		*/
		
		p1.setName("홍길동");
		p1.setGender('남');
		p1.setpNo("123456-1234567");
		p1.setAddress("서울시 중구 어쩌구");
		p1.setPhone("010-1234-1234");
		p1.setAge(20);
		
		System.out.println(p1.getName());
		System.out.println(p1.getGender());
		System.out.println(p1.getpNo());
		System.out.println(p1.getAddress());
		System.out.println(p1.getPhone());
		System.out.println(p1.getAge());
		
		System.out.println("=========================================");
		// 본인 객체
		// People 클래스 이용하여 만들기
		People wookjae = new People();
		
		wookjae.setName("전욱재");
		wookjae.setGender('남');
		wookjae.setpNo("931234-1234567");
		wookjae.setAddress("서울시 관악구 어쩌구");
		wookjae.setPhone("010-1234-1234");
		wookjae.setAge(31);
		
		System.out.println(wookjae.getName());
		System.out.println(wookjae.getGender());
		System.out.println(wookjae.getpNo());
		System.out.println(wookjae.getAddress());
		System.out.println(wookjae.getPhone());
		System.out.println(wookjae.getAge());
	}
}
