package kakao_blind_recruitment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 개인정보_수집_유효기간 {
	public int[] solution(String today, String[] terms, String[] privacies) {
		String[] todayArr = new String[3];
		todayArr[0] = today.substring(0, 4);
		todayArr[1] = today.substring(5, 7);
		todayArr[2] = today.substring(8);
		
		System.out.println("오늘 날짜 : " + Arrays.toString(todayArr));
		System.out.println("약관 유효기간 : " + Arrays.toString(terms));
		System.out.println("privacies : " + Arrays.toString(privacies));
		
		Map<String, String> termPeriodMap = new HashMap<String, String>();
		for(String str : terms) {
			List<String> termPeriodList = Arrays.asList(str.split(" "));
			termPeriodMap.put(termPeriodList.get(0), termPeriodList.get(1));
		}		
		System.out.println("termPeriodMap : " + termPeriodMap);
		System.out.println("----------------------------------------------------------");
		
		Map<Integer, String[]> privaciesMap = new HashMap<Integer, String[]>();
		int i=1;
		for(String privacy : privacies) {
			String[] yearMonthArr = {privacy.substring(0, 4), privacy.substring(5, 7),
									privacy.substring(8, 10), termPeriodMap.get(privacy.substring(11))};
			privaciesMap.put(i++, yearMonthArr);
		}
		
		// 값 확인용
		for(Entry<Integer, String[]> entry : privaciesMap.entrySet()) {
			System.out.println("key = " + entry.getKey() + " / " + Arrays.toString(entry.getValue()));
		}
		
		for(Entry<Integer, String[]> entry : privaciesMap.entrySet()) {
			int year = Integer.parseInt(entry.getValue()[0]);
			int month = Integer.parseInt(entry.getValue()[1]);
			int term = Integer.parseInt(entry.getValue()[3]);
			
			year += (month+term)/12;
			month = (month+term)%12;
			
			if(month==0) {
				year--;
				month = 12;
			}
			System.out.println("year : " + year + " / month : " + month);
			
			String[] newTerm = new String[4];
			newTerm[0] = ""+year;
			newTerm[1] = month<10 ? "0"+month : ""+month;
			newTerm[2] = entry.getValue()[2];
			newTerm[3] = entry.getValue()[3];
			entry.setValue(newTerm);
		}
		
		// 값 확인용
		for(Entry<Integer, String[]> entry : privaciesMap.entrySet()) {
			System.out.println("key = " + entry.getKey() + " / " + Arrays.toString(entry.getValue()));
		}
		
		System.out.println("오늘 날짜 : " + Arrays.toString(todayArr));
		
		List<Integer> answerList = new ArrayList<Integer>();
		
		for(Entry<Integer, String[]> entry : privaciesMap.entrySet()) {
			// 오늘 날짜보다 수정된 날짜가 빠르면 파기하기
			int priYear = Integer.parseInt(entry.getValue()[0]);
			int priMonth = Integer.parseInt(entry.getValue()[1]);
			int priDay = Integer.parseInt(entry.getValue()[2]);
			
			int todayYear = Integer.parseInt(todayArr[0]);
			int todayMonth = Integer.parseInt(todayArr[1]);
			int todayDay = Integer.parseInt(todayArr[2]);
			
			if(priYear<todayYear) answerList.add(entry.getKey());
			else if(priYear==todayYear) {
				
				if(priMonth<todayMonth) answerList.add(entry.getKey());
				else if(priMonth==todayMonth) {
					
					if(priDay<=todayDay) answerList.add(entry.getKey());
				}
			}
		}
		
		System.out.println("answerList : " + answerList);
		
		int[] answer = new int[answerList.size()];
		for(int j=0; j<answer.length; j++) {
			answer[j] = answerList.get(j);
		}

		return answer;
    }

}
