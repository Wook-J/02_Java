package 연습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 대충_만든_자판 {
	
	/** 최종 수정버전
	 */
	public int[] solution(String[] keymap, String[] targets) {
		
		// answer 배열 선언 및 크기 설정
		int[] answer = new int[targets.length];
		
		// targets : [ABCD, AABB] 인경우
		// targetList : [[A, B, C, D], [A, A, B, B]]
		List<String[]> targetList = new ArrayList<String[]>();
		for(String str :targets) targetList.add(str.split(""));
		
		
		// keymap : [ABACD, BCEFD], targets : [ABCD, AABB] 인 경우
		for(String[] targetArr : targetList) {
			
			// 인덱스 숫자배열의 배열 만들기 --------------------------------------------------
			// 1턴 : [0, -1][1, 0][3, 1][4, 4]
			// 2턴 : [0, -1][0, -1][1, 0][1, 0]
			List<int[]> tempList = new ArrayList<int[]>();		
			
			for(String target : targetArr) {
				int[] temp = new int[keymap.length];	
				for(int i=0; i<temp.length; i++) temp[i] = keymap[i].indexOf(target);
				tempList.add(temp);
			}
			
			// 인덱스 숫자 배열 만들기 ----------------------------------------------------------
			// 1턴 : [0, 0, 1, 4]
			// 2턴 : [0, 0, 0, 0]
			List<Integer> tempList2 = new ArrayList<Integer>();
			
			for(int[] tempArr : tempList) {
				
				// keymap 에 target 문자 중 하나라도 없는 경우 처리
				int minus1count = 0;
				
				for(int i=0; i<tempArr.length;i++) {
					if(tempArr[i]==-1) minus1count++;
				}
				
				if(minus1count == tempArr.length) {
					tempList2.add(-1);
					continue;
				}
				
				// keymap 에 targets 문자가 모두 있는 경우
				int inputKeyNum = 101;					// 문자열 길이 최대 100이므로 그보다 큰수
				for(int i=0; i<tempArr.length; i++) {	// -1 제외하고 가장 작은 숫자 고르기
					if(tempArr[i] != -1) inputKeyNum = inputKeyNum>tempArr[i] ? tempArr[i] : inputKeyNum;
				}
				tempList2.add(inputKeyNum);
			}
			// answer 에 들어가는 값 구하기----------------------------------------------
			// 1턴 : tempList2.size() + 0 + 0 + 1 + 4 + = 9
			// 2턴 : tempList2.size() + 0 + 0 + 0 + 0 + = 4
			int revisionCount = tempList2.size();
			
			for(int inputKeyNum : tempList2) {
				if(inputKeyNum == -1) {		// tempList2의 요소에서 하나라도 -1 이 있는 경우(달성불가능함)
					revisionCount = -1;
					break;
				}
				revisionCount+=inputKeyNum;
			}
			
			answer[targetList.indexOf(targetArr)] = revisionCount;
			
		}
		
		return answer;
	}
	
	/** 맨처음 만든 버전
	 * 중간중간 확인하느라 print 구문 있음
	 */
	public int[] solution2(String[] keymap, String[] targets) {
		
//		String strEx = "wesdwea";						//시험용
//		System.out.println(strEx.contains("we"));		//시험용	return 있으면 true 없으면 false
//		System.out.println(strEx.indexOf("ea"));		//시험용	return 있으면 index 없으면 -1
		
		System.out.println("keymap : " + Arrays.toString(keymap) +", targets : " + Arrays.toString(targets));	// 대입형태 확인용
		
		int[] answer = new int[targets.length];
		
		List<String[]> targetList = new ArrayList<String[]>();
		for(String str :targets) targetList.add(str.split(""));
		

		for(String[] targetArr : targetList) {				// targetList 확인용
			System.out.println("targetList : " + Arrays.toString(targetArr));
		}
		System.out.println("=================================================");
		
		// 논리 흐름
		// targetList의 요소(targetArr)의 요소를(A, B, C, D)순회하며 keymap(배열)의 요소(ABACD, BCEFD)의 인덱스 배열을 만들고
		// A -> {0, -1}, B -> {1, 0}, C -> {3, 1}, D -> {4, 4}		 이 배열들을 순차 keymapIndexList 에 추가
		// A -> {0, -1}, A -> {0, -1}, B -> {1, 0}, B -> {1, 0}
		
		// 인덱스 배열의 중 하나라도 그 요소가 전부 -1 이면 그 answer의 요소는 -1
		// 그 배열에서 -1 아닌 최소값을 각가 추출한 후 전부 더하고 +요소개수(index는 0부터 시작하므로)를 answer의 요소로
		// (0 + 0 + 1 + 4) + 4(A, B, C, D 총 4개) -> answer 첫 번째 값 == 9
		// (0 + 0 + 0 + 0) + 4(A, A, B, B 총 4개) -> answer 두 번째 값 == 4
		
		for(String[] targetArr : targetList) {

			List<int[]> tempList = new ArrayList<int[]>();
			
			for(String target : targetArr) {			// A, B, C, D 를 순회
				
				int[] temp = new int[keymap.length];	// 인덱스배열 만들기
				for(int i=0; i<temp.length; i++) {
					temp[i] = keymap[i].indexOf(target);
				}
				tempList.add(temp);
			}
			System.out.print("tempList : ");											// tempList 확인용
			for(int[] tempArr : tempList) System.out.print(Arrays.toString(tempArr));	// tempList 확인용
			System.out.println();														// tempList 확인용
			
			//----------------------------------------------------------
			List<Integer> tempList2 = new ArrayList<Integer>();
			
			for(int[] tempArr : tempList) {
				int minus1count = 0;
				
				for(int i=0; i<tempArr.length;i++) {
					if(tempArr[i]==-1) minus1count++;
				}
				if(minus1count == tempArr.length) {
					tempList2.add(-1);
					continue;
				}
				
				int inputKeyNum = 101;
				for(int i=0; i<tempArr.length; i++) {
					if(tempArr[i] != -1) inputKeyNum = inputKeyNum>tempArr[i] ? tempArr[i] : inputKeyNum;
				}
				tempList2.add(inputKeyNum);
			}
			System.out.println("tempList2 : " + tempList2);								// tempList2 확인용
			

			//----------------------------------------------------------------------
			int revisionCount = tempList2.size();
			
			for(int inputKeyNum : tempList2) {
				if(inputKeyNum == -1) {
					revisionCount = -1;
					break;
				}
				revisionCount+=inputKeyNum;
			}
			
			answer[targetList.indexOf(targetArr)] = revisionCount;
			
		}
		
		return answer;
    }

}
