package edu.kh.oop.practice.run;

//import edu.kh.oop.practice.model.service.BookService;
import edu.kh.oop.practice.model.service.HeroService;

public class PracticeRun {

	public static void main(String[] args) {
		
		// 클래스 안에 생성자가 하나도 없다면 컴파일러가 기본생성자 자동으로 만들어줌
		// -> 그래서 우리가 BookService()를 사용할 수 있음!
		
		// 생성자가 하나라도 있으면 기본생성자 자동으로 생성X
		// -> 매개변수 생성자를 만들었다면 개발자가 기본생성자를 만들어야함!
		
//		BookService bs = new BookService();
//		bs.practice();		
		
		HeroService hs = new HeroService();
		hs.practice();
		
	}
}
