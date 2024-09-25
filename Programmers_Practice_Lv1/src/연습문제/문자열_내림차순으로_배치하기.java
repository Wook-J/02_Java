package 연습문제;

import java.util.Arrays;
import java.util.Collections;

public class 문자열_내림차순으로_배치하기 {
   
	public String solution(String s) {
		String answer = "";
		
		String[] strArr = s.split("");
		Arrays.sort(strArr, Collections.reverseOrder());		// char[] 에서는 .sort() 사용불가능!
		
		for(String str : strArr) {
			answer+=str;
		}

		return answer;
	}
	
	public String solution2(String s) {
		
		String answer = "";
		char[] charArr = s.toCharArray();
		Arrays.sort(charArr);
		
		for(int i=charArr.length-1; i>=0; i--) answer += charArr[i];
		
		return answer;

	}
}
