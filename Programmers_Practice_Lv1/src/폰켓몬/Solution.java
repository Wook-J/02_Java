package 폰켓몬;

public class Solution {

    public int solution(int[] nums) {
    	
    	/* 
    	 * N마리 포켓몬 중 N/2 마리 가져가기
    	 * ex1) 4 마리 [3, 1, 2, 3] -> 2마리 고르는 방법
    	 *  4C2 = 6가지[ (3,1), (3,2), (3,3), (1,2), (1,3), (2,3) ]
    	 *  각 배열에서 다른 숫자 개수 찾기
    	 * 
    	 * ex2) 6 마리 [3, 3, 3, 2, 2, 4] -> 3마리 고르는 방법
    	 *  6C3 = 20가지...?
    	 *  각 배열에서 다른 숫자 개수 찾기 -> 최대 3(2,3,4)개
    	 * 
    	 * nums 는 1차원 배열, 1~10000 짝수
    	 * 폰켓몬의 종류 번호(1차원 배열의 각 요소의 값) 는 1~200000 자연수
    	 * 가장많은 종류 선택방법 여러개 있더라도 종류개수의 최대값만 return
    	 * */
    	
    	// 로또번호 생성기 04_array에서 ArrayExample2
    	
    	int[] takeNumArr = new int[nums.length / 2];
    	
        int answer = 0;
        return answer;
    }
}
