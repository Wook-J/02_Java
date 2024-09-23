package edu.kh.collection.pack3.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.collection.pack3.model.dto.Member;

public class MapService {
	
	// Map : (Key - Value) 한 쌍이 데이터가 되어 이를 모아둔 객체
	// - Key 를 모아두면 Set 의 특징 (중복이 불가하므로)
	// - Value 를 모아두면 List 의 특징 (중복이 가능하므로)
	// Key, Value 모두 객체 타입이어야함!
	
	public void method1() {
		// 제네릭이 2개(Key 타입, value 타입) 있음!!
		// HashMap<K, V> : Map 의 자식 클래스 중 가장 대표되는 Map
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		// Map.put(Integer Key, String value) : 데이터 추가(List 와 Set 과의 차이점!)
		map.put(1, "홍길동");
		map.put(2, "고길동");
		map.put(3, "김길동");
		map.put(4, "박길동");
		map.put(5, "이길동");
		map.put(6, "최길동");
				
		// key 중복 테스트 -> 중복허용 X, 대신 Value 덮어쓰기함!
		map.put(1, "홍홍홍");
		
		// value 중복 테스트 -> 중복허용 O
		map.put(7, "최길동");
		
		// 출력 형태 : {K=V, K=V, ...}
		System.out.println(map);		// map.toString() 오버라이딩 되어있음
	}
	
	public void ex2() {		// Map 사용 예제
		
		// VO(값 저장용 객체)는 특정 데이터 묶음의 재사용이 많은 경우 주로 사용
		// -> 재사용이 적은 VO는 오히려 코드 낭비
		// -> Map 을 이용해서 VO와 비슷한 코드를 작성할 수 있음!
		
		// 1) VO 버전
		Member mem = new Member();
		
		// 값 세팅(매개변수 생성자로 해도 무관)
		mem.setId("user01");
		mem.setPw("pass01");
		mem.setAge(30);
		
		// 값 출력
		System.out.println(mem.getId());
		System.out.println(mem.getPw());
		System.out.println(mem.getAge());
		
		// 2) Map 버전
		Map<String, Object> map = new HashMap<String, Object>();
		// value 가 Object 타입 == 어떤 객체든 Value 에 들어올 수 있음
		
		// 값 세팅
		map.put("id", "user02");
		map.put("pw", "pass02");
		map.put("age", 25);			// int 형으로 정수값을 넣었으나 Integer 로 Auto Boxing 됨..!
		
		/* Auto Boxing/ Auto UnBoxing
		 * 1. Auto Boxing : 기본 자료형 데이터를 객체 타입 Wrapper 클래스로 자동 변환
		 *	int -> Integer     -> Interger.valueOf(25)
		 * 	map.put("age", 25) 는 map.put("age", Interger.valueOf(25))로 됨
		 * 2. Auto UnBoxing : Wrapper 클래스인 객체를 기본 자료형 데이터로 자동 변환
		 * 	int num = Integer.valueOf(100);
		 */
		
		// 값 출력
		// Object(Value) Map.get(Object Key) : 매개변수로 전달받은 key 에 대응되는 value 반환
		System.out.println(map.get("id"));
		System.out.println(map.get("pw"));
		System.out.println(map.get("age"));
		
		System.out.println("----------------------------------------");
		
		// ******** Map 에 저장된 데이터에 순차적으로 접근하기
		
		// Map 에서 Key 만 모아두면 Set 의 특징을 가짐!
		// -> 이를 활용해서 Map 에서 keySet() 메서드 제공!
		// -> Key 만 모아서 Set 으로 반환
		Set<String> set = map.keySet();				// id, pw, age 가 저장된 Set 반환
		System.out.println("keySet() : " + set);	// 순서는 뒤죽박죽..! Set 타입이라서..!
		
		// 향상된 for 문
		for(String key : set) {
			System.out.println(map.get(key));
		}
		
		// map 에 저장된 데이터가 많거나 어떤 key 가 있는지 불분명할 때
		// 또는 map 에 저장된 모든 데이터에 접근해야할 때
		// keySet() + 향상된 for 문 코드를 자주 사용!
	}
	
	public void ex3() {		// List 안에 Map 객체 넣기( **** 흔히 쓰임 **** )
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		for(int i=0; i<10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", "user0" + i);		// Map 에 데이터(id) 추가
			map.put("pw", "pass0" + i);		// Map 에 데이터(pw) 추가
			list.add(map);					// Map 을 List 에 추가
		}
		
		// for 문 종료 시 list 에 10개의 Map 객체가 추가되어 있음!
		System.out.println(list);			// list 에 어떻게 들어가있는지 확인용
		
		// 향상된 for 문 이용하여 key 가 "id"에 대응되는 value 값 출력하기
		for( Map<String, Object> temp : list) {
			System.out.println(temp.get("id"));
		}
	}

}