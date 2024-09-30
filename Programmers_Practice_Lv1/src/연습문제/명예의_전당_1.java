package 연습문제;

import java.util.Arrays;

public class 명예의_전당_1 {

	public int[] solution(int k, int[] score) {
		System.out.println("k : " + k + ", score : " + Arrays.toString(score));		// 대입인자 확인용
		int[] answer = new int[score.length];
		
		for(int i=0; i<score.length; i++) {
			int[] numArr = new int[i+1];		// i=0 원소1개짜리, i=1 원소2개짜리, ..., i=6 원소 7개짜리
			for(int j=0; j<i+1; j++) numArr[j] = score[j];
			Arrays.sort(numArr);
			System.out.println(Arrays.toString(numArr));		// 배열 확인용
			
			if(i<k) answer[i] = numArr[0];
			else answer[i] = numArr[numArr.length-k];

		}
		
		return answer;
	}
}
