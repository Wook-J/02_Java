package 연습문제;

public class 가장_가까운_같은_글자 {
	
	public int[] solution(String s) {
		int[] answer = new int [s.length()];
		
		for(int i=0; i<s.length(); i++) {
			int newIndex = s.substring(0, i).lastIndexOf(s.split("")[i]);
			
			if(newIndex == -1) answer[i] = newIndex;
			else answer[i] = i - newIndex;
		}
		
		return answer;
    }
}
