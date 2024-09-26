package 연습문제;

public class 정수_제곱근_판별 {
	
	public long solution(long n) {
		if(Math.sqrt(n) == Math.floor(Math.sqrt(n)) ) return (long)((Math.sqrt(n)+1) *(Math.sqrt(n)+1));
		else return -1L;
    }
	
	public long solution2(long n) {
		if (Math.pow((int)Math.sqrt(n), 2) == n) {
			return (long) Math.pow(Math.sqrt(n) + 1, 2);
		} else return -1;
	}
}
