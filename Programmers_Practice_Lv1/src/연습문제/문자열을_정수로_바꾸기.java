package 연습문제;

public class 문자열을_정수로_바꾸기 {
	
    public int solution(String s) {
    	int answer = 0;
    	
    	if(s.charAt(0) == '+' ) answer = Integer.parseInt(s.substring(1));
    	else if(s.charAt(0) == '-' ) answer = -Integer.parseInt(s.substring(1));
    	else answer = Integer.parseInt(s);
    	
    	return answer;
    }
}
