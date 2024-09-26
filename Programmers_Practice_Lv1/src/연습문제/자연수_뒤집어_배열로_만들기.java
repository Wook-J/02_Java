package 연습문제;

public class 자연수_뒤집어_배열로_만들기 {
	
	public int[] solution(long n) {
		
		String[] strArr = String.valueOf(n).split("");
		int[] answer = new int[strArr.length];
		
		for(int i=0; i<answer.length; i++) answer[i] = Integer.parseInt(strArr[strArr.length-i-1]);
		
		return answer;
    }

}
