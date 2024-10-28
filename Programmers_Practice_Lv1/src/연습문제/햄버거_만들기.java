package 연습문제;

import java.util.ArrayList;
import java.util.List;

public class 햄버거_만들기 {
	public int solution(int[] ingredient) {
		int answer = 0;
		
		List<Integer> ingredList = new ArrayList<Integer>();
		for(int ele : ingredient) ingredList.add(ele);
		System.out.println(ingredList);		// 요소 확인용
		
		int firstIndexBbang;
		/* 문제 흐름
		 * 1. 빵의 첫번쨰 인덱스 구함
		 * 2. 연속해서 1231인지 확인
		 * 2-1. 1231이 아니면 첫번째 빵인덱스까지 삭제
		 * 2-2. 1231이 맞으면 첫번째 빵인덱스~다음 요소3개 삭제 & answer 1더하기
		 * 3. 요소개수가 0 또는 빵의 첫번째인덱스가 -1 이면 탈출
		 * */
		while(true) {
			firstIndexBbang = ingredList.indexOf(1);
			System.out.println(firstIndexBbang);
			if(firstIndexBbang+3>ingredList.size()) break;
			
			if((ingredList.get(firstIndexBbang+1)==2) && (ingredList.get(firstIndexBbang+2)==3) &&
					(ingredList.get(firstIndexBbang+3)==1)) {
				answer++;
				for(int i=0; i<4; i++) ingredList.remove(firstIndexBbang);
				System.out.println(ingredList);
			}else {
				for(int i=0; i<firstIndexBbang; i++) ingredList.remove(0);
				System.out.println(ingredList);
			}
			
			if(firstIndexBbang==-1 || ingredList.size()==0) break;
		}
		
		return answer;
    }
	
	
	// 전부 실행되지는 않음(시간초과)
	public int solution2(int[] ingredient) {
		
		int answer = 0;

		List<Integer> ingredList = new ArrayList<Integer>();
		for(int ele : ingredient) ingredList.add(ele);
		System.out.println(ingredList);
		
		int bbangIndex;
		boolean flag;
		
		do {
			bbangIndex = ingredList.indexOf(1);
			flag = true;
			
			for(int i=bbangIndex; i<ingredList.size()-3; i++) {
				if((ingredList.get(i+1)==2) && (ingredList.get(i+2)==3) && (ingredList.get(i+3)==1)) {
					answer++;
					flag = false;
					for(int j=0; j<4; j++) ingredList.remove(i);
					System.out.println(ingredList);
					break;
				}
			}
			
			if(flag) break;
			
		}while(bbangIndex != -1);
		
		return answer;
		/*	[2, 1, (1), (2), (3), (1), 2, 3, 1]
		 *  [2, (1), (2), (3), (1)]
		 *  [2]
		 * */
    }

}
