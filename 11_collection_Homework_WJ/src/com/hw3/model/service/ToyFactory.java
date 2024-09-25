package com.hw3.model.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;					// 필드
import java.util.HashSet;					// 필드
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;						// 필드
import java.util.Map.Entry;
import java.util.Scanner;					// 필드
import java.util.Set;						// 필드

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
		
//		1. 일반 배열 사용
//		toys.add(new Toy("마미롱레그", 8, 36000, "분홍색", "19950805", addMaterials(new int[] {1, 4}) ));
//		public Set<String> addMaterials (int [] materials) {}
		
//		2. List.of() 사용
//		toys.add(new Toy("마미롱레그", 8, 36000, "분홍색", "19950805", addMaterials(List.of(1, 4)) ));
//		public Set<String> addMaterials (List<Integer> materials) {}
		
//		3. Arrays.asList() 사용
//		toys.add(new Toy("마미롱레그", 8, 36000, "분홍색", "19950805", addMaterials(Arrays.asList(1, 4)) ));
//		public Set<String> addMaterials (List<Integer> materials) {}
		
//		4. 가변인자 사용
		toys.add(new Toy("마미롱레그", 8, 36000, "분홍색", "19950805", addMaterials(1, 4) ));
		toys.add(new Toy("허기워기", 5, 12000, "파란색", "19940312", addMaterials(1, 2) ));
		toys.add(new Toy("키시미시", 5, 15000, "분홍색", "19940505", addMaterials(1, 2) ));
		toys.add(new Toy("캣냅", 8, 27000, "보라색", "19960128", addMaterialsTeacher(1, 2) ));
		toys.add(new Toy("파피", 12, 57000, "빨간색", "19931225", addMaterialsTeacher(1, 2, 4) ));
	}
	
	/** 생성자 만들때 필요한 메서드
	 * 가변인자를 사용한 객체 만들기..? 콤마(,) 로 구분함(배열 형태로 들어옴)
	 * (매개변수 개수가 특정되어 있지 않을 때)
	 * @param materials
	 * @return Set<String>
	 */
	public Set<String> addMaterials(Integer...materials) {
		
		Set<String> mats = new HashSet<String>();		// Toy 매개변수 생성자를 위한 HashSet<String>타입 객체 생성
		
		for(Integer materialNum : materials) {			// 저장된 모든 재료에 대해 mats 에 추가
			mats.add(materialMap.get(materialNum));
		}
		
		return mats;									// mats 를 반환
	}
	
	/** 생성자 만들때 필요한 메서드(강사님 풀이)
	 * 매개변수로 전달받은 값들을 
	 * 재료저장 Map 에 있는지 확인하고 
	 * Set 형태로 반환하는 메서드
	 * 
	 * 가변인자 작성법 : 자료형...변수명
	 * -> 매개변수의 수가 정확히 몇개인지 특정할 수 없을 때 사용
	 * @return
	 */
	public Set<String> addMaterialsTeacher(Integer...materials){
		
		// 매개변수로 전달받은 재료를 저장하여 반환할 Set 객체 생성
		Set<String> addedMaterials = new HashSet<String>();
		
		for(Integer meterialKey : materials) {
			
			// Map 에서 재료 고유 번호(key)에 대응하는 재료명(value)을 addedMaterials에 추가
			// 만약 Map 에 없는 key 를 입력하여 value 를 얻어오면 null 을 반환!!
			String materialValue = materialMap.get(meterialKey);
			
			if(materialValue != null) {		// 재료 목록에 있을 때
				addedMaterials.add(materialValue);				
			}
			
		}
			
		return addedMaterials;
	}

	// 일반 메서드	
	/** 
	 * 0. 화면표시 메서드
	 * - 여기서 전부 예외처리
	 */
	public void displayInfo() {
		
		int menuNum = 0;								// 메뉴선택용 정수
		
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
			
			try {										// InputMismatch 에러 잡는 용도
				menuNum = sc.nextInt();
				switch(menuNum) {
				case 1: toyRead(); break;
				case 2: createToy(); break;
				case 3: deleteToy(); break;
				case 4: sortByDay(); break;
//				case 5: sortByAge(); break;				// 내 버전
				case 5: displayToysByAge(); break;		// 강사님 버전
				case 6: addMaterial(); break;
				case 7: removeMaterial(); break;
				case 0: System.out.println("공장 관리를 종료합니다");break;
				default: System.out.println("메뉴에 있는 숫자만 입력하세요!"); break;
				}
				
			}catch(InputMismatchException e){			// 에러 발생시 할 처리
				sc.nextLine();
				System.out.println("올바른 타입을 입력하세요!");
				menuNum = -1;
			}
			
			System.out.println();						// 줄 구분 용
			
		}while(menuNum != 0);
		
	}
	
	/**
	 * 1. 전체 장난감 조회하기
	 * - 입력없으므로 예외처리 필요 없음
	 */
	public void toyRead() {
		System.out.println("< 전체 장난감 목록 >");
		
		int idx = 1;
		for(Toy toy : toys) {
			System.out.println(idx + ". " + toy);
			idx++;
		}
	}
	
	/**
	 * 2. 새로운 장난감 만들기 (강사님 깃허브 참고)
	 * - 예외처리 필요(0.에 던지는거로)
	 */
	public void createToy() throws InputMismatchException {
		sc.nextLine();									// 입럭버퍼에 혹시 모를 \n 제거
		System.out.println("< 새로운 장난감 추가 >");
		System.out.print("장난감 이름 : ");
		String toyName = sc.nextLine();
		
		for(Toy toy : toys) {
			if(toy.getName().equals(toyName)) {			// 같은 이름 있는 경우 장난감 생성불가 처리
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
		
		String day = "";								// 날짜형식 제대로 입력하기 위한 조치
		do {
			System.out.print("제조일(YYYYMMDD 형식으로 입력) : ");
			day = sc.next();
			if(day.length() != 8) System.out.println("제조연월일을 정확히 입력해주세요!");
		}while(day.length() != 8);
		
		Set<String> addToyMaterial = new HashSet<String>();		// Toy 매개변수 생성자 만들기 위해 필요한 재료 Set 생성

		System.out.println("--- 사용 가능한 재료 목록 ---");
		for(Entry<Integer, String> entry : materialMap.entrySet()) {		// Map 에서 모든 K-V 나타날 때 사용하는 클래스
			System.out.println(entry.getKey() + " : " + entry.getValue());	// materialMap의 모든 K-V 출력
		}
		/*
		 * [1=면직물, 2=플라스틱, 3=유리, 4=고무]
		 * Set <Entry<K, V>> Map.entrySet() : key=value 한 쌍으로 Entry 객체를 Set 객체로 반환
		 * */
		
		// Integer.parseInt(String) : String 타입의 숫자를 int 형으로 변환할때 사용
		
		while(true) {									// q 가 입력될 때 까지 무한 반복
			System.out.print("추가할 재료의 번호를 입력하세요 (종료하려면 'q'를 입력) : ");
			
			try {
				
				String addNum = sc.next();					// 숫자, 문자 다 있으므로 String 타입으로 받고 parseInt 사용
				if(addNum.equals("q")) break;				// 탈출조건
				
				if(!materialMap.containsKey(Integer.parseInt(addNum))) {
					System.out.println("잘못된 번호입니다. 다시 입력해 주세요");
					continue;								// 재료 Set 에 포함되어 있지 않은 번호 입력 시 while 문 처음으로
				}
				
				if(addToyMaterial.contains(materialMap.get(Integer.parseInt(addNum)))) {	
					System.out.println("이미 추가된 재료입니다. 다른 재료를 선택하세요.");
					continue;								// 이미 재료 포함되어 있는 경우(Set 특징 활용) while 문 처음으로
				}
				
				for(Entry<Integer, String> entry : materialMap.entrySet()) {		// 제대로 재료 번호 입력한 경우
					if(entry.getKey() == Integer.parseInt(addNum)) {
						addToyMaterial.add(materialMap.get(entry.getKey()));
						System.out.println("재료가 추가되었습니다 : " + entry.getValue());
						break;								// 찾아서 추가했으니 이후 반복 안하고 for 문 탈출
					}
				}											// for 문 마지막
				
			}catch(NumberFormatException e){
				System.out.println("숫자를 입력하거나 q를 입력하세요!");
			}
			
		}												// while 문 마지막
		
		toys.add(new Toy(toyName, age, price, color, day, addToyMaterial));		// 위에 생성된 거 전부 참조하여 새 장난감 생성
		System.out.println("새로운 장난감이 추가되었습니다!");
	}
	
	/**
	 * 3. 장난감 삭제하기 (강사님 깃허브 참고)
	 * - 예외처리필요(0.에 던지는거로)
	 */
	public void deleteToy() throws InputMismatchException {
		sc.nextLine();									// 입력버퍼에 혹시 모를 \n 제거용
		System.out.print("삭제할 장난감의 이름을 입력하세요 : ");
		String delName = sc.nextLine();
		
		for(Toy toy : toys) {
			if(toy.getName().equals(delName)) {			// toys 안에 동일한 이름 장난감 있는 경우
				toys.remove(toy);
				System.out.println("장난감이 삭제되었습니다.");
				return;									// 이미 삭제했으므로 메서드 종료
			}
		}
														// for 문 내 if 문 만족 못할 경우(일치하는 장난감 X)
		System.out.println("이름이 동일한 장난감이 없습니다.");
	}
	
	/**
	 * 4. 장난감 제조일 순으로 조회하기 (강사님 깃허브 참고)
	 * - 입력없으므로 예외처리 필요 없음
	 */
	public void sortByDay() {
		System.out.println("< 제조일 순으로 장난감을 정렬 >");
		List<Toy> toysCopied = new ArrayList<Toy>(toys);	// Sort 를 위한 toys(Set 타입)을 List 타입으로 생성
		
														// comparing 사용하여 문자열 비교(제조연월일)
//		Comparator<Toy> dayComparator = Comparator.comparing(Toy::getDay);
//		Collections.sort(toysCopied, dayComparator);
		
		toysCopied.sort(Comparator.comparing(Toy::getDay));		// 이렇게 한줄로 처리할 수도 있음!
		
		int idx = 1;										// 번호 출력용 idx
		for(Toy toy : toysCopied) {						// 정렬된 toysCopied 전부 출력
			System.out.println(idx + ". " + toy);
			idx++;
		}
	}
	
	/**
	 * 5. 연령별 사용 가능한 장난감 리스트 조회하기
	 * - 입력없으므로 예외처리 필요 없음
	 */
	public void sortByAge() {
		System.out.println("< 연령별로 사용가능한 장난감 >");
		Set<Integer> toyAge = new HashSet<Integer>();	// 사용가능연령만 모아놓을 Set 생성
		
		for(Toy toy : toys) {							// 사용가능연령 중복되지 않게 Set 에 대입
			toyAge.add(toy.getAge());
		}
		
		for(Integer age : toyAge) {
			System.out.printf("[연령 : %d세]\n", age);	// 연령을 띄우는 용도
			int i=1;									// 연령별 인덱스 정하기 위한 변수
			for(Toy toy: toys) {
				if(toy.getAge()== age) {				// toyAge에 있는 age 와 같은 경우만 출력 
					System.out.println(i +". " +toy);
					i++;								// 인덱스 증가용
				}
			}
		}
	}
	
	/** 5. 풀이(강사님 버전)
	 * 
	 */
	public void displayToysByAge() {
		System.out.println("< 연령별로 사용가능한 장난감 >");
		
		Map<Integer, List<Toy>> toysByAge = new HashMap<Integer, List<Toy>>();
		// toysByAge 라는 이름의 새로운 Map 생성
		// -> 연령을 key 로 지정하고, 해당 연령을 가진 장난감 List 를 value 로 가짐

		for(Toy toy : toys) {
			int age = toy.getAge();
			
			toysByAge.putIfAbsent(age, new ArrayList<Toy>());
			// putIfAbsent(Key, Value) : Map 에서 제공하는 메서드로,
			// 해당 키가 존재하지 않는 경우에만 전달받은 값을 추가함!
			// -> Map 에 해당 연령의 리스트가 없는 경우에만 새로운 리스트를 생성하여 추가
			// .put()만 쓰는 경우 매번 K : V 가 생성되므로 중첩이 불가능!
			
			toysByAge.get(age).add(toy);
			// toysByAge.get(age) -> Key(age)에 맞는 List(Value) 반환
			// .add(toy) -> 전달된 toy 객체를 List 에 추가
			// 즉, key==age 인 List<Toy> 에 현재 toy 객체를 추가함
		}
		
		for(Entry<Integer, List<Toy>> entry : toysByAge.entrySet()) {
			int age = entry.getKey();
			List<Toy> toyList = entry.getValue();
			
			System.out.println("[연령 : " + age + "세]");
			
			int idx = 1;
			for(Toy toy : toyList) {
				System.out.println(idx + ". " + toy);
				idx++;
			}
		}
	}
	
	/**
	 * 6. 재료 추가 (강사님 깃허브 참고)
	 * - 예외처리필요(0.에 던지는거로)
	 */
	public void addMaterial() throws InputMismatchException {
		System.out.println("< 재료 추가 >");
		System.out.println("--- 현재 등록된 재료 ---");
		
		for(Entry<Integer, String> entry : materialMap.entrySet()) {		// Map 에서 모든 K-V 나타날 때 사용하는 클래스
			System.out.println(entry.getKey() + " : " + entry.getValue());	// materialMap의 모든 K-V 출력
		}
		System.out.println("------------------------------");
		
		System.out.print("재료 고유번호(key) 입력 : ");
		int keyNum = sc.nextInt();
		sc.nextLine();
		
		System.out.print("재료명 입력 : ");
		String materialName = sc.nextLine();
		
		if(materialMap.containsKey(keyNum)) {								// 동일한 Key(Integer 타입) 있는 경우
			System.out.println("이미 해당키에 재료가 등록되어 있습니다.");
						
			while(true) {													// 올바른 문자입력할 때까지 반복
				System.out.print("덮어쓰시겠습니까? (Y/N) : ");
				String response = sc.next().toLowerCase();					// 전부 소문자 처리(String 타입만 가능)
				
				// String.equalsIgnoreCase() : 대소문자 구분않고 문자열 값 자체만 비교(강사님 코드)
				if(response.equals("y")) {									// String 타입끼리 동일한지 비교 시 .equals()
					materialMap.put(keyNum, materialName);
					System.out.println("재료가 성공적으로 덮어쓰기 되었습니다.");
					break;													// 덮어쓰기 성공하면 while 문 탈출
				}else if(response.equals("n")) {
					System.out.println("취소하였습니다. 원상태로 돌아갑니다.");
					break;													// 덮어쓰기 취소하면 while 문 탈출
				}else System.out.println("올바른 문자를 입력해주세요.");	// 올바른 문자입력할 때까지 반복
			}
			
		}else {																// 동일한 Key(Integer 타입) 없는 경우
			materialMap.put(keyNum, materialName);
			System.out.println("새로운 재료가 성공적으로 등록되었습니다.");
		}
	}
	
	/**
	 * 7. 재료 제거 (강사님 깃허브 참고)
	 * - 예외처리필요(0.에 던지는거로)
	 */
	public void removeMaterial() throws InputMismatchException{
		System.out.println("< 재료 삭제 >");
		System.out.println("--- 현재 등록된 재료 ---");
		
		for(Entry<Integer, String> entry : materialMap.entrySet()) {		// Map 에서 모든 K-V 나타날 때 사용하는 클래스
			System.out.println(entry.getKey() + " : " + entry.getValue());	// materialMap의 모든 K-V 출력
		}
		System.out.println("------------------------------");
		
		sc.nextLine();
		System.out.print("삭제할 재료명 입력 : ");
		String delMaterial = sc.nextLine();
		
		for(Entry<Integer, String> entry : materialMap.entrySet()) {
			if(delMaterial.equals(entry.getValue())) {
				System.out.println("재료 '" + materialMap.remove(entry.getKey()) + "'가 성공적으로 제거되었습니다.");
				return;														// 재료 삭제했으니 메서드 종료
			}
		}
		
		System.out.println("해당 이름의 재료가 존재하지 않습니다.");		// 재료 삭제 못한 경우

	}
	
	// getter, setter
	
}
