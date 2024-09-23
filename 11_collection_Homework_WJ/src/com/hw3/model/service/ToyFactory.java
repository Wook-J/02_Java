package com.hw3.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
		toys.add(new Toy("마미롱레그", 8, 36000, "분홍색", "19950805", addMaterials(1, 4)) );
		toys.add(new Toy("허기워기", 5, 12000, "파란색", "19940312", addMaterials(1, 2)) );
		toys.add(new Toy("키시미시", 5, 15000, "분홍색", "19940505", addMaterials(1, 2)) );
		toys.add(new Toy("캣냅", 8, 27000, "보라색", "19960128", addMaterials(1, 2)) );
		toys.add(new Toy("파피", 12, 57000, "빨간색", "19931225", addMaterials(1, 2, 4)) );
	}
	
	public Set<String> addMaterials(Integer...materials) {
		Set<String> mats = new HashSet<String>();
		
		for(Integer materialNum : materials) {
			mats.add(materialMap.get(materialNum));
		}
		
		return mats;
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
			case 2: /*createToy()*/ break;
			case 3: deleteToy(); break;
			case 4: sortByDay(); break;
			case 5: sortByAge(); break;
			case 6: addMaterial(); break;
			case 7: removeMaterial(); break;
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
		
		System.out.println("사용 가능한 재료 목록 :");
		for(Entry<Integer, String> entry : materialMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// 이부분 고민해보기!!
		int addNum = 'q';
		Set<String> addToyMaterial = new HashSet<String>();
		do {
			System.out.print("추가할 재료의 번호를 입력하세요 (종료하려면 'q'를 입력) : ");
			addNum = sc.nextInt();
			
			for(Entry<Integer, String> entry : materialMap.entrySet()) {
				if(entry.getKey()==addNum) {
					System.out.println("재료가 추가되었습니다 : " + entry.getValue());
				}
			}
			
		}while(addNum != 'q');
		// 여기까지
		
		toys.add(new Toy(toyName, age, price, color, day, addToyMaterial));
		System.out.println("새로운 장난감이 추가되었습니다!");
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
		List<Toy> toysCopied = new ArrayList<Toy>();
		for(Toy toy : toys) {
			toysCopied.add(toy);
		}
		
		Comparator<Toy> dayComparator = Comparator.comparing(Toy::getDay);
		Collections.sort(toysCopied, dayComparator);
		
		for(Toy toy : toysCopied) {
			System.out.println(toy);
		}
	}
	
	/**
	 * 5. 연령별 사용 가능한 장난감 리스트 조회하기
	 */
	public void sortByAge() {
		System.out.println("< 연령별로 사용가능한 장난감 >");
		Set<Integer> toyAge = new HashSet<Integer>();
		for(Toy toy : toys) {
			toyAge.add(toy.getAge());
		}
		
		for(Integer age : toyAge) {
			System.out.printf("[연령 : %d세]\n", age);
			int i=1;
			for(Toy toy: toys) {
				if(toy.getAge()== age) {
					System.out.println(i +". " +toy);
					i++;
				}
			}
		}
	}
	
	/**
	 * 6. 재료 추가
	 */
	public void addMaterial() {
		System.out.println("< 재료 추가 >");
		System.out.println("--- 현재 등록된 재료 ---");
		
		for(Entry<Integer, String> entry : materialMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("------------------------------");
		
		System.out.print("재료 고유번호(key) 입력 : ");
		int keyNum = sc.nextInt();
		sc.nextLine();
		
		System.out.print("재료명 입력 : ");
		String materialName = sc.nextLine();
		
		if(materialMap.containsKey(keyNum)) {
			System.out.println("이미 해당키에 재료가 등록되어 있습니다.");
			System.out.print("덮어쓰시겠습니까? (Y/N) : ");
			String response = sc.next().toLowerCase();
			
			if(response.equals("y")) {
				materialMap.put(keyNum, materialName);
				System.out.println("재료가 성공적으로 덮어쓰기 되었습니다.");
			}else if(response.equals("n")) {
				System.out.println("원상태로 돌아갑니다.");
			}else System.out.println("잘못된 문자입력, 원상태로 돌아갑니다.");
		}else {
			materialMap.put(keyNum, materialName);
			System.out.println("새로운 재료가 성공적으로 등록되었습니다.");
		}
	}
	
	/**
	 * 7. 재료 제거
	 */
	public void removeMaterial() {
		System.out.println("< 재료 삭제 >");
		System.out.println("--- 현재 등록된 재료 ---");
		
		for(Entry<Integer, String> entry : materialMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("------------------------------");
		System.out.print("삭제할 재료명 입력 : ");
		String delMaterial = sc.next();
		
		for(Entry<Integer, String> entry : materialMap.entrySet()) {
			if(delMaterial.equals(entry.getValue())) {
				System.out.println("재료 '"+materialMap.remove(entry.getKey()) + "'가 성공적으로 제거되었습니다.");
				return;
			}
		}
		System.out.println("해당 이름의 재료가 존재하지 않습니다.");

	}
	
	// getter, setter
	
}
