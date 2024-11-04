package kakao_blind_recruitment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 실패율 {
	public int[] solution(int N, int[] stages) {
		
		int[] answer = new int[N];

		Map<Integer, Double> failRateMap = new HashMap<Integer, Double>();
		
		for(int i=1; i<N+1; i++) {
			int stageCount = 0;
			int userTryStage = 0;
			
			for(int userStage : stages) {
				if(userStage >= i) stageCount++;		// 실패율 분모 세팅
				if(userStage == i) userTryStage++;		// 실패율 분자 세팅
			}
			failRateMap.put(i, (double)userTryStage/stageCount);
		}
		
		int answerIndex = 0;
		while(!failRateMap.isEmpty()) {
			System.out.println("failRateMap : " + failRateMap);		// failRateMap 확인용
			
			List<Double> failRateList = new ArrayList<Double>();
			for(Entry<Integer, Double> entry : failRateMap.entrySet()) {
				failRateList.add(entry.getValue());
			}
			System.out.println("failRateList : " + failRateList);	// failRateList 확인용
			
			double maxFailRate = failRateList.get(0);				// maxFailRate 세팅
			for(double failRate : failRateList) {
				if(maxFailRate<failRate) maxFailRate = failRate;
			}
			System.out.println("maxFailRate : " + maxFailRate);		// 변경된 maxFailRate 확인용
			
			for(Entry<Integer, Double> entry : failRateMap.entrySet()) {
				if(entry.getValue()==maxFailRate) {
					answer[answerIndex] = entry.getKey();
					failRateMap.remove(entry.getKey());
					answerIndex++;
					break;
				}
			}
			System.out.println(Arrays.toString(answer));
			System.out.println("-------------------------------");
		}
		
		return answer;
    }

}
