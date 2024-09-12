package edu.kh.exception.model.service;

public class UserException extends Exception{
	// Exception 은 Checked Exception 임!
	// 이를 상속받은 UserException 은 반드시 처리해야함!

	public UserException() {}
	
	public UserException(String msg) {		// message 의 줄임말
		super(msg);
	}
}
