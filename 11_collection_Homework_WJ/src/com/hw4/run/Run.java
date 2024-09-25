package com.hw4.run;

import com.hw4.model.service.BookService;

public class Run {

	public static void main(String[] args) {
		
		BookService service = new BookService();
		
		service.displayMenu();

	}

}
