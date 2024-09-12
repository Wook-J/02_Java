package com.hw2.model.service;

import com.hw2.model.dto.Person;

public interface ManagementSystem {		// 관리시스템 인터페이스

	void addPerson(Person person);		// 추상 메서드 (관리할 사람을 추가)
	void removePerson(String id);		// 추상 메서드 (관리하던 사람을 삭제)
	void displayAllPersons();			// 추상 메서드 (모든 사람 조회)
}
