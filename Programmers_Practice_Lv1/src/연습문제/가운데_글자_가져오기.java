package 연습문제;

public class 가운데_글자_가져오기 {
    public String solution(String s) {
    	int length = s.length();
    	
    	if(length%2 == 0) {			// 길이가 짝수
    		return s.substring(length/2 - 1, length/2 +1);
    	}else {						// 길이가 홀수
    		return s.substring((length-1)/2, (length+1)/2);
    	}
    }
}
