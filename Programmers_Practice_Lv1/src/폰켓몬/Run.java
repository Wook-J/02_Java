package 폰켓몬;

public class Run {

	public static void main(String[] args) {
		
		Solution practice = new Solution();
		
		int[] num1 = new int[] {3, 1, 2, 3};
		int[] num2 = new int[] {3, 3, 3, 2, 2, 4};
		int[] num3 = new int[] {3, 3, 3, 2, 2, 2};
		
		System.out.println(practice.solution(num1));
		System.out.println(practice.solution(num2));
		System.out.println(practice.solution(num3));

	}

}
