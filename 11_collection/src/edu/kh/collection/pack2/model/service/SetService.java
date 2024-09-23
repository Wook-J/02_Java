package edu.kh.collection.pack2.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
//import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.pack2.model.dto.Person;
//import java.util.TreeSet;

public class SetService {
	
	/* Set(집합, 주머니) 
	 * - 기본적으로 순서를 유지하지 않음
	 *  (index 없음!!! -> get() 메서드가 없음)
	 * - 중복데이터 저장 X (같은 객체가 들어오면 덮어쓰기됨)
	 * 
	 * Set 인터페이스의 자식클래스
	 * 1. HashSet(대표) : 처리속도가 빠른 Set
	 * 2. LinkedHashSet : 순서를 유지하는 Set
	 * 3. TreeSet : 자동 정렬되는 Set
	 * 
	 * */

	public void method1() {
		
		// HashSet 객체 생성
		Set<String> set = new HashSet<String>();	// 다형성 중 업캐스팅 적용
//		Set<String> set = new LinkedHashSet<String>();	// 추가 순서가 유지되는 Set 종류
//		Set<String> set = new TreeSet<String>();	// 지동정렬되는 Set 종류
		
		
		//    반환형 메서드명(전달인자)
		// 1. boolean add(E e) : 추가
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의민족");
		set.add("당근마켓");
		set.add("토스");
		set.add("직방");
		set.add("야놀자");
		
		System.out.println(set);
		// HashSet은 순서 유지 안됨!!
		// LinkedHashSet은 순서 유지 됨!!
		// TreeSet 자동 정렬 됨!!
		
		// 중복 저장 되는지?? -> 중복 저장 안됨!!
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		System.out.println(set);	// 배달의민족 1회만 출력됨
		
		// null 도 중복안됨!
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		System.out.println(set);	// null 1회만 출력됨
		
		// 2. int size() : Set 에 저장된 객체의 수 반환
		System.out.println("set.size() : " + set.size());
		
		// 3. boolean remove(E e) : 전달받은 매개변수 e 를 Set 에서 제거
		// 제거 성공 시 true, 요소 없어서 제거 실패 시 false
		System.out.println(set.remove("배달의민족"));	// true 반환
		System.out.println(set.remove("유플러스"));		// false 반환
		System.out.println(set);						// "배달의민족"이 사라진 상태로 출력

		// 4. boolean contains(E e): 전달받은 e 가 Set 에 있으면 true, 없으면 false 반환
		System.out.println("쿠팡 있는지 검사 : " + set.contains("쿠팡"));
		System.out.println("삼성 있는지 검사 : " + set.contains("삼성"));
		
		// 5. void clear() : Set 에 저장된 내용을 모두 삭제
		set.clear();
		
		// 6. boolean isEmpty() : 비어있으면 true, 아니면 false 반환
		System.out.println(set.isEmpty());
		System.out.println(set);
	}
	
	/** alt + shift + j : 메서드용 주석
	 * Set 에 저장된 요소(객체)를 꺼내는 방법
	 * 1. Iterator(반복자) 이용
	 * 2. List 로 변환
	 * 3. 향상된 for 문 이용
	 */
	public void method2() {
		
		Set<String> set = new HashSet<String>();
		
		set.add("몽쉘");
		set.add("꼬북칩");
		set.add("쿠크다스");
		set.add("빈츠");
		set.add("포카칩");
		
		// 1. Iterator (반복자) : 컬렉션 객체에 저장된 요소를 하나씩 순차 접근하는 객체
		// Iterator(반환형) Set.iterator() : 현재 Set 을 순차접근할 수 있는 Iterator 객체 반환
		Iterator<String> it = set.iterator();
		System.out.println("[Iterator]");
		
		// boolean Iterator.hasNext() : 다음 순차접근할 요소가 있으면 true, 없으면 false 반환
		while(it.hasNext()) {			// 다음 요소가 있으면 반복, 없으면 멈춤
			// E(반환형) Iterator.next() : 다음 요소를 꺼내와서 반환
			String temp = it.next();
			System.out.println(temp);
		}
		
		System.out.println("---------------------------------------");
		// 2. Set 에 저장된 객체를 이용해서 List 를 생성
		System.out.println("[List로 변환]");
		List<String> list = new ArrayList<String>(set);
		
		// 일반 for 문
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("---------------------------------------");
		// 3. 향상된 for 문을 이용
		System.out.println("[향상된 for문]");
		for(String snack : set) {
			System.out.println(snack);
		}
	}
	
