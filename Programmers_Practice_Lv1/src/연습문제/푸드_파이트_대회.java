package 연습문제;

import java.util.Arrays;

public class 푸드_파이트_대회 {
	
	public String solution(int[] food) {
		System.out.println(Arrays.toString(food));			// 전달인자 확인용
		String answer = "";
		
		for(int i=1; i<food.length; i++) {
			for(int j=1; j<=food[i]/2; j++) answer+=i;
		}
		answer+=0;
		for(int i=food.length-1; i>=1; i--) {
			for(int j=1; j<=food[i]/2; j++) answer+=i;
		}
		return answer;
    }
}
