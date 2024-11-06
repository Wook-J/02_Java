package 기타;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class K번째수 {
	
	public int[] solution(int[] array, int[][] commands) {
		
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.deepToString(commands));
		System.out.println("-------------------------------------------------------");
		
		System.out.println("commands[0] : " + Arrays.toString(commands[0]));
		System.out.println("commands[0][0] : " + commands[0][0]);
		System.out.println("commands[0][1] : " + commands[0][1]);
		
		List<Integer> list = new ArrayList<>();
		for(int i=commands[0][0]-1; i<commands[0][1]; i++) {
			list.add(array[i]);
		}
		Collections.sort(list);
		System.out.println(list);
		System.out.println(list.get(commands[0][2]-1));
		System.out.println("commands.length : " + commands.length); // 1차원 행렬 길이만
		
		System.out.println("-------------------------------------------------------");
		int[] answer = new int[commands.length];
		for(int i=0; i<commands.length; i++) {
			List<Integer> listTest = new ArrayList<>();
			for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
				listTest.add(array[j]);
			}
			Collections.sort(listTest);
			System.out.println("추출된 값 : " + listTest.get(commands[i][2]-1));
			answer[i] = listTest.get(commands[i][2]-1);
		}
		return answer;
    }

}
