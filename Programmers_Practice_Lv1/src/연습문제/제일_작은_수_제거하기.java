package 연습문제;

import java.util.ArrayList;
import java.util.List;

public class 제일_작은_수_제거하기 {
	
    public int[] solution(int[] arr) {
    	
    	int minNum = arr[0];
    	for(int i=0; i<arr.length; i++) {
    		if(minNum > arr[i]) minNum = arr[i];
    	}
    	
    	List<Integer> intArr = new ArrayList<Integer>();
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i]==minNum) continue;
    		intArr.add(arr[i]);
    	}
    	
    	if(intArr.size()==0) intArr.add(-1);
    	
    	int[] answer = new int[intArr.size()];
    	for(int i=0; i<answer.length; i++) answer[i] = intArr.get(i);

    	return answer;
    }
}
