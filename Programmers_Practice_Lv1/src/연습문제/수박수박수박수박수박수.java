package 연습문제;

public class 수박수박수박수박수박수 {
	
    public String solution(int n) {
    	String answer = "";
    	
    	if(n%2==0) for(int i=0; i<n/2; i++) answer += "수박";
    	else {
    		for(int i=0; i<n/2; i++) answer += "수박";
    		answer += "수";
    	}
        return answer;
    }
    
    public String solution2(int n) {
    	
    	StringBuffer sb = new StringBuffer();
    	for(int i=1; i<=n; i++) sb.append(i%2==0 ? "박" : "수");

        return sb.toString();
    }
}
