package 연습문제;

public class 문자열_나누기 {
	public int solution(String s) {
		
		int answer = 0;

        int[] countArr = new int[2];	// target의 개수, 다른 문자 개수
        char target = s.charAt(0);		// 초기 target
        
        for (int i = 0; i < s.length(); i++) {
            if (target == s.charAt(i)) countArr[0]++;	// target 문자와 일치하는 경우
            else countArr[1]++;							// target 문자와 일치하지 않는 경우

            if (countArr[0] == countArr[1]) {			// target 문자 개수와 다른 문자의 개수가 같은경우
            	answer++;
            	countArr = new int[2];					// 카운트 배열 초기화
            	target = s.charAt((i+1) % s.length());	// 다음 target 문자 설정(%는 마지막 index에서 예외 처리용)
            }
        }

        if (countArr[0] != countArr[1]) answer++;		// 마지막 문자열 처리
        
        return answer;

    }
}
