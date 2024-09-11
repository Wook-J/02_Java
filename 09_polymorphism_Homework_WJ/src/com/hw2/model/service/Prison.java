package com.hw2.model.service;

import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem {

	// 필드, 멤버변수
	private Prisoner[] prisoners;							// Prisoner 객체배열을 prisoners(참조형 변수)로 선언
	private int prisonerCount;								// 수감자수(배열 인덱스용)
	
	// 생성자
	public Prison(int size) {
		// TODO Auto-generated constructor stub
		
		prisoners = new Prisoner[size];						// Prisoner 객체 배열을 size 크기로 생성 및 주소를 prisoners 에 할당
		prisonerCount = 0;									// 0으로 초기화
	}
	
	// 메서드
	@Override
	public void addPerson(Person person) {		// ManagementSystem(interface)의 추상메서드 상속
		// TODO Auto-generated method stub
		
		if( prisoners.length >= prisonerCount ) {			// prisoners(배열)에 공간이 있는 경우
			
			prisoners[prisonerCount] = (Prisoner) person;	// Person 객체가 Prisoner 클래스의 인스턴스이고, 그 객체를 prisoners(배열)에 추가
			System.out.printf("수감자가 추가되었습니다 - ID : %s , 이름 : %s , 죄목 : %s\n",	// 추가된 객체의 정보를 출력
					prisoners[prisonerCount].getId(), prisoners[prisonerCount].getName(), prisoners[prisonerCount].getCrime());
			prisonerCount++;								// prisoners(배열)의 다음 인덱스에 추가하기 위한 prisonerCount 증가
			
		} else System.out.println("인원이 모두 충원되었습니다.");	// prisoners(배열)에 공간이 없는 경우
	}
	
	@Override
	public void removePerson(String id) {		// ManagementSystem(interface)의 추상메서드 상속
		// TODO Auto-generated method stub
		
		boolean flag = false;					// 동일 Id 가 있는지 판단하는 변수

		for(int i=0; i<prisonerCount; i++) {				// i = 0 ~ (prisonerCount-1) ... 총 prisonerCount개
			if( id.equals(prisoners[i].getId()) ) {			// 매개변수로 전달된 Id 와 일치하는 prisoners[i]의 Id 가 있는 경우
				
				System.out.printf("수감자가 삭제되었습니다 - ID : %s , 이름 : %s , 죄목 : %s\n",// 삭제될 객체의 정보를 출력
						prisoners[i].getId(), prisoners[i].getName(), prisoners[i].getCrime());
				
				for(int j=i+1; j<prisonerCount; j++) prisoners[j-1] = prisoners[j];				// 1칸씩 당기면서 employees[i] 정보 덮어쓰기
				
				flag = true;								// 1개 삭제한 경우 prisonerCount 변화시키기 위한 변수값 변화
				break;										// 바깥의 for 문 탈출 (1개 찾으면 이후 for 문 돌릴 필요 없음)
			} 
		}
		
		if(flag) {
			prisonerCount--;							// index 와 prisonerCount 는 1 차이(index 가 작음)므로 주의!!
			prisoners[prisonerCount] = null;			// 하나 감소된 prisonerCount 이므로 배열 인덱스가 존재
		} else System.out.printf("해당 ID(%s)를 가진 수감자를 찾을 수 없습니다\n", id);		// 일치하는 Id 없는 경우
	}
	
	@Override
	public void displayAllPersons() {			// ManagementSystem(interface)의 추상메서드 상속
		// TODO Auto-generated method stub
		
		System.out.println("전체 수감자 명단 : ");
		for(Prisoner pri : prisoners) {
			if( pri == null) break;							// nullPonterException 방지
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
