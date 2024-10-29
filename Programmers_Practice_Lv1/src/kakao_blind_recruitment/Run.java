package kakao_blind_recruitment;

import java.util.Arrays;

public class Run {

	public static void main(String[] args) {
		개인정보_수집_유효기간 prob1 = new 개인정보_수집_유효기간();
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		System.out.println(Arrays.toString(prob1.solution(today, terms, privacies)));

	}

}
