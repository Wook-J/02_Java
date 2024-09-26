package 연습문제;

import java.util.Arrays;

public class 이상한_문자_만들기 {
	public String solution(String s) {
		String answer ="";
		String[] sArr = s.split("");
		System.out.println(Arrays.toString(sArr));
		int evenOrOdd = 0;
		
		for(String ele : sArr) {
			if(ele == " ") {
				answer += " ";
			}else {
				if(evenOrOdd%2 == 0) answer += ele.toUpperCase();
				else answer += ele.toLowerCase();
				
				evenOrOdd++;				
			}
		}
		return answer;
	}
}
