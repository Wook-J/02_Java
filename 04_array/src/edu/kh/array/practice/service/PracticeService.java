package edu.kh.array.practice.service;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {		// 짝수 번째 인덱스 합 출력
		
		int[] arr = new int[9];
		int sum =0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i]+" ");
			if(i%2==0) sum += arr[i];
		}
		System.out.printf("\n짝수 번째 인덱스 합 : %d\n", sum);
	}
	
	public void practice2() {		// 홀수 번째 인덱스 합 출력
		int[] arr = new int[9];
		int sum =0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = 9-i;
			System.out.print(arr[i]+" ");
			if(i%2==1) sum += arr[i];
		}
		System.out.printf("\n홀수 번째 인덱스 합 : %d\n", sum);
	}
	
	public void practice3() {		// 1부터 입력받은 값까지 배열에 초기화한 후 출력
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public void practice4() {		// 배열에 일치하는 수 찾기
		
		int[] arr = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int input = sc.nextInt();
		
		int index = -1;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == input) {
				index = i;
				break;
			}
		}
		
		if(index !=-1) System.out.println("인덱스 : "+ index);
		else System.out.println("일치하는 값이 존재하지 않습니다.");
	}
	
	public void practice5() {		// 문자열 및 문자 입력하여 위치 및 개수 출력
		
		System.out.print("문자열 : ");
		String input = sc.nextLine();
		char[] arr = new char[input.length()];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = input.charAt(i);
		}
		
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		String result = "";
		int count =0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == ch) {
				result += i+" ";
				count++;
			}
		}
		
		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : %s\n", input, ch, result);
		System.out.printf("%c 개수 : %d", ch, count);
	}
	
	public void practice6() {		// 배열크기 입력받아 요소 초기화 및 총합 출력
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
		}
		
		System.out.println(Arrays.toString(arr));
		
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		
		System.out.println("총 합 : " + sum);
	}
	
	public void practice7() {		// 주민등록번호 입력받아 뒷자리 첫 숫자빼고 * 출력
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.nextLine();
		char[] arr = new char[input.length()];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = input.charAt(i);
			if(i>=8) arr[i] = '*';
			System.out.print(arr[i]);
		}
	}
	
	public void practice8() {		// 3 이상 홀수 입력받아 중간까지 오름차순 이후 내림차순 출력
		while(true) {
			System.out.print("정수 : ");
			int input = sc.nextInt();
			if(input %2 ==0 || input<3) {
				System.out.println("다시 입력하세요.");
				continue;
			}
			else {
				int count = 0;
				for(int i=1; i <= (input+1)/2; i++) {
					count++;
					System.out.print(count +", ");
				}
				for(int i=(input+1)/2+1; i<=input; i++) {
					count--;
					System.out.print(count);
					if(i != input) System.out.print(", ");
				}
				break;
			}
		}
	}
	
	public void practice9() {		// 1 ~ 10 사이 난수 10개 발생시켜 정수형 배열에 초기화 및 출력
		
		int[] arr = new int[10];
		System.out.print("발생한 난수 : ");
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int) (Math.random()*10 +1);
			System.out.print(arr[i]+" ");
		}
	}
	
	public void practice10() {		// 1 ~ 10 사이 난수 10개 발생시켜 모든 수, 최대값 및 최소값 출력
		
		int[] arr = new int[10];
		System.out.print("발생한 난수 : ");
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int) (Math.random()*10 +1);
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		int max = arr[0];
		int min = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i]) max = arr[i];
			if(min>arr[i]) min = arr[i];
		}
		
		System.out.println("최대값 : "+ max);
		System.out.println("최소값 : "+ min);
	}
	
	public void practice11() {		// 1 ~ 10 사이 난수 10개 발생시켜 중복 없이 정수값 출력
		
		int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int) (Math.random()*10+1);
			for(int x=0; x<i; x++) {
				if(arr[i]==arr[x]) {
					i--;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public void practice12() {		// 로또 번호 자동 생성기
		
		int[] arr = new int[6];
		
		for(int i=0; i< arr.length; i++) {
			arr[i] = (int)(Math.random()*45+1);		
			for(int x=0; x<i; x++) {
				if(arr[x] == arr[i]) {
					i--;
					break;
				}
			}
		}
		
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] + " ");
	}
	
	public void practice13() {
		System.out.printf("문자열 : ");
		String str = sc.nextLine();
		
		char[] arrChar = new char[str.length()];
		boolean[] arrBoolean = new boolean[str.length()];
		
		for(int i=0; i<arrChar.length; i++) arrChar[i] = str.charAt(i);
		for(int i=0; i<arrBoolean.length; i++) arrBoolean[i] = true;
		
		int countFalse = 0;
		int countTure = 0;
		
		for(int i=1; i<arrChar.length; i++) {
			for(int j=0; j<i; j++) {
				if(arrChar[j] == arrChar[i]) arrBoolean[i]= false;
			}
		}
		for(int i=0; i<arrBoolean.length; i++) {
			if(arrBoolean[i]) countTure++;
			else countFalse++;
		}
		
		System.out.println(countTure);
		System.out.println(countFalse);
		System.out.println(Arrays.toString(arrBoolean));
		
		System.out.print("문자열에 있는 문자 : ");
		for(int i=0; i<arrChar.length; i++) {
			
			if(arrBoolean[i]) {
				System.out.print(arrChar[i]);
			}
			if(arrBoolean[i] && i< arrChar.length-1) System.out.print(", ");
		}
		
		System.out.println("\n문자 개수 : "+countTure);
	}

	public void practice14() {
		/*
		 * 사용자가입력한배열의길이만큼의문자열배열을선언및할당하고
배열의인덱스에넣을값역시사용자가입력하여초기화하세요.
단, 사용자에게배열에값을더넣을지물어보고몇개를더입력할건지,
늘린곳에어떤데이터를넣을것인지받으세요.
사용자가더이상입력하지않겠다고하면배열전체값을출력하세요.
		 * 
		 *  [실행화면]
배열의크기를입력하세요: 3
 1번째문자열: 자바의정석
2번째문자열: 알고리즘
3번째문자열: C프로그래밍
더값을입력하시겠습니까?(Y/N) : y
더입력하고싶은개수: 2
 4번째문자열: 인간관계
5번째문자열: 자기계발
더값을입력하시겠습니까?(Y/N) : y
더입력하고싶은개수: 1
 6번째문자열: 영단어600
더값을입력하시겠습니까?(Y/N) : n
 [자바의정석, 알고리즘, C프로그래밍, 인간관계, 자기계발, 영단어600]
		 * */
		System.out.print("배열의 크기를 입력하세요 : ");
		int input = sc.nextInt();
		
		String[] arrInput = new String[input];
		
		for(int i=0; i<arrInput.length; i++) {
			System.out.printf("%d번째 문자열 : ", i+1);
			sc.nextLine();
			arrInput[i] = sc.nextLine();
		}
		
		while(true) {
			System.out.print("더 값을 입력하시겠습니까?(Y/N)");
			String YesOrNo = sc.next();
			String[] arrNew;
			
			if(YesOrNo.equals("Y") || YesOrNo.equals("y")) {
				
			} else if (YesOrNo.equals("N") || YesOrNo.equals("n")) {
				
			}
			
			if(YesOrNo.equals("n")) break;
			else if(YesOrNo.equals("y")){
				System.out.print("더 입력하고 싶은 개수 : ");
				int addNum = sc.nextInt();
				
				input += addNum;
				String[] arrNew = new String[input];
				
				for(int i=0; i<input-addNum; i++) arrNew[i] = arrInput[i];
				for(int i= input-addNum; i<input; i++) {
					System.out.printf("%d번째 문자열 : ", i+1);
					arrNew[i] = sc.nextLine();
				}
				System.out.println(Arrays.toString(arrNew));
			}
		}

	}
}
