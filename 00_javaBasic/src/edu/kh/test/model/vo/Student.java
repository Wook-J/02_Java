package edu.kh.test.model.vo;

public class Student {

	// 필드, 멤버변수
	private String name;
	private int score;
	
	// 생성자
	public Student() {}
	
			
	public Student(String name, int score) {				// Test Class 의 11~14줄 문제 해결을 위한 코드 새로 작성
		this.name = name;
		this.score = score;
	}



	// 메서드
	@Override
	public String toString() {
		return name +" 학생의 점수 : " + score + "점";		// Test Class 의 18줄 문제 해결을 위한 코드 수정
	}			// 원래 super.toString() 이었음
	
	// getter setter
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
