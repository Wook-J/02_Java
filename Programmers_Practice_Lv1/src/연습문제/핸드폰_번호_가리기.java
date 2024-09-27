package 연습문제;

public class 핸드폰_번호_가리기 {
	
	public String solution(String phone_number) {
		
		String answer = "";
		
		for(int i=0; i<phone_number.length(); i++) {
			if(i<phone_number.length()-4) answer +="*";
			else answer += phone_number.charAt(i);
		}
		
		return answer;
    }

	public String solution2(String phone_number) {
		
		String answer = "";
		
		for (int i = 0; i < phone_number.length() - 4; i++) answer += "*";
		answer += phone_number.substring(phone_number.length() - 4);

		return answer;
	  }
	
}
