package 기타;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 예산 {
	public int solution(int[] d, int budget) {
		int answer = 0;

		List<Integer> dList = new ArrayList<>();
		for(int num : d) dList.add(num);
		System.out.println(dList);					// 리스트 확인용
		
		// 논리구조
		/* 0번쨰 인덱스 값 뽑기
		 * 최소값 추출
		 * 최소값을 갖고 있는 인덱스 요소 삭제 + answer 1증가 + budget 감소
		 * budget >= 0 까지 반복
		 * */
		
		while(budget >= 0) {
			int minNum = dList.get(0);
			for(int ele : dList) if(ele<minNum) minNum = ele;
//			System.out.println("minNum : " + minNum);
			if(!dList.isEmpty()) {
				budget -= minNum;
				if(budget <0) break;
				answer++;
				dList.remove(dList.indexOf(minNum));
			}else break;
			
			if(dList.isEmpty()) break;
		}

		return answer;
    }

	public int solution2(int[] d, int budget) {
		
	      int answer = 0;
	      Arrays.sort(d);

	      for (int i = 0; i < d.length; i++) {
	    	  budget -= d[i];
	    	  if (budget < 0) break;
	    	  answer++;
	      }

	      return answer;
	  }
}
