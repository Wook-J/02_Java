package com.hw1.run;

import com.hw1.model.dto.Book;
import com.hw1.model.dto.Novel;
import com.hw1.model.dto.Poetry;
import com.hw1.model.dto.TextBook;

public class Run {
	public static void main(String[] args) {
		Book[] arr = new Book[3];
		
		// 부모타입 참조변수 = 자식객체 (업캐스팅)
		arr[0] = new Novel("해리포터", "J.K. 롤링", "판타지");
		arr[1] = new TextBook("자바 프로그래밍", "James Gosling", "컴퓨터 과학");
		arr[2] = new Poetry("우리들의 사랑시", "김소월", 30);
		
		for(Book b : arr) {			// 업캐스팅 상태로 Book 타입 참조변수 불러올 수 있음 
			b.displayInfo();		// 동적 바인딩
		}
	}
}
