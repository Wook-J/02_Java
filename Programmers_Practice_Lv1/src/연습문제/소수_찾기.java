package 연습문제;

public class 소수_찾기 {
	public int solution(int n) {
		int answer = 0;
		
		for(int i=2; i<=n; i++) {
			
			boolean flag = true;
			
			for(int j=2; j<=(int) Math.sqrt(i); j++) {
				if(i%j==0) {
					flag = false;
					break;
				}
			}
			
			if(flag) answer++;
		}
		
		return answer;
	}
}
