package 연습문제;

public class X만큼_간격이_있는_n개의_숫자 {
	
	public long[] solution(int x, int n) {
		long[] answer = new long[n];
		for(int i=0; i<n ; i++) answer[i] = (long)(i+1)*x;
		return answer;
    }

}
