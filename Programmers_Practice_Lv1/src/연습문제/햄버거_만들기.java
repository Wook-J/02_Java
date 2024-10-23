package 연습문제;

import java.util.ArrayList;
import java.util.List;

public class 햄버거_만들기 {
	public int solution(int[] ingredient) {
		
		int answer = 0;

		List<Integer> ingredList = new ArrayList<Integer>();
		for(int ele : ingredient) ingredList.add(ele);
		System.out.println(ingredList);
		
		int bbangIndex;
		boolean flag;
		
		do {
			bbangIndex = ingredList.indexOf(1);
			flag = true;
			
			for(int i=bbangIndex; i<ingredList.size()-3; i++) {
				if((ingredList.get(i+1)==2) && (ingredList.get(i+2)==3) && (ingredList.get(i+3)==1)) {
					answer++;
					flag = false;
					for(int j=0; j<4; j++) ingredList.remove(i);
					System.out.println(ingredList);
					break;
				}
			}
			
			if(flag) break;
			
		}while(bbangIndex != -1);
		
		return answer;
		/*	[2, 1, (1), (2), (3), (1), 2, 3, 1]
		 *  [2, (1), (2), (3), (1)]
		 *  [2]
		 * */
    }

}
