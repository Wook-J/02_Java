package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample1 {	// 예제 작성용 클래스
	
	Scanner sc = new Scanner(System.in);
	
	/* 배열(Array)
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것.
	 * - 묶여진 변수들은 하나의 배열명으로 불려지고 구분은 index 를 이용함
	 *   (index 는 0부터 시작하는 정수)
	 * */

	// 기본 자료형(primitive type) : int, double, boolean 등 일반 자료형(8개)은 stack 영역에 있음
	// 참조 자료형(reference type) : 배열(array), 객체(Object), String은 heap 영역에 할당되어 있음
	
	/* heap 영역에 할당된 공간은 !절대! 비어있을 수 없다.
	 * -> 최초 할당 시 JVM 기본값이 자동 저장된다
	 * (boolean 은 false, 나머지 0, 참조형 null)
	 * */
	
	public void ex1() {
		
		// 변수 vs 배열
		
		// 변수의 선언 : 자료형 변수명;
		int num;
		// stack 영역에 int 자료형을 저장할 수 있는 공간 4byte를 할당하고
		// 그 공간에 num 이라는 이름을 부여
		
		// 변수의 대입
		num = 10;
		// 생성된 num 이라는 변수 공간에 10이라는 값을 대입
		
		// 변수의 사용
		System.out.println("num에 저장된 값 : " + num);
		// num 이 작성된 자리에 num 에 저장된 값을 읽어와서 출력
		
		//-------------------------------------------------------------
		
		// 배열의 선언
		int[] arr;		// int arr[]; 도 가능!!!
		// stack 영역에 int[] 자료형 공간을 4byte 할당하고
		// 그 공간에 arr 이라는 이름을 부여
		// * 해당 변수는 참조형으로 주소값만을 저장할 수 있음!! *
		
		// 배열의 할당
		arr = new int[3];			// JAVA에서 배열의 리터럴 표기법 : 중괄호!!!!!
		// new : "new 연산자", 'Heap' 메모리 영역에 새로운 공간(배열, 객체)을 할당!!
		// new연산자를 이용하면 고유의 주소도 생기고 이것을 선언한 배열에 대입!
		
		// int[3] : int 자료형 변수 3개를 하나의 묶음으로 나타내는 배열
		// -> heap 메모리 영역에 int 3칸짜리 int[]을 생성(할당)
		// arr = new int[3] -> 같은 자료형 == 연산(ex 대입연산 =) 가능!!
		
		System.out.println("arr : " + arr);		// [I@68fb2c38  -> 배열([)+정수형(I)+16진수 해시코드
		System.out.println(arr[0]);				// 0
		System.out.println(arr[1]);				// 0
		System.out.println(arr[2]);				// 0
		
		arr[0] = 10;
		arr[1] = 50;
		arr[2] = 1000;
		System.out.println(arr[0]);				// 10
		System.out.println(arr[1]);				// 50
		System.out.println(arr[2]);				// 1000
		
		// [10, 50, 1000] 실제 arr 배열이 가진 모도 요소의 값을 한번에 출력할 경우
		System.out.println(Arrays.toString(arr));
	}
	
	public void ex2() {
		
		// 배열 선언 및 할당
		int[] arr = new int[4];
		// arr[0] ~ arr[3]의 값은 JVM에 의해 0으로 초기화 되어있는 상태
		// heap 영역에 생성되어 할당된 공간을 비어있을 수 없음!!
		
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 500;
		arr[3] = 1000;
//		arr[4] = 5000;		
		// java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
		// 배열의 인덱스 범위 벗어남 : 길이가 4칸짜리 배열인데, 없는 인덱스인 4에 접근하려 함
		
		// 배열의 길이 ( 몇 칸 인가) : 배열명.length
		System.out.println("배열의 길이 : " + arr.length);
		
		// 배열과 for 문
		for(int i=0; i<arr.length; i++) {
			System.out.printf("arr[%d]에 저장된 값 : %d\n", i, arr[i]);
		}
	}
	
	public void ex3() {			// 5명의 키(cm)를 입력받고 평균 구하기

		double[] height = new double[5];
		// double[] 자료형 참조변수 height 를 stack 영역에 생성하고,
		// height 에 heap 영역에 새로 생성된 double5칸짜리 배열의 주소를 대입
		
		for(int i=0; i<height.length; i++) {
			System.out.print((i+1) + "번 키 입력 : ");
			height[i] = sc.nextDouble();
		}
		System.out.println();		// 줄바꿈
		
		double sum = 0;				// 합계 저장용 변수
		for(int i=0; i<height.length; i++) sum += height[i];
		
		System.out.printf("평균 : %.2fcm", sum/height.length);
	}
	
	public void ex4() {			// 인원수 입력받아 합계, 평균, 최고점, 최저점 출력
		
		// 입력받은 인원수 만큼 점수를 입력받아 배열에 저장
		// 입력이 완료되면 점수 합계, 평균, 최고점, 최저점 출력
		
		System.out.print("입력 받을 인원 수 : ");
		int input = sc.nextInt();
		int[] score = new int[input];	// 배열 선언 및 할당, 배열의 크기는 입력받은 인원수(input)임!!
		int sum =0;
		
		for(int i=0; i<score.length; i++) {
			System.out.print((i+1) + "번 점수 입력 : ");
			score[i] = sc.nextInt();
			sum += score[i];
		}
		
		int max = score[0];
		int min = score[0];
		
		for(int i=0; i<score.length; i++) {
			if(score[i] > max) max = score[i];
			if(score[i] < min) min = score[i];
		}
		System.out.println("합계 : "+ sum);
		System.out.printf("평균 : %.2f\n", (double)sum / score.length);
		System.out.println("최고점 : " + max);
		System.out.println("최저점 : " + min);
	}
	
	public void ex5() {
		
		char[] arr = new char[5];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (char) ('A' +i);
			// 'A' + i 하면 int 형으로 자동 형변환되므로 다시 강제 형변환 해야 함!
		}
		
		// ** Arrays 클래스 **
		// -> JAVA에서 제공하는 배열과 관련된 기능을 모아둔 클래스
		
		// Array.toString(배열명) : 모든 요소값을 출력
		System.out.println(Arrays.toString(arr));	// [A, B, C, D, E]
		
		int[] arr2 = new int[4];
		System.out.println(Arrays.toString(arr2));	// [0, 0, 0, 0]
		// int 형 배열 4칸짜리 생성 후 각 인덱스에 값을 대입하지 않았으므로
		// JVM 에 의해 int 형 기본값인 0으로 초기화 되어 있음.
		
		boolean[] arr3 = new boolean[2];
		System.out.println(Arrays.toString(arr3));	// [false, false]
		
		String[] arr4 = new String[3];
		System.out.println(Arrays.toString(arr4));	// [null, null, null]
		
		// 배열 선언과 동시에 초기화
		char[] arr5 = {'A', 'B', 'C', 'D', 'E'};
		System.out.println(Arrays.toString(arr5));	// [A, B, C, D, E]
		// { } (중괄호)는 JAVA에서 배열의 리터럴 표기법!!!
	}
	
	public void ex6() {			// 점심 메뉴 뽑기 프로그램
		
		String[] arr = {"김밥", "서브웨이", "햄버거", "백반", "국밥", "짜장면"};
		System.out.println("오늘 점심 메뉴 : "+arr[(int) (Math.random()*6)]);
	}
	
	public void ex7() {			// 배열을 이용한 검색
		
		// 입력받은 정수가 배열에 있는지 없는지 확인
		// 만약 있다면 몇 번 인덱스에 존재하는지 출력
		
		int[] arr = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		boolean flag = false;	// 신호를 나타내기 위한 변수
								// flag == false : 일치하는 값이 존재하지 않음
								// flag == true  : 일치하는 값이 존재
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == input) {
				System.out.println(i + "번째 인덱스에 존재");
				flag = true;	// 일치하는 값이 있으므로 true로 변경
			}
		}
		
		// flag 상태를 검사
		// flag 가 false 라면 if 조건식이 false 이므로 수행되지 않음
		// -> !(Not 연산자)를 붙여줌으로써 true 로 변경하여 코드수행하게 함
		if(!flag) System.out.println("존재하지 않음");
	}
	
	public void ex8() {			// 입력받은 값과 일치하는 값이 있으면 인덱스 번호 출력
		String[] arr = {"사과", "딸기", "바나나", "키위", "멜론", "아보카도"};
		
		/* 과일 입력 : 아보카도
		 * 5번째 인덱스에 존재
		 * 
		 * 과일 입력 : 수박
		 * 존재하지 않음
		 * */
		
		System.out.print("과일 입력 : ");
		String input = sc.next();
		boolean flag = false;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals(input)) {				// String 비교시 equals() 사용
				System.out.println(i + "번째 인덱스에 존재");
				flag = true;
			}
		}
		
		if(!flag) System.out.println("존재하지 않음");
	}
	
	public void ex9() {
		// 1. 문자열을 입력받아 한 글자씩 잘라내어 char 배열에 순서대로 저장
		// 2. 문자 하나를 입력받아 일치하는 문자가 char 배열에 몇개 존재하지는 확인
		// 3. 단, 일치하는 문자 없을경우 "존재하지 않습니다" 출력
		/*
		 * ex)
		* 문자열 입력 : hello
		[h, e, l, l, o]
		검색할 문자 입력 : l
		2개 있음
		*
		 *
		 * */
				
		// [사용해야하는 기술, 기능]
		// 1) 배열 검색
		// 2) String.length()  : 문자열의 길이
		//   ex) "Hello".length() -> 5
				
		// 3) String.charAt(index) : 문자열에서 특정 index에 위치한 문자 하나를 얻어옴.
		//   ex) "Hello".charAt(1)  ->  'e'
		//	      01234	
				
		// 4 ) count (숫자세기)
		
		System.out.print("문자열 입력 : ");
		String input = sc.nextLine();			// hello world -> [h, e, l, l, o, , w, o, r, l, d]
		
		char[] arr = new char[input.length()];	// 문자열의 길이만큼의 char 배열 생성
		
		for(int i=0; i<arr.length; i++) {		// 문자열을 한글자씩 잘라내여 char 배열에 순서대로 저장
			arr[i] = input.charAt(i);
		}
		
//		System.out.println(Arrays.toString(arr));	// 제대로 들어갔는지 확인
		
		System.out.print("검색할 문자 입력 : ");
		char ch = sc.next().charAt(0);			
		// sc.next()는 String 형이어서 charAt(index) 접근하여 char 형으로 변환
		// ex) "h".charAt(0) -> 'h'  : String 형을 char 형으로 변환
		
		int count = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == ch) count++;			
		}
		
		if(count > 0) System.out.println(count + "개 있음");
		else System.out.println("존재하지 않습니다.");
	}
}
