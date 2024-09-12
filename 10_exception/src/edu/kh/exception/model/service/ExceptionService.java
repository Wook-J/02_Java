package edu.kh.exception.model.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionService {

	// 예외(Exception) : 소스코드의 수정으로 해결이 가능한 오류
	
	// 두 종류로 구분됨
	// 1) Unchecked Exception : 선택적으로 예외 처리(ex. Runtime Exception...)
	// 2) Checked Exception : 필수적으로 예외 처리(ex. IOException...)
	
	private Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		
		System.out.println("두 정수를 입력받아 나누기한 몫을 출력");
		
		System.out.print("정수 1 입력 : ");
		int input1 = sc.nextInt();
		
		System.out.print("정수 2 입력 : ");
		int input2 = sc.nextInt();
		
		try {									// 예외가 발생할 것 같은 코드
			System.out.println("결과 : " + input1/input2);
			// 0으로 나누려는 경우 : java.lang.ArithmeticException(산술적 예외) 발생
		} catch(ArithmeticException e) {		// try 에서 던져진 예외를 catch 문의 매개변수 e 로 잡음!
			System.out.println("infinity");
		}
		
		if(input2 !=0) System.out.println("결과 : " + input1/input2);
		else System.out.println("infinity");
		
		// 발생하는 예외 중 일부(대부분 Unchecked Exception)는 try - catch 문을 사용하지 않더라도
		// if - else 문을 통해 예외 상황 방지가능
	}
	
	public void ex2() {		// 여러가지 예외에 대한 처리방법
		
		try {
			System.out.print("정수 1 입력 : ");		// InputMismatchException : 다른 타입 넣었을 때
			int input1 = sc.nextInt();
			
			System.out.print("정수 2 입력 : ");		// InputMismatchException : 다른 타입 넣었을 때
			int input2 = sc.nextInt();
			
			System.out.println("결과 : " + input1/input2);	// ArithmeticException : input2에 0 대입했을 때
			
			String str = null;
			
			System.out.println(str.charAt(0));		// NullPointerException
			
		// Exception
		// 		ㄴ RuntimeException
		//				ㄴ InputMismatchException, ArithmeticException
		// 예외 찾을 때 후손Exception을 먼저 작성해야함! 그렇지 않으면 도달할 수 없음
		
		} catch(InputMismatchException e) {
			System.out.println("타입에 맞는 값만 입력하세요.");
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch(Exception e) {
			// Exception 클래스 : 모든 예외의 최상위 부모
			// 다형성 중 업캐스팅 : 부모타입 참조변수로 자식객체 참조
			
			// ** 상위 타입의 예외 클래스를 catch 문에 작성하면
			//	  다형성 업캐스팅에 의해 모두 잡아서 처리 가능!! **
			
			System.out.println("뭔지 모르겠으나 예외가 발생해서 처리함..");
			e.printStackTrace();
			// 발생할 예외에 대한 메서드와 위치에 대한 모든 내용을 출력
			// 예외 발생 지점 추적 메서드
		}
	}
	
	public void ex3() {
		
		// try - catch - finally
		// finally : try 구문에서 예외가 발생 하든 말든 무조건 마지막에 수행
		try {
			System.out.print("정수 1 입력 : ");		// InputMismatchException : 다른 타입 넣었을 때
			int input1 = sc.nextInt();
			
			System.out.print("정수 2 입력 : ");		// InputMismatchException : 다른 타입 넣었을 때
			int input2 = sc.nextInt();
			
			System.out.println("결과 : " + input1/input2);	// ArithmeticException : input2에 0 대입했을 때
			
		} catch(ArithmeticException e) {
			System.out.println("예외 처리 됨");
			
			// catch 문에 들어온 매개변수 활용
			// 매개변수 e : 예외 관련된 정보 + 예외 관련 기능
			
			System.out.println( e.getClass() );		// 어떤 예외 클래스인지 알려줌!
			// class java.lang.ArithmeticException
			
			System.out.println( e.getMessage());	// 예외 발생 시 출력된 내용
			// / by zero
			
			System.out.println( e );				// e.toString()
			// java.lang.ArithmeticException: / by zero
			
			e.printStackTrace();
			
		} catch(InputMismatchException e){
			System.out.println("숫자만 넣어라..");
		} finally {
			System.out.println("무조건 수행됨");
			sc.close();								// 스캐너 통로 닫기 : 메모리누수 방지
		}
	}
	
	public void ex4() {		// throw / throws 예제
		
		try {
			methodA();
		} catch (Exception e) {	// 업캐스팅
			// Exception : 모든 예외의 최상위 부모 => 예외 종류 상관없이 모두 처리
			System.out.println("methodC에서부터 발생한 예외를 ex4에서 잡아 처리함");
		}
	}
	
	public void methodA() throws IOException {	// ex4() 관련
		methodB();
	}
	
	public void methodB() throws IOException {	// ex4() 관련
		methodC();
	}
	
	public void methodC() throws IOException {	// ex4() 관련
		// throws : 호출한 메서드에게 예외를 던짐
		// -> 호출한 메서드에게 예외를 처리하라고 위임하는 행위
		
		System.out.println("methodC에서 IOException 발생!! methodB에게 던진다!");
		
		// throw : 예외 강제 발생 구문
		throw new IOException();
		// IOException은 checked Exception 이어서 해결해야 함! 메서드 선언부에 throws IOException 붙음
	}
	
	public void ex5() throws UserException {		// 사용자 정의 예외

		throw new UserException("사용자정의 예외 발생");
	}
}
