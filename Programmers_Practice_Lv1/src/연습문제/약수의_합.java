package 연습문제;

import java.util.ArrayList;
import java.util.List;

public class 약수의_합 {
    public int solution(int n) {
    	
    	List<Integer> divisorList = new ArrayList<Integer>();	// 약수 모을필요도 없었군....
    	int answer = 0;
    	
    	for(int i=1; i<=n; i++) {
    		if(n%i==0) divisorList.add(i);
    	}
    	for(Integer divisor : divisorList) answer += divisor;
    	return answer;
    }
    
    public int solution2(int n) {
    	int answer = 0;
    	for(int i=1; i<=n; i++) {
    		if(n%i==0) answer += i;
    	}
    	return answer;
    }
}
