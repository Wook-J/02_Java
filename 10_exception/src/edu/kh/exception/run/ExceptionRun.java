package edu.kh.exception.run;

import edu.kh.exception.model.service.ExceptionService;
import edu.kh.exception.model.service.UserException;

public class ExceptionRun {

	public static void main(String[] args) {

		ExceptionService excep = new ExceptionService();
//		excep.ex1();
//		excep.ex2();
//		excep.ex3();
		excep.ex4();
		
		try {
			new ExceptionService().ex5();
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
	}

}
