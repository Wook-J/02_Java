package com.hw2.model.service;

import com.hw2.model.dto.Person;

public interface ManagementSystem {

	void addPerson(Person person);		// 추상 메서드
	void removePerson(String id);		// 추상 메서드
	void displayAllPersons();			// 추상 메서드
}
