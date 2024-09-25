package 연습문제;

public class 두_정수_사이의_합 {
	
    public long solution(int a, int b) {
        long answer = 0;
        if(a <= b) {
        	for(int i = a; i<=b; i++) answer += i;        	
        }else {        	
        	for(int i = b; i<=a; i++) answer += i;        	
        }
        return answer;
    }

}
