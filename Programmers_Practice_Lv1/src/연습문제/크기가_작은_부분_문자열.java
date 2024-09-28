package 연습문제;

import java.util.ArrayList;
import java.util.List;

public class 크기가_작은_부분_문자열 {
	
    public int solution(String t, String p) {
    	int answer = 0;
    	for(int i=0; i<=t.length()-p.length(); i++) {
    		long tValue = Long.parseLong(t.substring(i, i+p.length()));
    		long pValue = Long.parseLong(p);
    		if(tValue<= pValue) answer++;
        }
        return answer;
    }
	
	/** 런타임 에러 -> Long 타입으로 변형하여 해결 완료!
	 * @param t
	 * @param p
	 * @return
	 */
	public int solution2(String t, String p) {
		System.out.println("t : " + t + ", p : " + p);		// 들어온 전달인자 확인용
		int answer = 0;
		
		// tListByP 생성 및 값 추가
		List<Long> tListByP = new ArrayList<Long>();
		for(int i=0; i<=t.length()-p.length(); i++) {
			tListByP.add(Long.parseLong(t.substring(i, i+p.length())));
		}
		System.out.println(tListByP);						// tListByP 확인용
		
		// answer 구하기
		for(long tVersusP : tListByP) {
			if(tVersusP <= Long.parseLong(p)) answer++;
		}
		
		return answer;
    }

}
