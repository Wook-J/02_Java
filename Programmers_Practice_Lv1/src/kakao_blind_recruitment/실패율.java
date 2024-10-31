package kakao_blind_recruitment;

public class 실패율 {
	public int[] solution(int N, int[] stages) {
		// answer 에 stage 개수만큼의 배열 생성
		int[] answer = new int[N];
		
		// 1stage부터 시작
		for(int i=0; i<N; i++) {
			// i stage 에 도달한 사람 수 카운트하기
			int stageCount = i;
			for(int userTryStage :stages) {
				if(userTryStage > stageCount) stageCount++;
			}
			
			for(int userTryStage :stages) {
				if(userTryStage<=(i+1)) answer[i]++;
			}
			answer[i] /= stageCount;
		}
		return answer;
    }

}
