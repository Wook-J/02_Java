package edu.kh.collection.pack1.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
//import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.pack1.model.dto.Student;

public class StudentService {

	// java.util.List 인터페이스 : List 에 반드시 필요한 필수기능을 모아둔 인터페이스
	// * 인터페이스에서 객체 생성 X, 부모 참조변수의 역할 O
	
	// java.util.ArrayList : 배열 형태로 된 List(가장 대표적인 List 자식 클래스)
	
	// new ArrayList() : 기본생성자로 만드는 경우 -> 기본 크기가 10인 List 생성됨
	//   -> 하지만 List 는 크기가 늘었다줄었다 하므로 큰 의미는 없음
	
	// ArrayList(용량) : 용량만큼의 List 생성
	//   -> 너무 큰 값을 작성하면 메모리를 많이 소모하므로 유의할 것!
	
	// 필드, 멤버변수
	private Scanner sc = new Scanner(System.in);
	
/*	private List<Object> testList = new ArrayList<Object>();	// 다형성 중 업캐스팅 적용
	// 부모타입(List) 참조변수(testList)에 자식객체(ArrayList) 주소 대입
	
	// 제네릭(Generics) : 컬렉션에 저장되는 객체 타입을 한가지로 제한할 때 씀, <E> == Element
	// 다양한 타입을 처리할 수 있도록 만들어짐, ctrl space 로 만드는 경우 제네릭 맞춰줌!
	// 제네릭에 Object 대입하면 모든 객체를 받을 수 있음
	// 제네릭에 Object 에서 Student 로 바꾸면 testList.add()에서 에러 뜸!!
	// -> Student Type만 받을 수 있도록 변경!
*/
	
	// 학생 정보를 저장할 List 생성
	private List<Student> studentList = new ArrayList<Student>();	// ArrayList : 검색(조회)에 효율적
//	private List<Student> studentList = new LinkedList<Student>();	// LinkedList : 추가, 수정, 삭제에 효율적
	
	// 생성자
	public StudentService() {
		studentList.add(new Student("홍길동", 25, "서울시 중구", 'M', 90));
		studentList.add(new Student("고영희", 23, "경기도 안산시", 'F', 100));
		studentList.add(new Student("강아지", 30, "서울시 강남구", 'M', 80));
		studentList.add(new Student("오미나", 27, "충북 청주시", 'F', 90));
		studentList.add(new Student("박주희", 24, "서울시 서대문구", 'F', 70));
	}
	
