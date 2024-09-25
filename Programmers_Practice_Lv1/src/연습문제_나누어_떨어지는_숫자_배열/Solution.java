package 연습문제_나누어_떨어지는_숫자_배열;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
    	
    	/*
    	 * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
    	 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
    	 * 
    	 * Solution practice = new Solution();
    	 * int[] arr = new int[] {5, 9, 7, 10};
    	 * System.out.println(practice.solution(arr, 5));
    	 * 
    	 * */
    	List<Integer> list = new ArrayList<Integer>();
    	for(int ele : arr) {
    		if(ele % divisor==0) {
    			list.add(ele);
    		}
    	}
    	System.out.println(list);
    	
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}
