package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.dto.Car;
import edu.kh.poly.ex1.model.dto.Spark;
import edu.kh.poly.ex1.model.dto.Tesla;

public class PolyService {
	
	// 속성(필드, 멤버변수)
	
	// 생성자
	
	// 메서드
	public void ex1() {		// 다형성 확인 예제
		
	// 부모타입 참조변수 = 부모객체
		Car car = new Car();
		
	// 자식타입 참조변수 = 자식객체
		Tesla tesla = new Tesla();
		
	// 부모타입 참조변수 = 자식객체
		Car car2 = new Tesla();		// 오류발생 안함
		// Tesla 객체를 참조하는 변수(car2)의 타입(자료형)이 Car(부모)타입이기 때문에
		// Tesla 객체가 Car(부모) 객체로 변화함
		// -> 이를 업캐스팅(Up Casting)이라고 함
		
	// 부모타입 참조변수 = 자식객체
		Car car3 = new Spark();
		// Spark 객체를 참조하는 변수(car3)의 타입이 Car(부모)타입이기 때문에
		// Spark 객체가 Car(부모) 겍체로 변화함(Up Casting)
		
	// ** 다형성(업캐스팅) 작성방법 **
		// 1) 자식 객체가 부모 객체로 변하였기 때문에 자식만의 고유한 필드, 메서드를 사용할 수 없음
		//   1-1) car(부모타입 = 부모객체)
		car.setEngine("v6 6기통 엔진");
		car.setFuel("휘발유");
		car.setWheel(4);
		
		//   1-2) tesla(자식타입 = 자식객체)
		tesla.setEngine("전기모터");		// 부모 메서드
		tesla.setFuel("전기");				// 부모 메서드
		tesla.setWheel(4);					// 부모 메서드
		tesla.setBatteryCapacity(1000000);	// 자식 메서드
		
		//   1-3) car2(부모타입 = 자식객체) : 업캐스팅이 된 상태
		car2.setEngine("전기모터");
		car2.setFuel("전기");
		car2.setWheel(4);
//		car2.setBatteryCapacity(1000000);	// 자식객체 메서드 사용불가
		// 에러 문구 : The method setBatteryCapacity(int) is undefined for the type Car
		// 부모타입 참조변수이기 때문에 Tesla 의 고유필드, 메서드 사용 불가능!
		
		//   1-4) car3(부모타입 = 자식객체) : 업캐스팅이 된 상태 1-3과 동일
		car3.setEngine("경차 엔진");
		car3.setFuel("휘발유");
		car3.setWheel(4);
//		car3.setDiscountOffer(0.5);
		// 에러 문구 : The method setDiscountOffer(double) is undefined for the type Car
		
		// 2) 다형성을 이용한 객체배열
		// 객체 배열 : 같은 객체 참조 자료형의 변수를 하나의 묶음으로 다루는 것
		// 다형성을 이용한 객체 배열 : 부모 타입 참조 자료형의 변수를 하나의 묶음으로 다루는 것
		Car[] arr = new Car[3];		// 부모타입 참조변수 배열 선언 및 할당
		// 각 배열 요소는 Car 타입 참조변수이어야 함!
		arr[0] = car;	// Car 객체의 주소(Car 타입)
		arr[1] = car2;	// Tesla 객체의 주소(Car 타입)
		arr[2] = car3;	// Spark 객체의 주소(Car 타입)
		
		for(int i=0; i<arr.length; i++) System.out.println(i+"번째 인덱스의 엔진 : " + arr[i].getEngine());
		
		// 상속 + 다형성
		// 상속 특징 : Car 상속 클래스(Tesla, Spark)는 모두 getEngine() 을 갖고 있음
		// 다형성(업캐스팅) : 부모타입 참조변수 arr[i]로 자식객체를 참조할 수 있음
	}
	
	// 전달받은 Car 또는 자식객체(Tesla, Spark)의 엔진, 연료, 바퀴갯수의 출력 메서드
	public void printCar(Car temp) {		// ex2()에 사용하는 메서드
		// 부모타입 참조변수 = 자식타입 객체
		// Car temp = t
		// Car temp = s
		// Car temp = c
		// 다형성의 업캐스팅 모양과 같다
		// temp 라는 매개변수에는 Tesla, Spark, Car 의 주소가 넘어와도 됨(by 업캐스팅)
		System.out.println("엔진 : " + temp.getEngine());
		System.out.println("연료 : " + temp.getFuel());
		System.out.println("바퀴 갯수 : " + temp.getWheel() + "개");
		System.out.println();		// 줄바꿈 용도
	}
	
	// 매개변수로 전달받은 정수값에 따라 Car, Tesla, Spark 객체를 만들어 반환하는 메서드
	public Car createCar(int num) {			// ex2()에 사용하는 메서드
		
		Car result = null;
		
		switch(num) {
		case 1: result = new Car(); break;
		case 2: result = new Tesla(); break;
		case 3: result = new Spark(); break;
		}
		
		return result;
	}
	
