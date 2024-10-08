package edu.kh.exception.test;

public class ExceptionTest {

	public static void main(String[] args) {

		// 컴파일 에러 : 개발자가 코드를 잘못 쓴 경우
//		int a = 99.9;	// Type mismatch: cannot convert from double to int
		// -> 자료형이 맞지 않아 연산이 불가하여 "컴파일 에러" 발생
		// int a = 99; 등 통해 코드수정 가능!
		
		// 런타임 에러 : 프로그램 수행 중 발생하는 에러 => 주로 if 문으로 처리가능!
		int[] arr= new int[3];	// 길이가 3이고, 인덱스번호는 0 ,1, 2가 있음
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
//		arr[3] = 40;			// 컴파일 에러는 없음!
		// java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		// 배열 범위 초과 예외
		
		if(3>= arr.length) {	// 배열 인덱스 범위 초과시
			System.out.println("배열 범위를 초과했습니다.");
		}else System.out.println("아무거나~");
	}

}
