package kakao_blind_recruitment;

import java.util.Arrays;

public class Run {

	public static void main(String[] args) {
		신고_결과_받기 prob2 = new 신고_결과_받기();
		
		String[] idList = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
//		String[] idList = {"con", "ryan"};
//		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//		int k = 3;
		System.out.println(Arrays.toString(prob2.solution(idList, report, k)));
		
//		개인정보_수집_유효기간 prob1 = new 개인정보_수집_유효기간();
//		String today = "2022.05.19";
//		String[] terms = {"A 6", "B 12", "C 3"};
//		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
//		System.out.println(Arrays.toString(prob1.solution(today, terms, privacies)));
//		String today2 = "2020.12.28";
//		String[] terms2 = {"A 12", "B 1"};
//		String[] privacies2 = {"2019.01.01 A", "2020.11.28 B"};
//		System.out.println(Arrays.toString(prob1.solution(today2, terms2, privacies2)));

	}

}
