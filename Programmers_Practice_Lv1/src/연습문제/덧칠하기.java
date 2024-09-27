package 연습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 덧칠하기 {
	
	public int solution(int n, int m, int[] section) {
//		System.out.printf("n: %d, m: %d/ section : %s\n", n, m, Arrays.toString(section));		// 초기조건 확인용
		int answer = 0;
		
		List<Boolean> secAll = new ArrayList<Boolean>();
		for(int i=0; i<n; i++) secAll.add(true);
		for(int morePaint : section) secAll.set(morePaint-1, false);
		
//		System.out.println(secAll);												// 초기상태 확인용
//		System.out.println("첫 번째 false의 index : " +secAll.indexOf(false));	// 첫번째 false 인 인덱스 확인용
		
		int falseIndex = secAll.indexOf(false);
		
		while(falseIndex != -1) {
			
			for(int i=falseIndex; i<falseIndex+m; i++) {
				if(i==secAll.size()) break;				// secAll 의 마지막 index 넘어가면 탈출
				secAll.set(i, true);
			}
			
			answer++;
			falseIndex = secAll.indexOf(false);			// 다음 false 인 index 찾기
//			System.out.println(answer +"회 진행, 현재 secAll : " + secAll);		// 몇번 진행됐는지 확인용
		}

		return answer;
    }
	
	public int solution2(int n, int m, int[] section) {
		int roller = section[0];					// 처음으로 칠해야하는 요소
		int answer = 1;								// 최소 1번을 칠해지므로
		
		for(int i = 1; i < section.length; i++) {
			if(roller + m - 1 < section[i]) {		// roller 부터 m개 칠한 마지막 숫자 < section 의 다음 요소
				roller = section[i];				// 그 section 의 요소부터 다시 롤러필요
				answer++;							// 칠해지는 횟수 추가
			}
		}
		
		return answer;
	}
	
	
}
