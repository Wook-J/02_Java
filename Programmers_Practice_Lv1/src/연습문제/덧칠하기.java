package 연습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 덧칠하기 {
	
	public int solution(int n, int m, int[] section) {
		System.out.printf("n: %d, m: %d/ section : %s\n", n, m, Arrays.toString(section));		// 초기조건 확인용
		int answer = 0;
		
		List<Boolean> secAll = new ArrayList<Boolean>();
		for(int i=0; i<n; i++) secAll.add(true);
		for(int morePaint : section) secAll.set(morePaint-1, false);
		
		System.out.println(secAll);					// 초기상태 확인용
		
		System.out.println(secAll.indexOf(false));	// 첫번째 false 인 인덱스
		while(true) {
			if(secAll.indexOf(false) == -1) break;
			
			for(int i=0; i<m; i++) secAll.set(secAll.indexOf(false), true);
			answer++;
		}
		
		System.out.println(secAll);					// 최종상태 확인용

		
		return answer;
    }

}
