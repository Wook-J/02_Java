package kakao_blind_recruitment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 개인정보_수집_유효기간 {
	public int[] solution(String today, String[] terms, String[] privacies) {
		System.out.println("오늘 날짜 : " + today);
		System.out.println("약관 유효기간 : " + Arrays.toString(terms));
		System.out.println("privacies : " + Arrays.toString(privacies));
		
		Map<String, Integer> termPeriodMap = new HashMap<String, Integer>();
		for(String str : terms) {
			List<String> termPeriodList = Arrays.asList(str.split(" "));
			termPeriodMap.put(termPeriodList.get(0), Integer.parseInt(termPeriodList.get(1)));
		}		
		System.out.println("termPeriodMap : " + termPeriodMap);
		
		Map<String, String> privaciesMap = new HashMap<String, String>();
		for(String privacy : privacies) {
			privaciesMap.put(privacy.substring(0, 10), privacy.substring(11));
		}		
		System.out.println("privaciesMap : " + privaciesMap);
		

		for(Entry<String, String> entry : privaciesMap.entrySet()) {
			System.out.println("유효기간 : " + termPeriodMap.get(entry.getValue()));
		}
		
		Map<String, String> privUpdateMap = new HashMap<String, String>();
		

		// terms의 요소들을 쪼개서 Map<String, int> 으로 대입
		// privacies의 month에 term의 String에 대응하는 int 값을 더하기
		// -> 기본값 String 형이어서 int형으로 바꾼다음에 더하기
		// -> 12로 나눠서 몫은 연도에, 나머지는 월에 다시 String으로 대입하기
		
		int[] answer = {};
		return answer;
    }

}
