package 연습문제;

public class 최대공약수와_최소공배수 {
	public int[] solution(int n, int m) {
		
		int gcd=1;		// 최대공약수
		int lcm=1;		// 최소공배수
		
		for(int i=1; i<=Math.min(n, m); i++) {
			if((n%i == 0) && (m%i == 0)) gcd = i;
		}
		lcm = n*m/gcd;
		
		return new int[] {gcd, lcm};
	}
}