	public void ex2() {		// 다형성 중 업캐스팅
		
		// 다형성(업캐스팅)을 이용한 매개변수 사용법
		
		Tesla t = new Tesla("전기모터", "전기", 4, 1000000);
		Spark s = new Spark("경차엔진", "휘발유", 4, 0.5);
		Car c = new Car("경유엔진", "경유", 12);
		
		printCar(t);
		printCar(s);
		printCar(c);
		
		System.out.println("--------------------------------------------");
		
		// 다형성을 이용한 반환형 사용법
//		Car[] arr = {new Car(), new Tesla(), new Spark()};을 메서드를 이용하여 나타내는 방법
		
		Car[] arr = {createCar(1), createCar(2), createCar(3)};
		//			{    Car	 ,	Car(Tesla) ,  Car(Spark) }
		
		// 객체가 어떤 타입(자료형)인지 검사하는 방법 : instanceof 연산자(전부 소문자)
		// -> 참조하는 객체가 특정 자료형이거나 상속관계인지 확인
		System.out.println( arr[1] instanceof Tesla );	// true (자기 본인 맞음)
		System.out.println( arr[1] instanceof Spark );	// false (Spark 와 관계 없음)
		System.out.println( arr[1] instanceof Car );	// true (부모 -> 상속관계)
	}
	
	public void ex3() {		// 다형성 중 다운캐스팅
		// 다운캐스팅이란?
		// 부모타입 참조변수가 자식객체를 참조하는 기술(업캐스팅)이 적용된 상태에서,
		// 부모타입을 자식타입으로 "강제 형변환"해서 자식 객체의 본래 필드, 메서드를
		// 사용가능하게 하는 방법!
		
	// 부모타입 참조변수 = 자식객체
		Car c1 = new Tesla("전기모터", "전기", 4, 50000);	// 업캐스팅 상태
		
		System.out.println( ((Tesla)c1).getBatteryCapacity() );
		// 주의사항 : .연산자가 형변환연산자보다 우선순위가 높음
		// 형변환 하는 부분을 ( )로 한 번 묶어주고 나서 .연산을 진행해야
		// Tesla 객체의 getBatteryCapacity() 를 사용할 수 있음
		
		Tesla t1 = (Tesla)c1;
		// (부모) Car 타입으로 업캐스팅 된 c1을 Tesla 타입으로 다운캐스팅(강제 형변환)하여
		// (자식) Tesla 타입 참조변수 t1에 대입
		System.out.println(t1.getBatteryCapacity());
	}
	
	public void ex4() {		// 다운캐스팅 시 주의사항
		
		Car c1 = new Tesla();	// Tesla 객체(오른쪽)를 만들어 Car 타입 참조변수 c1(왼쪽)에 담음
		
//		Spark s1 = (Spark) c1;	// c1을 관계없는 Spark 로 다운캐스팅 하려고 함
		// 다운캐스팅을 잘못해도 컴파일 에러가 발생하지 않음
		// -> 실행 시 발생(런타임 에러), java.lang.ClassCastException(형변환 예외)
		
		// 런타임 에러 : 프로그램 실행 시 발생하는 예외(에러)
		// 컴파일 에러 : 실행 전 코드에 빨간줄이 생기는 에러
		
		// 해결방법 : instanceof 와 같이 사용해야 함!
		
		// 예외 처리 방법
		if(c1 instanceof Spark) {	// c1이 Spark 이거나 상속관계인 경우
			Spark s1 = (Spark) c1;
			System.out.println("다운캐스팅 성공");
		}else {
			System.out.println("다운캐스팅 실패. Spark 타입 아님");
		}
	}
	
	public void ex5() {		// 바인딩(Binding)
		// 바인딩 : 실제 실행할 메서드 코드와 호출하는 코드를 연결시키는 것
		
		Car c1 = new Car("경유엔진", "경유", 8);
		
		System.out.println( c1.toString());
		// edu.kh.poly.ex1.model.dto.Car.toString()
		// Car 객체에 있는 toString() 메서드를 호출 == 바인딩
		// 프로그램 "실행 전"
		// - 컴파일러는 toString() 메서드가 Car 에 있는 것으로 인식해서
		//   c1.toString() 호출코드와 edu.kh.poly.ex1.model.dto.Car.toString() 메서드를 연결
		// -> 이를 정적 바인딩 이라고 함
		
		// ** 다형성 적용 시 바인딩 **
		Car c2 = new Spark("경차엔진", "휘발유", 4, 0.5);	
		// 업캐스팅 적용(부모 부분만 참조가능한 상태)
		
		System.out.println(c2.toString());
		// edu.kh.poly.ex1.model.dto.Car.toString()
		// 참조변수 c2가 Car 타입이므로 toString() 메서드도 Car 의 toString() 호출(정적바인딩 상태)
		
		// 하지만 실행해보면 자식(Spark)의 toString()이 호출됨!!
		// -> 컴파일 시에는 부모(Car)와 바인딩 == 정적바인딩
		// -> "실행 시"에는 자식(Spark)의 오버라이딩된 메서드와 바인딩 == 동적바인딩
	}
	
	// getter, setter
	
}
