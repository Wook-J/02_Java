package kakao_blind_recruitment;

import java.util.Arrays;

public class 비밀지도 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String[] binArr = new String[n];
		
		for(int i=0; i<arr1.length; i++) {
			binArr[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
		}
		System.out.println(Arrays.toString(binArr));
		
		for(int i=0; i<arr1.length; i++) {
			String arr = "";
			if(binArr[i].length()<n) {
				for(int j=0; j<n-binArr[i].length(); j++) arr+= " ";
			}
			
			for(int k=0; k<binArr[i].length(); k++) {
				if(Arrays.asList(binArr[i].split("")).get(k).equals("1")) arr+= "#";
				else arr += " ";
			}
			
			answer[i] = arr;
		}
		
		return answer;
    }

}
