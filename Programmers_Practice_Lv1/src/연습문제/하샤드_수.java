package 연습문제;

public class 하샤드_수 {
	
	public boolean solution(int x) {
		
		int xSum=0;
		int temp = x;
		
		while(temp>0) {
			xSum += temp%10;
			temp /= 10;
		}
		
		return x%xSum==0 ? true : false;
    }
	
	public boolean solution2(int x) {
		
		String temp[] = String.valueOf(x).split("");
		int xSum =0;
		
		for(String str:temp) xSum += Integer.parseInt(str);
		
		return x%xSum==0 ? true : false;
	}
}
