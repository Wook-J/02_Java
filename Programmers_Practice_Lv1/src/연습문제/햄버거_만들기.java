package 연습문제;

import java.util.ArrayList;
import java.util.List;

public class 햄버거_만들기 {
	/* 문제 흐름 : 시간초과떠서 다른사람 풀이 확인함
	 * 1. 빵의 첫번쨰 인덱스 구함
	 * 2. 연속해서 1231인지 확인
	 * 2-1. 1231이 아니면 첫번째 빵인덱스까지 삭제
	 * 2-2. 1231이 맞으면 첫번째 빵인덱스~다음 요소3개 삭제 & answer 1더하기
	 * 3. 요소개수가 0 또는 빵의 첫번째인덱스가 -1 이면 탈출
	 * */
	
	public int solution(int[] ingredient) {
		int answer = 0;
		
		List<Integer> ingredList = new ArrayList<Integer>();
		for(int ele : ingredient) ingredList.add(ele);
		System.out.println("요소 확인용 : " + ingredList);
		
		int firstIndexBbang = ingredList.indexOf(1);

		while(firstIndexBbang != -1) {
			System.out.println("첫빵 인덱스 확인용 : " + firstIndexBbang);
			
			int escapeCount = 0;
					
			for(int i=firstIndexBbang; i<ingredList.size()-3; i++) {
				int yachaeConfirm = ingredList.get(i+1);
				int gogiConfirm = ingredList.get(i+2);
				int bbang2Confirm = ingredList.get(i+3);
				
				if(yachaeConfirm==2 && gogiConfirm==3 && bbang2Confirm==1) {
					answer++;
					for(int j=0; j<4; j++) ingredList.remove(i);
					System.out.println("한번 뽑힙");
					System.out.println("제거된 후 리스트 :" + ingredList);
					firstIndexBbang = ingredList.indexOf(1);
					break;
				}
				escapeCount++;
			}
			System.out.println("탈출 숫자 : " + escapeCount);
			if(escapeCount==ingredList.size()-3) break;
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
