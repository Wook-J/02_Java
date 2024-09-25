package 연습문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 나누어_떨어지는_숫자_배열 {
	
    public int[] solution(int[] arr, int divisor) {
    	
    	List<Integer> list = new ArrayList<Integer>();
    	for(int ele : arr) {
    		if(ele % divisor==0) {
    			list.add(ele);
    		}
    	}
    	
    	if(list.size()==0) list.add(-1);
    	
    	Collections.sort(list);
    	
        int[] answer = new int[list.size()];
        

//        for(int i=0; i<answer.length; i++) {
//        	answer[i] = list.get(i);
//        	System.out.print(answer[i] + " ");
//        }
//        System.out.println("");
        
        return answer;
        
    }

}
