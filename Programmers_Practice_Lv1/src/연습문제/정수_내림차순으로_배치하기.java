package 연습문제;

import java.util.Arrays;

public class 정수_내림차순으로_배치하기 {
	
	public long solution(long n) {
		
		String[] strArr = String.valueOf(n).split("");
		int[] intArr = new int[strArr.length];
		for(int i=0; i<intArr.length; i++) intArr[i] = Integer.parseInt(strArr[i]);
		
		Arrays.sort(intArr);
		
		String strAns = "";
		for(int i=intArr.length-1; i>=0; i--) {
			strAns += intArr[i];
		}
		
		return Long.parseLong(strAns);
    }
	
	public long solution2(long n) {
		String[] list = String.valueOf(n).split("");
		Arrays.sort(list);

		StringBuilder sb = new StringBuilder();
		for (String str : list) sb.append(str);

		return Long.parseLong(sb.reverse().toString());
  }
}
