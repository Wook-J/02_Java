package 연습문제;

public class 콜라츠_추측 {

	public int solution(long num) {
		int idx = 0;
		
		if (num==1) return 0;
		
		do {			
			if(idx == 500) {
				idx = -1;
				break;
			} 
			
			if(num%2 ==0) num = num/2;
			else num = 3*num + 1;
			idx++;
			
		}while(num != 1);
		
		return idx;
    }
}