	// 메서드
	/*
	public void ex() {		// List 테스트용 예제
		
		// List.add(Object e) : 리스트에 객체를 추가
		// * 매개변수 타입이 Object : 모든 객체를 매개변수로 전달할 수 있음
		testList.add(new Student("홍길동", 25, "서울시 중구", 'M', 90));
		testList.add("문자열");				// String 객체
		testList.add(sc);					// Scanner 객체
		testList.add(new Object());			// Object 객체
		
		// 컬렉션 특징 : 여러 타입의 데이터를 저장할 수 있음
		
		// Object List.get(index) : List 에서 index 번째 인덱스에 있는 객체를 반환 
//		  (반환형)				    즉, 모든 객체를 반환할 수 있음
		
		System.out.println(testList.get(0));
		System.out.println(testList.get(1));
		System.out.println(testList.get(2));
		System.out.println(testList.get(3));
		
		// testList 에서 꺼내온 인덱스요소가 Student 혹은 상속관계인지 검사
		// 만약 Student 라면 이름을 꺼내오기
		for(Object e : testList) {
			if(e instanceof Student) {
				System.out.println("testList Student 타입 인덱스 요소의 이름 : " + ((Student)e).getName());
			}
		}
	}
	*/
	/**
	 * 메뉴 출력용 메서드
	 * alt + shift + j 메서드 설명용 주석
	 * @author wj@see.or.kr
	 */
	public void displayMenu() {
		
		int menuNum = 0;		// 메뉴 선택용 변수
		do {
			System.out.println("\n===============학생관리 프로그램==============\n");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(포함)");
			System.out.println("7. 나이순으로 정렬");		// Comparable 사용
			System.out.println("8. 이름순으로 정렬");		// Comparator 사용
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 번호 선택 : ");
			
			try {
				menuNum = sc.nextInt(); 
				System.out.println();
				
				switch(menuNum) {
				case 1 : System.out.println( addStudent() ); break;		/*(Create) 학생 정보 추가*/	
				case 2 : selectAll(); break;							/*(Read) 학생 정보 전체 조회*/
				case 3 : System.out.println( updateStudent() ); break;	/*(Update) 학생 정보 수정*/
				case 4 : System.out.println( removeStudent() ); break;	/*(Delete) 학생 정보 삭제*/
				case 5 : searchName1(); break;							/*이름으로 검색(일치)*/
				case 6 : searchName2(); break;							/*이름으로 검색(포함)*/
				case 7 : sortByAge(); break;							/*나이순 정렬*/
				case 8 : sortByName(); break;							/*이름순 정렬*/
				case 0 : System.out.println("프로그램 종료.."); break;
				default : System.out.println("메뉴에 작성된 번호만 입력하세요!");
				}				
			}catch(InputMismatchException e) {
				System.out.println("\nerror : 입력형식이 유효하지 않습니다. 다시 시도해 주세요!");
				sc.nextLine();		// 입력 버퍼에 남아있는 잘못된 코드 제거
				menuNum = -1;		// 첫 반복 시 잘못입력하는 경우 menuNum 이 0을 가지고 있어 종료조건에 걸리므로, 이를 방지하기 위함
			}
		}while(menuNum != 0);
	}
	
	/**
	 * 1. 학생 정보 추가 메서드
	 * @return 추가 성공 시 "성공", 실패 시 "실패" 문자열 반환
	 */
	public String addStudent() throws InputMismatchException {
		System.out.println("========== 학생 정보 추가 ==========");
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();						// 입력버퍼에 남은 개행문자 제거용
		
		System.out.print("사는 곳 : ");
		String region =sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		if( studentList.add(new Student(name, age, region, gender, score)) ) {
			// boolean java.util.List.add(Student e)
			// (반환형)
			// -> List<Student> 이므로 추가할 수 있는 객체타입이 Student 로 제한됨
			return "성공";
		}else return "실패";
	}
	
	/**
	 * 2. 학생 정보 전체 조회 메서드
	 * - List 가 비어있는 경우 "학생정보가 없습니다" 출력
	 * - 있는 경우 전체 학생 정보 출력
	 */
	public void selectAll() {
		System.out.println("========== 학생 전체 조회 ==========");
		
		// List 에 저장된 데이터의 개수를 얻어오는 방법 : int List.size();
//		if(studentList.size() ==0)
		
		// List 에 요소가 없는 지 여부 확인 : boolean isEmpty() : 컬렉션이 비어있다면 true 반환
		if(studentList.isEmpty()) {
			System.out.println("학생 정보가 없습니다");
			return;		// 현재 메서드를 종료하고 호출한 곳으로 돌아감(단 반환값 없음!)
		}
		
		/* 일반 for 문
		for(int i=0; i<studentList.size(); i++) {		// 배열명.length 대신 리스트명.size() 이용!
			System.out.println(studentList.get(i));
		}
		*/
		
		// 향상된 for 문 (for each 문) : 컬렉션, 배열의 모든 요소를 순차적으로 반복접근 할 수 있는 for 문
		// (순차적 : 0번 인덱스부터 마지막 요소의 인덱스까지 1씩 증가하며 각 요소에 접근)
		// 작성법
		// for(컬렉션 또는 배열에서 꺼낸 한개의 요소를 저장할 변수 : 컬렉션명 또는 배열명)
		int index =0;		// 향상된 for 문에서 idx 번호를 출력하려는 경우
		for(Student std : studentList) {
			System.out.print((index++) + "번 : ");
			System.out.println(std);
		}
	}
	
