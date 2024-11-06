package 기타;

public class _3진법_뒤집기 {
	
	public int solution(int n) {
		int answer = 0;
		StringBuilder n3base = new StringBuilder("");
		
		do {
			int temp1 = n/3;
			int temp2 = n%3;
			n3base.insert(0, temp2);
			n = temp1;
			System.out.println("temp1 : " + temp1);
			
		}while(n!=0);
		
		System.out.println(n3base);
		for(int i=0 ; i<n3base.length(); i++) {
			answer += ((int) n3base.charAt(i)-48) * Math.pow(3, i);

		}

		return answer;
	}
	
	public int solution2(int n) {

		StringBuilder n3base = new StringBuilder("");
		do {
			int temp1 = n/3;
			int temp2 = n%3;
			n3base.append(temp2);
			n = temp1;
			System.out.println("temp1 : " + temp1);			
		}while(n!=0);
		
		return Integer.parseInt(n3base.toString(), 3);
	}

}
