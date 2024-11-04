package 기타;

import java.util.ArrayList;
import java.util.List;

public class 소수_만들기 {
	public int solution(int[] nums) {
//		System.out.println(Arrays.toString(nums));
		List<Integer> numList = new ArrayList<>();
        int answer = 0;
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				for(int k=j+1; k<nums.length; k++) {
					int numSum = nums[i]+nums[j]+nums[k];
					if(numSum%2 !=0) numList.add(numSum);	// 짝수는 우선 제외
				}
			}
		}

//		System.out.println("numSet : " + numSet);
		for(Integer num : numList) {
			
			boolean flag = true;			// 소수 선별용 플래그
			
			for(int i=3; i<=(int)Math.sqrt(num); i++) {
				if(num%i==0) {				// num 전까지 하나라도 나누어떨어지면 제외
					flag= false;
					break;
				}
			}
			
			if(flag) answer++;				// 소수일때만 answer++
		}

        return answer;
    }
}
