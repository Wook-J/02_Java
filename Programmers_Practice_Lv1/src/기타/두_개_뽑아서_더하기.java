package 기타;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 두_개_뽑아서_더하기 {
	
	public int[] solution(int[] numbers) {
//		System.out.println(Arrays.toString(numbers));
		Set<Integer> numberSet = new HashSet<>();
		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				int temp = numbers[i] + numbers[j];
				numberSet.add(temp);
			}
		}
		
		int[] answer = new int[numberSet.size()];
		int i = 0;
		for(int twoNumSum : numberSet) {
			answer[i] = twoNumSum;
			i++;
		}
		Arrays.sort(answer);
		return answer;
	}

}