	/**
	 * 3. 학생 정보 수정 메서드
	 * - 학생 정보가 studentList에 있는지(인덱스 번호로) 검사
	 *   -> 없다면 "입력된 학생 정보가 없습니다" 문자열 반환
	 *   -> 입력된 숫자가 0보다 작은지 검사, 작다면 "음수는 입력할 수 없습니다" 문자열 반환
	 * - stidentList 범위 내 인덱스 번호인지 검사
	 *   -> 초과했다면 "범위를 넘어선 값을 입력할 수 없습니다" 문자열 반환
	 * - 수정이 완료되었다면 "OOO의 정보가 변경되었습니다" 문자열 반환
	 * @return
	 */
	public String updateStudent() throws InputMismatchException {
		System.out.println("========== 학생 정보 수정 ==========");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(studentList.isEmpty()) return "입력된 학생 정보가 없습니다.";
		else if(index < 0) return "음수는 입력할 수 없습니다.";
		else if(index >= studentList.size()) return "범위를 넘어선 값을 입력할 수 없습니다.";
		// 문자열을 입력하는 경우 -> throws 예외처리를 했으므로 별도로 할 필요없음!
		else {		// 수정코드 작성
			System.out.println(index + "번째 저장된 학생 정보");
			System.out.println(studentList.get(index));
			
			System.out.print("이름 : ");
			String name = sc.next();
			
			System.out.print("나이 : ");
			int age = sc.nextInt();
			sc.nextLine();						// 입력버퍼에 남은 개행문자 제거용
			
			System.out.print("사는 곳 : ");
			String region =sc.nextLine();
			
			System.out.print("성별(M/F) : ");
			char gender = sc.next().charAt(0);
			
			System.out.print("점수 : ");
			int score = sc.nextInt();
			
			// 입력받은 index 번째에 새로운 학생 정보를 세팅
			// index 번째에 있던 기존 객체(학생) 정보가 반환되고, 그 객체를 temp 에 저장
			Student temp = studentList.set(index, new Student(name, age, region, gender, score));
			return temp.getName() + "의 정보가 " + name +"(으)로 변경되었습니다.";
		}
	}
	
