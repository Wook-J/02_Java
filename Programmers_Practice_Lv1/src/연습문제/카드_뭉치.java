package 연습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 카드_뭉치 {
	
	/** List 쓰고 해결했음
	 * @param cards1
	 * @param cards2
	 * @param goal
	 * @return
	 */
	public String solution(String[] cards1, String[] cards2, String[] goal) {
		System.out.println(Arrays.toString(cards1) +", "+ Arrays.toString(cards2) + " -> " +Arrays.toString(goal));	// 들어온 문자 확인용
		
		int card1_index = 0;
		int card2_index = 0;
		
		List<String> goalList = new ArrayList<String>();
		for(String str : goal) goalList.add(str);
		
		System.out.println("goalList 내용 : " + goalList);					// 문자출력 확인용
		
		for (String str : goalList) {
			if(card1_index == cards1.length) {				// cards1 안에 String 다 쓴 경우
				if (str.equals(cards2[card2_index])) card2_index++;
				
			} else if (card2_index == cards2.length) {		// cards2 안에 String 다 쓴 경우
				if(str.equals(cards1[card1_index])) card1_index++;
				
			}else {											// cards1, cards2 둘다 String 다 안 쓴경우
				if(str.equals(cards1[card1_index])) card1_index++;
				else if (str.equals(cards2[card2_index])) card2_index++;
				
			}
		}
		
		return card1_index+card2_index == goalList.size() ? "Yes" : "No";
	}
	
	/** List 안쓰고 해결하는 방법 만들기!
	 * @param cards1
	 * @param cards2
	 * @param goal
	 * @return
	 */
	public String solution2(String[] cards1, String[] cards2, String[] goal) {
		
		int card1_index = 0;
		int card2_index = 0;
		
		for (String str : goal) {
			if(card1_index == cards1.length) {				// cards1 안에 String 다 쓴 경우
				if (str.equals(cards2[card2_index])) card2_index++;
				
			} else if (card2_index == cards2.length) {		// cards2 안에 String 다 쓴 경우
				if(str.equals(cards1[card1_index])) card1_index++;
				
			}else {											// cards1, cards2 둘다 String 다 안 쓴경우
				if(str.equals(cards1[card1_index])) card1_index++;
				else if (str.equals(cards2[card2_index])) card2_index++;
				
			}
		}
		
		return card1_index+card2_index == goal.length ? "Yes" : "No";
	}

}

//		초기 코드
//
//		while(true) {
//			System.out.println("------- 각 turn에 수행된 내용 -------");	// 내용 확인용
//			if(goalList.size()==0) return "yes";
//			if(card1_index != cards1.length && card2_index ==cards2.length) return "No";
//			
//			for(String goalWord: goalList) {
//				if(goalWord.equals(cards1[card1_index]) || goalWord.equals(cards2[card2_index])) {
//					if(goalWord.equals(cards1[card1_index])) card1_index++;
//					else if (goalWord.equals(cards2[card2_index])) card2_index++;
//					
//					goalList.remove(0);
//					System.out.println("card1 index : " + card1_index);				// card1_index 확인용
//					System.out.println("card2 index : " + card2_index);				// card2_index 확인용
//					System.err.println("삭제되고 남은 goalList : " + goalList);		// 남은 goalList 확인용
//					break;
//					
//				}else return "No";
//			}
//		}

// 논리구조(문지 중복 없음)
// goalList의 첫번쨰 요소(i)를 cards1 or cards2의 0번쨰요소에서 찾음
// 1. cards1의 요소에 있음 -> goalList 요소 삭제 및 cards1의 인덱스 1증가
// 2. cards2의 요소에 있음 -> goalList 요소 삭제 및 cards2의 인덱스 1증가
// 최대 goalList.size()턴까지 돌림... 끝까지 못가면 "NO" 반환