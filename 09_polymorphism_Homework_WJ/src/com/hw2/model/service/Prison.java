package com.hw2.model.service;

import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem {

	// 필드, 멤버변수
	private Prisoner[] prisoners;
	private int prisonerCount;
	
	// 생성자
	public Prison(int size) {
		// TODO Auto-generated constructor stub
		prisoners = new Prisoner[size];
		prisonerCount = 0;
	}
	
	// 메서드
	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		if( prisoners.length >= prisonerCount ) {
			
			prisoners[prisonerCount] = (Prisoner) person;
			System.out.printf("수감자가 추가되었습니다 - ID : %s , 이름 : %s , 죄목 : %s\n", 
					prisoners[prisonerCount].getId(), prisoners[prisonerCount].getName(), prisoners[prisonerCount].getCrime());
			prisonerCount++;
			
		} else System.out.println("인원이 모두 충원되었습니다.");
	}
	
	@Override
	public void removePerson(String id) {
		// TODO Auto-generated method stub
		for(int i=0; i<prisonerCount; i++) {
			if( id.equals(prisoners[i].getId()) ) {
				System.out.printf("수감자가 삭제되었습니다 - ID : %s , 이름 : %s , 죄목 : %s\n",
						prisoners[i].getId(), prisoners[i].getName(), prisoners[i].getCrime());
				
				for(int j=i+1; j<prisonerCount; j++) {
					prisoners[j-1] = prisoners[j];
				}
				
				prisonerCount--;
				prisoners[prisonerCount] = null;
			} else System.out.printf("해당 %s를 가진 수감자를 찾을 수 없습니다\n", id);
		}
	}
	
	@Override
	public void displayAllPersons() {
		// TODO Auto-generated method stub
		System.out.println("전체 직원 명단 : ");
		for(Prisoner pri : prisoners) {
			if( pri == null) break;
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