	/**
	 * 4. 학생 정보 제거 메서드
	 * @return if - else if - else 문 참조
	 * @throws InputMismatchException
	 */
	public String removeStudent() throws InputMismatchException {
		System.out.println("========== 학생 정보 제거 ==========");
		
		// Student List.remove(int index);
		// 리스트에서 index 번째 요소를 제거하면서, "제거된 요소"가 Student 타입으로 반환됨
		
		// * List 중간에 비어있는 인덱스가 없게하기 위해 remove()동작 시 뒤쪽 요소를 한칸씩 알아서 당겨옴
		// 배열처럼 직접 덮어쓰기 할 필요가 없으므로 편리함!!
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(studentList.isEmpty()) return "입력된 학생 정보가 없습니다.";
		else if(index < 0) return "음수는 입력할 수 없습니다.";
		else if(index >= studentList.size()) return "범위를 넘어선 값을 입력할 수 없습니다.";
		// 문자열을 입력하는 경우 -> throws 예외처리를 했으므로 별도로 할 필요없음!
		else {
			System.out.print("정말 삭제 하시겠습니까? (Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);	// "n" 입력 -> "N" -> 'N'
			// String.toUpperCase() : 문자열을 대문자로 변경 (char 형은 불가능!)
			// String.toLowerCase() : 문자열을 소문자로 변경 (char 형은 불가능!)
			if(ch == 'Y') {
				Student temp = studentList.remove(index);
				return temp.getName() +"의 정보가 제거되었습니다";
			} else if(ch=='N') return "취소";
			else return "올바른 문자를 입력하세요";
		}
	}
	
	/**
	 * 5. 이름이 완전 일치하는 학생 찾아서 조회하는 메서드
	 * 검색할 이름을 입력받아 studentList에서 꺼내온 Student 객체의 name 값이 같은지 비교
	 * - 일치하는 경우 : Student 객체 출력
	 * - 일치하는 결과 없는 경우 : "검색결과가 없습니다" 출력
	 */
	public void searchName1() {
		System.out.println("========== 학생 검색(이름 완전 일치) ==========");
		
		System.out.print("검색할 이름 입력 : ");
		String input = sc.next();
		
		boolean flag = true;			// 검색 결과 있는지 확인하는 플래그
		
		for(Student std : studentList) {
			if(input.equals(std.getName()) ) {
				System.out.println(std);
				flag = false;
			}
		}
		
		if(flag) System.out.println("검색 결과가 없습니다");
	}
	
	/**
	 * 6. 이름에 특정 문자열이 포함되는 학생을 찾아서 조회하는 메서드
	 * 문자열 입력받아 studentList에서 꺼내온 Student 객체의 name 값에 포함되는 문자열인지 검사
	 * - 포함되는 경우 : Student 객체 출력
	 * - 포함되는 Student가 없는 경우 : "검색결과가 없습니다" 출력
	 */
	public void searchName2() {
		System.out.println("========== 학생 검색(이름 부분 포함) ==========");
		
		System.out.print("이름에 포함되는 문자열 입력 : ");
		String input = sc.next();
		
		boolean flag = true;						// 검색 결과 있는지 확인하는 플래그
		
		for(Student std : studentList) {
			if(std.getName().contains(input) ) {		
				// boolean String.contains(문자열) String 에 문자열 포함되어 있으면 true 반환
				// 순서 중요!! String 내에 문자열을 찾으므로 앞부분이 더 긴 문자여야함!
				System.out.println(std);			// std.toString();
				flag = false;
			}
		}
		
		if(flag) System.out.println("검색 결과가 없습니다");
	}
	
	/**
	 * 7. 나이에 따라 오름차순 정렬하는 메서드
	 * - compareTo() 메서드를 재정의해서 사용
	 */
	public void sortByAge() {
		
		// 기존의 studentList를 유지하고 정렬하려는 경우!
		List<Student> studentListCopied = new ArrayList<Student>();	// 정렬할 때 쓰는 studentList
		for(Student std : studentList) {
			studentListCopied.add(std);
		}
		
		// Student 에 Comparable 인터페이스를 상속받아 오버라이딩한 
		// compareTo()에 정의한 대로 정렬됨 (오름차순, 내림차순)
		Collections.sort(studentListCopied);
		// Student 클래스 에서 sort()에 대한 override 해야 사용할 수 있음!
		
		// 정렬된 결과 출력
		for( Student std: studentListCopied) {
			System.out.println(std);
		}
	}
	
	/**
	 * 8. 이름에 따라 정렬하는 Comparator 객체 생성
	 */
	public void sortByName() {
		
		// 클래스명.변수, 클래스명.메시드명 : public static 일때 클래스명으로 호출 가능!! 
		Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
		// Comparator 인터페이스의 static 메서드인 comparing()을 사용하여 Comparator 객체를 생성
		// -> comparing() : 주어진 키를 기반으로 객체를 비교함
		
		// comparing()은 기본적으로 오름차순 -> 내림차순 원할시 ~~.reversed(); 사용
//		Comparator<Student> nameComparator = Comparator.comparing(Student::getName).reversed();		// 거꾸로 정렬시
		
		// Student::getName -> 메서드 레퍼런스(Method Reference)
		// Student 클래스의 getName() 메서드를 가리키는 것
		// -> 이 메서드를 비교의 키로 사용하여 각 Student 객체를 비교하고 정렬함
		
		// Comparator.comparing(Student::getName) 은 Student 객체의 이름(name)을 기준으로 
		// 학생 객체를 비교하는 Comparator 객체를 생성
		
		// 이름에 따라 정렬
		Collections.sort(studentList, nameComparator);
		// 이대로 하면 기존 studentList가 변경되어 원본을 그대로 불러올 수 없음
		// 7. 방법 이용하여 원본 배열 훼손하지 않고 이용 가능!
		
		for( Student std: studentList) {
			System.out.println(std);
		}
		
	}
	
	// getter, setter
}
