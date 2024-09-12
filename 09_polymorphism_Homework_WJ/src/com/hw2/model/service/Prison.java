package com.hw2.model.service;

import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem {

	// 필드, 멤버변수
	private Prisoner[] prisoners;							// Prisoner 객체배열의 이름을 prisoners(참조변수)로 선언
	private int prisonerCount;								// 수감자수(배열 인덱스용)
	
	// 생성자
	public Prison(int size) {
		
		prisoners = new Prisoner[size];						// Prisoner 객체 배열을 size 크기로 생성 및 주소를 prisoners 에 할당
		prisonerCount = 0;									// 0으로 초기화
	}
	
	// 메서드
	@Override
	public void addPerson(Person person) {		// ManagementSystem(interface)의 추상메서드 상속
		
		if( prisoners.length > prisonerCount ) {			// prisoners(배열)에 공간이 있는 경우
			
			prisoners[prisonerCount] = (Prisoner) person;	// Person 객체가 Prisoner 클래스의 인스턴스이고, 그 객체를 prisoners(배열)에 추가
			System.out.println("수감자가 추가되었습니다 - " + prisoners[prisonerCount].getInfo());	// 추가된 객체의 정보를 출력
			prisonerCount++;								// prisoners(배열)의 다음 인덱스에 추가하기 위한 prisonerCount 증가
			
		} else System.out.println("인원이 모두 충원되었습니다.");	// prisoners(배열)에 공간이 없는 경우
	}
	
	// 선생님 풀이
//	@Override
//	public void addPerson(Person person) {		// Prisoner 객체를 Person 객체로 업캐스팅
//		
//		// Person 객체가 Prisoner 클래스의 인스턴스인지 및 배열의 공간이 있는지 여부
//		if(person instanceof Prisoner &&  prisonerCount < prisoners.length)	{
//			
//			prisoners[prisonerCount++] = (Prisoner) person;	// 다운캐스팅 및 인원추가 후 prisonerCount 증가
//			System.out.println("직원이 추가되었습니다 - " + person.getInfo());	// 동적바인딩(Prisoner.getInfo()로 바뀜)
//			
//		} else System.out.println("인원이 모두 충원되었습니다.");
//	}
	
	@Override
	public void removePerson(String id) {		// ManagementSystem(interface)의 추상메서드 상속
		
		boolean flag = false;					// 동일 Id 가 있는지 판단하는 변수

		for(int i=0; i<prisonerCount; i++) {				// i = 0 ~ (prisonerCount-1) ... 총 prisonerCount개
			if( id.equals(prisoners[i].getId()) ) {			// 매개변수로 전달된 Id 와 일치하는 prisoners[i]의 Id 가 있는 경우
				System.out.println("직원이 삭제되었습니다 - " + prisoners[i].getInfo());		// 삭제될 객체의 정보를 출력
				for(int j=i+1; j<prisonerCount; j++) prisoners[j-1] = prisoners[j];				// 1칸씩 당기면서 employees[i] 정보 덮어쓰기
				flag = true;								// 1개 삭제한 경우 prisonerCount 변화시키기 위한 변수값 변화
				break;										// 바깥의 for 문 탈출 (1개 찾으면 이후 for 문 돌릴 필요 없음)
			} 
		}
		
		if(flag) {
			prisonerCount--;								// index 와 prisonerCount 는 1 차이(index 가 작음)므로 주의!!
			prisoners[prisonerCount] = null;				// 하나 감소된 prisonerCount 이므로 배열 인덱스가 존재
		} else System.out.printf("해당 ID(%s)를 가진 수감자를 찾을 수 없습니다\n", id);		// 일치하는 Id 없는 경우
	}
	
	// 선생님 풀이
//	@Override
//	public void removePerson(String id) {
//		
//		for(int i=0; i<prisonerCount; i++) {				// 현재 등록된 직원 수 만큼만 반복
//			if(prisoners[i].getId().equals(id)) {			// 매개변수로 전달된 Id 와 일치하는 prisoners[i]의 Id 가 있는 경우
//				System.out.println("수감자가 삭제되었습니다 - " + prisoners[i].getInfo());		// 삭제될 객체의 정보를 출력
//				prisoners[i] = null;						// i 번째 수감자 삭제
//				for(int j= i; j<prisonerCount-1; j++) prisoners[j] = prisoners[j+1];			// 1칸씩 당기면서 prisoners[i] 정보 덮어쓰기
//				prisoners[--prisonerCount] = null;			// prisonerCount 먼저 1 감소시키고 배열 마지막 요소를 null 대입
//				return;										// 호출한 곳으로 바로 돌아가면서 메서드 종료
//			}
//		}
//		
//		System.out.println("ID : " + id + "인 직원을 찾을 수 없습니다.");
//	}
	
	@Override
	public void displayAllPersons() {			// ManagementSystem(interface)의 추상메서드 상속
		
		System.out.printf("전체 수감자 명단 : 총 %d명\n", prisonerCount);
		for(Prisoner pri : prisoners) {
			if( pri == null) break;							// nullPointerException 방지
			System.out.println(pri.getInfo());
		}
	}

	// getter, setter
	public Prisoner[] getPrisoners() {
		return prisoners;
	}
	public void setPrisoners(Prisoner[] prisoners) {
		this.prisoners = prisoners;
	}

	public int getPrisonerCount() {
		return prisonerCount;
	}
	public void setPrisonerCount(int prisonerCount) {
		this.prisonerCount = prisonerCount;
	}
}
