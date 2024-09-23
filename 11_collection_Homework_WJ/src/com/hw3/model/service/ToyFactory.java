package com.hw3.model.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.hw3.model.dto.Toy;

public class ToyFactory {

	// 필드
	private Scanner sc = new Scanner(System.in);
	private Set<Toy> toys = new HashSet<Toy>();
	private Map<Integer, String> materialMap = new HashMap<Integer, String>();
	
	// 생성자
	public ToyFactory() {
		materialMap.put(1, "면직물");
		materialMap.put(2, "플라스틱");
		materialMap.put(3, "유리");
		materialMap.put(4, "고무");
		
		// 가변인자...?? 매개변수 개수가 특정되어있지 않을 때......??
		toys.add(new Toy("마미롱레그", 8, 36000, "분홍색", "19950805", materials.get(1) + ", " + materials.get(4)) );
		toys.add(new Toy("허기워기", 5, 12000, "파란색", "19940312",  materials.get(1) + ", " + materials.get(2)) );
		toys.add(new Toy("키시미시", 5, 15000, "분홍색", "19940505", materials.get(1) + ", " + materials.get(2)) );
		toys.add(new Toy("캣냅", 8, 27000, "보라색", "19960128", materials.get(1) + ", " + materials.get(2)) );
		toys.add(new Toy("파피", 12, 57000, "빨간색", "19931225", materials.get(1) + ", " + materials.get(2)+materials.get(4)) );
	}
	
	public Set<String> addMaterials(Integer...materials) {
		
	}
	
	
	// 메서드	
	public void displayInfo() {
		
		int menuNum = 0;
		
		do {
			System.out.println("<< 플레이타임 공장 >>");
			System.out.println("1. 전체 장난감 조회하기");
			System.out.println("2. 새로운 장난감 만들기");
			System.out.println("3. 장난감 삭제하기");
			System.out.println("4. 장난감 제조일 순으로 조회하기");
			System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
			System.out.println("6. 재료 추가");
			System.out.println("7. 재료 제거");
			System.out.println("0. 종료");
			
			System.out.print("선택 : ");
			menuNum = sc.nextInt();
			switch(menuNum) {
			case 1: toyRead(); break;
			case 2: createToy(); break;
			case 3: deleteToy(); break;
			case 4: sortByDay(); break;
			case 5: break;
			case 6: break;
			case 7: break;
			case 0: 
				System.out.println("관리를 종료합니다");
				menuNum = 0;
				break;
			}
			System.out.println();
			
		}while(menuNum != 0);
	}
	
	/**
	 * 1. 전체 장난감 조회하기
	 */
	public void toyRead() {
		for(Toy toy : toys) {
			System.out.println(toy);
		}
	}
	
	/**
	 * 2. 새로운 장난감 만들기
	 */
	public void createToy() {
		sc.nextLine();
		System.out.println("< 새로운 장난감 추가 >");
		System.out.print("장난감 이름 : ");
		String toyName = sc.nextLine();
		
		for(Toy toy : toys) {
			if(toy.getName().equals(toyName)) {
				System.out.println("똑같은 이름의 장난감을 만들 수 없습니다!!");
				return;
			}
		}
		
		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("색상 : ");
		String color = sc.nextLine();
		
		System.out.print("제조일(YYYYMMDD 형식으로 입력) : ");
		String day = sc.next();
		
		boolean flag = true;
		// toyMaterial에 대해서 추가작성해야함
		
//		if(flag) {			
//			toys.add(new Toy(toyName, age, price, color, day, toyMaterial));
//			System.out.println("새로운 장난감이 추가되었습니다!");
//		}
	}
	
	/**
	 * 3. 장난감 삭제하기
	 */
	public void deleteToy() {
		sc.nextLine();
		System.out.print("삭제할 장난감의 이름을 입력하세요 : ");
		String delName = sc.nextLine();
		
		for(Toy toy : toys) {
			if(toy.getName().equals(delName)) {
				toys.remove(toy);
				System.out.println("장난감이 삭제되었습니다.");
				return;
			}
		}
		
		System.out.println("이름이 동일한 장난감이 없습니다.");
	}
	
	/**
	 * 4. 장난감 제조일 순으로 조회하기
	 */
	public void sortByDay() {
		
	}
	
	// getter, setter
	
}
