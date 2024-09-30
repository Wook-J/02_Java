package 연습문제;

import java.util.Arrays;

public class 기사단원의_무기 {

	public int solution(int number, int limit, int power) {
		System.out.println("number : " + number + ", limit : " + limit + ", power : " + power);		// 들어온 매개변수 확인용
		int[] numArr = new int[number];
		
		for(int i=1; i<=number; i++) numArr[i-1] = numDivisor(i);			// 약수개수 대입 메서드
		System.out.println("기존 : "+Arrays.toString(numArr));				// 기존 약수 확인용
		
		for(int i=0; i<number; i++) {
			if(numArr[i]>limit) numArr[i] = power;
		}
		
		System.out.println("갱신 : " + Arrays.toString(numArr));			// limit power 적용 확인용
		int answer = 0;
		for(int num : numArr) answer +=num;
		return answer;
    }
	
	// 약수의 개수 구하는 메서드
	public int numDivisor(int number) {
		int numberOfDivision=1;

		for(int i=2; i<=(int)Math.sqrt(number); i++) {
			if(number%i==0) numberOfDivision++;

		}
		if(Math.sqrt(number)%1 !=0) numberOfDivision *= 2;
		else numberOfDivision = 2*(numberOfDivision-1)+1;

		System.out.println(number +"의 약수 개수 : "+numberOfDivision);		// 약수 개수 확인용
		return numberOfDivision;
	}
}
