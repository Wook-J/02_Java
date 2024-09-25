package com.hw2.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.hw2.model.dto.Animal;

public class Zoo {

	// 필드
	private List<Animal> animals = new ArrayList<Animal>();
	private Scanner sc = new Scanner(System.in);
	
	// 생성자
	public Zoo() {}
	
	// 메서드
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}
	
	public void showAnimals() {
		System.out.println("동물들의 울음소리를 들어보세요:");
		for(Animal animal : animals) {
			animal.sound();
		}
		System.out.println();
	}
	
	public void displayMenu() {
		
		int menuNum = 0;
		do {
			System.out.println("****** KH 동물원 ******");
			System.out.println("원하는 작업을 선택하세요 : ");
			System.out.println("1. 동물들의 울음소리 듣기");
			System.out.println("2. 종료");
			System.out.print("선택 : ");
			
			try {
				menuNum = sc.nextInt();
				
				switch(menuNum) {
				case 1: showAnimals(); break;
				case 2: System.out.println("프로그램을 종료합니다."); break;
				default : System.out.println("올바른 번호를 입력하세요\n"); break;
				}	
			}catch(InputMismatchException e ){
				System.out.println("error : 입력형식이 유효하지 않습니다. 다시 시도해 주세요!\n");
				sc.nextLine();		// 입력 버퍼에 남아있는 잘못된 코드 제거
				menuNum = 0;
			}
		}while(menuNum != 2);

	}
	
	// getter, setter
}
