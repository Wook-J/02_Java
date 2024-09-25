package 연습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 문자열_내_마음대로_정렬하기 {
    public String[] solution(String[] strings, int n) {
    	
    	String[] answer = new String[strings.length];
    	
    	List<String> list = new ArrayList<String>();
    	for(String string : strings) {
    		list.add(string.charAt(n) + string);
    	}
    	
    	Collections.sort(list);
//    	System.out.println(list);
    	
    	for(int i=0; i<answer.length; i++) {
    		answer[i] = list.get(i).substring(1);
    	}
    	
    	for(String string : answer) {
    		System.out.print(string + " ");
    	}
    	System.out.println();
    	
    	return answer;
    }
    
    public String[] solution2(String[] strings, int n) {
    	
    	
    	Comparator<String> nComparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.charAt(n) == o2.charAt(n)) return o1.compareTo(o2);
				else return o1.charAt(n) - o2.charAt(n);
			}
		};
		
		Arrays.sort(strings, nComparator);
		
		for(String string : strings) {
			System.out.print(string + " ");
		}
		System.out.println();
		
    	return strings;
    }
}
