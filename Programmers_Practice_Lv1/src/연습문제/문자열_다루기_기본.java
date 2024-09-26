package 연습문제;

public class 문자열_다루기_기본 {
	public boolean solution(String s) {
		
		boolean answer = true;
		
		int sLength = s.length();
		answer = (sLength==4 || sLength==6) ? true: false;
		
		try {
			Integer.parseInt(s);
		}catch(NumberFormatException e) {
			answer = false;
		}

		return answer;
	}
}
