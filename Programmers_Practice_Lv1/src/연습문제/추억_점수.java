package 연습문제;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억_점수 {
	
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		
		int answer[] = new int[photo.length];
		int i=0;											// answer[i] 대입용
		
		Map<String, Integer> nameMap = new HashMap<String, Integer> ();
		for(int j=0; j<name.length; j++) nameMap.put(name[j], yearning[j]);
		
		System.out.println(nameMap);						// nameMap 확인용
		
		for(String[] names :photo) {
			System.out.println(Arrays.toString(names));		// names 확인용
			
			for(String str :names) {
				if(nameMap.containsKey(str)) {
					answer[i] += nameMap.get(str);
				}else answer[i] += 0;
			}
			
			i++;											// photo 순회할때마다 i 증가
		}

		return answer;
    }
}
