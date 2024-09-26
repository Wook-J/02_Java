package 연습문제;

import java.util.Arrays;

public class 서울에서_김서방_찾기 {

	public String solution(String[] seoul) {
		String answer = "";
		
		for(int i=0; i<seoul.length; i++) {
			if(seoul[i].equals("Kim")) {
				answer = "김서방은 " + i + "에 있다";
				break;
			}
		}
		return answer;
	}
	
	public String solution2(String[] seoul) {
		return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다";
	}
}
