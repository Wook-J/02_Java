package 기타;

import java.util.Arrays;

public class 음양_더하기 {
	public int solution(int[] absolutes, boolean[] signs) {
		System.out.println("absolutes : " + Arrays.toString(absolutes));
		System.out.println("signs : " + Arrays.toString(signs));
		
		int answer = 0;
		for(int i=0; i<absolutes.length; i++) {
			if(signs[i]) answer += absolutes[i];
			else answer -= absolutes[i];
		}
		return answer;
    }

}
