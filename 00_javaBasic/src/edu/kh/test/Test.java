package edu.kh.test;

import java.util.ArrayList;
import edu.kh.test.model.vo.Student;

public class Test {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();		// 수정된 코드 있음
		list.add(new Student("강건강", 84));					// Student Class 에서 코드 수정
		list.add(new Student("남나눔", 78));
		list.add(new Student("도대담", 96));
		list.add(new Student("류라라", 67));

		for(int i=0; i<list.size(); i++) {						// 수정된 코드 있음
			Student s = list.get(i);
			System.out.println(s);								// Student Class 에서 코드 수정
		}
	}
}


/*
 * 1. 8줄에 NullPointerException 나옴
 *    -> 새로운 객체를 만들어서 주소값을 대입해야함 
 *    -> null 대신 new ArrayList<Student>() 로 변경!
 * 
 * 2. 9~12줄에 매개변수생성자 정의 안되어있음
 *    -> Student Class 에서 매개변수 생성자 생성!
 * 
 * 3. 14줄에 List의 경우 length()가 아니라 size()로 구해야함
 *    -> list.length() 대신 list.size() 로 변경!
 * 
 * 4. 16줄에 toSting이 Overriding 되어 있지 않아 주소값이 출력됨
 *    -> Student Class 에서 Override 해야함!
 * */