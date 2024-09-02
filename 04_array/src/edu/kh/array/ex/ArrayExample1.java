package edu.kh.array.ex;

import java.util.Arrays;

public class ArrayExample1 {	// 예제 작성용 클래스
	
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
		arr = new int[3];
		// new : "new 연산자", 'Heap' 메모리 영역에 새로운 공간(배열, 객체)을 할당!!
		// int[3] : int 자료형 변수 3개를 하나의 묶음으로 나타내는 배열
		// -> heap 메모리 영역에 int 3칸짜리 int[]을 생성(할당)
		// arr = new int[3] -> 같은 자료형 == 연산(ex 대입연산 =) 가능!!
		
		System.out.println("arr : " + arr);		// [I@68fb2c38  -> 배열([)+정수형(I)+16진수 해시코드
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		arr[0] = 10;
		arr[1] = 50;
		arr[2] = 1000;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		// [10, 50, 1000] 실제 arr 배열이 가진 모도 요소의 값을 한번에 출력할 경우
		System.out.println(Arrays.toString(arr));
	}
}
