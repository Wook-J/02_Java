package 연습문제;

public class 평균_구하기 {
	public double solution(int[] arr) {
		int sum = 0;
		for(Integer ele : arr) {
			sum += ele;
		}

		return sum/(double)arr.length;
    }
}
