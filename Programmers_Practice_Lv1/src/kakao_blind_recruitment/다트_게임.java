package kakao_blind_recruitment;

public class 다트_게임 {
	public int solution(String dartResult) {
		int result = 0;			// 최종 결과 점수
		int lastPoint = 0;		// 이전 라운드 점수
		int currentPoint = 0;	// 현재 라운드 점수

		for (int i = 0; i < dartResult.length(); i++) {			// dartResult 문자열을 하나씩 확인
			char c = dartResult.charAt(i);

			if (c == '1' && dartResult.charAt(i+1) == '0') {	// 10점인 경우
				result += lastPoint;		// 이전 라운드 점수 누적
				lastPoint = currentPoint;	// 현재 라운드 점수를 이전 라운드로 이동
				currentPoint = 10;			// 현재 라운드는 10점
				i++;						// '0'을 건너뛰기 위해 인덱스 증가
				continue;
			}
			
			if (c >= '0' && c <= '9') {		// 한 자리 숫자인 경우
				result += lastPoint; 		// 이전 라운드 점수 누적
				lastPoint = currentPoint;	// 현재 라운드 점수를 이전 라운드로 이동
				currentPoint = c - '0';		// 현재 라운드 점수 설정
				continue;
			}
            
			
			if (c == 'S') continue;			// S는 1제곱, 점수 변화 없음
			else if (c == 'D') {			// D는 2제곱
				currentPoint *= currentPoint; 
				continue;
			} else if (c == 'T') {			// T는 3제곱
				currentPoint *= currentPoint * currentPoint; 
				continue;
			}
			
			if (c == '*') {					// '*' 점수보정
				lastPoint *= 2;				// 이전 라운드 점수 2배
				currentPoint *= 2;			// 현재 라운드 점수 2배
			} else if (c == '#') {			// '#' 점수보정
				currentPoint *= -1;
			}
		}

		result += lastPoint + currentPoint;	// 점수보정된 경우 누적
		
		return result; 						// 최종 결과 반환

    }
}
