package 연습문제;

public class 이상한_문자_만들기 {
	public String solution(String s) {
		
		String answer ="";
		String[] sArr = s.split(" ", -1);
		
		for(String ele : sArr) {
			int evenOrOdd = 0;
			
			for(int i=0; i<ele.length(); i++) {
				if(evenOrOdd%2 ==0 ) answer += ele.toUpperCase().charAt(i);
				else answer += ele.toLowerCase().charAt(i);
				evenOrOdd++;
			}
			
			answer+= " ";
		}
		
		return answer.substring(0, answer.length()-1);
	}
}
