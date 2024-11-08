package 기타;

import java.util.Arrays;

public class 모의고사 {

	public int[] solution(int[] answers) {
		boolean[] ansArr = new boolean[3];
		
		int[] person1 = new int[answers.length];
		int person1Answer = 0;
		for(int i=0; i<person1.length; i++) {
			if(i%5==0) person1[i] = 1;
			else if (i%5==1) person1[i] = 2;
			else if (i%5==2) person1[i] = 3;
			else if (i%5==3) person1[i] = 4;
			else person1[i] = 5;
		}
		
		int[] person2 = new int[answers.length];
		int person2Answer = 0;
		for(int i=0; i<person2.length; i++) {
			if(i%2==0) person2[i] = 2;
			else if(i%8==1) person2[i] = 1;
			else if(i%8==3) person2[i] = 3;
			else if(i%8==5) person2[i] = 4;
			else person2[i] = 5;
		}
		
		int[] person3 = new int[answers.length];
		int person3Answer = 0;
		for(int i=0; i<person3.length; i++) {
			if(i%10==0 || i%10==1) person3[i] = 3;
			else if (i%10==2 || i%10==3) person3[i] = 1;
			else if (i%10==4 || i%10==5) person3[i] = 2;
			else if (i%10==6 || i%10==7) person3[i] = 4;
			else  person3[i] = 5;
		}
		
		for(int i=0; i<answers.length; i++) {
			if(person1[i]==answers[i]) person1Answer++;
			if(person2[i]==answers[i]) person2Answer++;
			if(person3[i]==answers[i]) person3Answer++;
		}
		
		System.out.println("person1 정답 개수 : " + person1Answer);
		System.out.println("person2 정답 개수 : " + person2Answer);
		System.out.println("person3 정답 개수 : " + person3Answer);
		
		int[] answer = {};
		return answer;
	}
	
}
