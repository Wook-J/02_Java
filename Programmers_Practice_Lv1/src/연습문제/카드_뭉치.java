package 연습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 카드_뭉치 {
	
	public String solution(String[] cards1, String[] cards2, String[] goal) {
		System.out.println(Arrays.toString(cards1) +", "+ Arrays.toString(cards2) + " -> " +Arrays.toString(goal));	// 들어온 문자 확인용
		
		int card1_index = 0;
		int card2_index = 0;
		List<String> goalList = new ArrayList<String>();
		for(String str : goal) goalList.add(str);
		
		System.out.println(goalList);					// 문자출력 확인용
		
		while(true) {
			if(goalList.size()==0) return "yes";
			
			for(String goalWord: goalList) {
				if(goalWord.equals(cards1[card1_index])) {
					goalList.remove(0);
					System.out.println("card1 index : " + card1_index);
					card1_index++;
					break;
					
				}else if(goalWord.equals(cards2[card2_index])){
					goalList.remove(0);
					System.out.println("card2 index : " + card2_index);
					card2_index++;
					if(card2_index == cards2.length) return "No";
					break;
				} else return "No";
			}
		}
	}

}

// 논리구조(문지 중복 없음)
// goalList의 첫번쨰 요소(i)를 cards1 or cards2의 0번쨰요소에서 찾음
// 1. cards1의 요소에 있음 -> goalList 요소 삭제 및 cards1의 인덱스 1증가
// 2. cards2의 요소에 있음 -> goalList 요소 삭제 및 cards2의 인덱스 1증가
// 최대 goalList.size()턴까지 돌림... 끝까지 못가면 "NO" 반환