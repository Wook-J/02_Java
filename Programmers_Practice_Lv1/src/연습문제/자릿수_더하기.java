package 연습문제;

public class 자릿수_더하기 {
	public int solution(int n) {
		int answer = 0;
		
//		do {
//			answer += n%10;
//			n /= 10;
//		}while(n>=1);
		
		for(; n>=1; ) {
			answer += n%10;
			n /= 10;
		}
		return answer;
	}
}