	/**
	 * 직접 만든 클래스(Person)를 이용해 만든 객체를 
	 * Set 에 저장 (중복 제거 확인용)
	 */
	public void method3() {
		
		Person p1 = new Person("홍길동", 25, '남');
		Person p2 = new Person("홍길동", 25, '남');
		Person p3 = new Person("홍길동", 30, '남');
		Person p4 = new Person("김길순", 20, '여');
		
		// Set 객체 생성 후 p1 ~ p4 추가
		Set<Person> personSet = new HashSet<Person>();
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		personSet.add(p4);
		
		System.out.println("------------------------------------------");
		// Person 클래스에서 hashCode() equals() override 하면 p1, p2 중복 안됩
		for(Person p : personSet) {
			System.out.println(p);
		}
		
		System.out.println("------------------------------------------");
		// hashCode() : 객체 식별 번호를 반환
		// 같은 필드값을 가진 객체는 번호가 같음!
		System.out.println("p1 : " + p1.hashCode());	// 55605822
		System.out.println("p2 : " + p2.hashCode());	// 55605822
		System.out.println("p3 : " + p3.hashCode());	// 55610627
		System.out.println("p4 : " + p4.hashCode());	// 45920299
		
		// A.equals(B) : A와 B가 가지고 있는 필드값이 같다면 true, 아니면 false 반환
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		
		// ****************************************************************
		// Hash 라는 단어가 포함된 컬렉션 이용 시
		// hashCode(), equals() 오버라이딩이 필수적으로 진행되어야 함!!
		// ****************************************************************
	}
	
	/**
	 * TreeSet 이용한 로또번호 생성기
	 * -> 기본적으로 오름차순 정렬임
	 * * 전제조건 : 저장되는 객체는 Comparable 인터페이스 상속 필수!
	 * -> Integer 는 Comparable 이 이미 상속되어 있음
	 */
	public void method4() {
		
		// 난수생성 방법 : 1) Math.random() , 2) Random.nextInt()
		
		// Random 객체 생성
		Random random = new Random();
		
		// Integer 를 저장할 TreeSet 객체 생성
		// Integer (객체, Wrapper class) <==> int (기본자료형)
		Set<Integer> lotto = new TreeSet<Integer>();
		
		// lotto 에 저징된 값이 6개 미만이면 반복 (== 6개면 멈춤)
		while(lotto.size() < 6) {		// ( ) 안에 true 조건식
			
			// random.nextInt(45) : 0 <= x < 45 의 난수(정수만)
			lotto.add(random.nextInt(45) + 1);		// 1 ~ 45 중 정수 1개 추가
		}
		
		System.out.println(lotto);
	}
	
	/** 로또 번호 생성기
	 * 금액을 입력받아 (1000원 단위)
	 * 1000원 당 1회씩 번호를 생성해서 List 에 저장한 후
	 * 생성 종료시 한 번에 출력
	 * 
	 * <pre>
	 * 금액 입력 : 3000
	 * 
	 * 1회 : [11, 20, 34, 35, 42, 43]
	 * 2회 : [2, 5, 13, 20, 30, 34]
	 * 3회 : [7, 17, 28, 35, 41, 44]
	 * </pre>
	 */
	public void lottoNumberGenerator() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("금액 입력 : ");
		int money = sc.nextInt();
		
		Random random = new Random();
		
		// 생성된 로또번호 묶음 (TreeSet)을 저장할 List
		List<Set<Integer>> lottoList = new ArrayList<Set<Integer>>();	// 다형성 고려해서 TreeSet 아닌 Set
		// Set 객체를 만들어 lottoList의 각 인덱스에 저장
		// List 라는 컬렉션 안에 Set 이라는 컬렉션 넣을 수 있음!!
		
		// for 문 반복될 때마다 새로운 TreeSet 객체 생성
		for(int i=0; i<money; i+=1000) {
			Set<Integer> lotto = new TreeSet<Integer>();				// 업캐스팅
			
			while(lotto.size() < 6) {
				lotto.add(random.nextInt(45) + 1);
			}
			
			lottoList.add(lotto);					// List 에 생성된 Set 을 추가
		}
		
		// 향상된 for 문 사용 시
		int idx=1;
		for(Set<Integer> s : lottoList) {
			System.out.println(idx + "회 : " + s);
			idx++;
		}
		
		/* 일반 for 문 사용 시
		for(int i=0; i<lottoList.size(); i++) {
			System.out.println((i+1) + "회 : " + lottoList.get(i));
		}
		*/
	}
}
