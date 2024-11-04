package kakao_blind_recruitment;

import java.util.Arrays;

public class Run {

	public static void main(String[] args) {
		
		비밀지도 prob6 = new 비밀지도();
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		System.out.println(Arrays.toString(prob6.solution(n, arr1, arr2)));
		int n2 = 6;
		int[] arr12 = {46, 33, 33 ,22, 31, 50};
		int[] arr22 = {27 ,56, 19, 14, 14, 10};
		System.out.println(Arrays.toString(prob6.solution(n2, arr12, arr22)));
		
//		다트_게임 prob5 = new 다트_게임();
//		String dartResult = "1S2D*3T";
//		System.out.println(prob5.solution(dartResult));
		
//		실패율 prob4 = new 실패율();
//		int N = 5;
//		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//		System.out.println(Arrays.toString(prob4.solution(N, stages)));
//		int N2 = 4;
//		int[] stages2 = {4, 4, 4, 4};
//		System.out.println(Arrays.toString(prob4.solution(N2, stages2)));
		
//		신규_아이디_추천 prob3 = new 신규_아이디_추천();
//		String new_id ="...!@BaT#*..y.abcdefghijklm";
//		System.out.println(prob3.solution(new_id));
		
//		신고_결과_받기 prob2 = new 신고_결과_받기();
//		String[] idList = {"muzi", "frodo", "apeach", "neo"};
//		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//		int k = 2;
//		System.out.println(Arrays.toString(prob2.solution(idList, report, k)));
//		String[] idList2 = {"con", "ryan"};
//		String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
//		int k2 = 3;
//		System.out.println(Arrays.toString(prob2.solution(idList2, report2, k2)));
		
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
