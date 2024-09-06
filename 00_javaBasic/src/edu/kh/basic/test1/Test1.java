package edu.kh.basic.test1;				//  2~9 사이 정수를 입력될 떄 까지 무한 반복하다가, 2~9 사이 정수가 입력되면 해당하는 단의 구구단을 출력하고 종료하는 소스코드를 작성하였다.
										// 하지만 오류도 발생하고, 의도에 맞지 않게 동작하는 문제도 발생했다.
import java.util.Scanner;				// 문제와 소스코드를 분석하여 모든 문제 원인(문제점+문제 발생 원인), 조치내용(해결방법 + 수정된 코드)을 작성하시오.

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("2 ~ 9 사이 정수 입력 : ");
			
			int input = sc.nextInt();		//sc.next() -> sc.nextInt();
			
			if(input >= 2 && input<=9) {	//  input<=9 -> input >= 2 && input<=9
				for(int num=1; num<=9; num++) {
					System.out.printf("%d * %d = %d\n", input, num, input*num);			// 마지막 %d 에 결과값 대입해야함. + , input*num
				}
				break;			// 추가된 구문											// if 문 끝나고 while문 탈출 해야함
			}else {
				System.out.println("2이상 9이하의 정수만 입력해주세요.");
			}
		}
	}

}

/* 원인
 * 1. (9줄) while(조건식) 부분에서 조건식이 항상 true여서 그 반복문을 탈출하지 못하고 있어
 *          입력되는 숫자(2~9)의 단을 출력하더라도 프로그램이 종료되지 않는 문제가 발생함
 * 
 * 2. (12줄) int 형 타입인 input 에 String 타입을 입력받는 sc.next()를 대입하려 하여 오류가 남
 * 
 * 3. (14줄) 구구단을 출력하는 숫자(input)이 2이상 9이하여야 하는데 주어진 문제에서는 9이하의 정수만 입력받으면 구구단이 출력됨
 * 
 * 4. (16줄) printf 구문 괄호안에는 "입력하려는 형태"에 %d, %f 등이 있으면 그 개수만큼 뒤에 타입에 맞는 변수를 입력해야 하는데,
 * 			 문제에서는 input 단의 결과값 (input*num) 이 입력되어 있지 않아서 오류가 남
 *           즉 문제에서의 printf 구문에 %d(int형) 가 총 3개 있는데 뒤에 입력되는 변수는 2개뿐이어서 오류 발생
 *           
 * 
 * */

/* 조치 내용
 * 1. 2이상 9이하의 정수를 입력받는 경우에만 출력하고 프로그램 종료해야 하므로 if문 마지막에 탈출조건(break) 추가
 *	  추가된 코드(18줄) : break;
 *    
 * 2. sc.next() 대신에 int형 타입을 입력받는 sc.nextInt()로 코드 변경
 *    수정된 코드(12줄) : int input = sc.nextInt();
 *    
 * 3. 입력받는 input이 2이상 9이하일때 if조건문이 true가 되도록 코드 변경
 *    이 때 input이 2이상이면서 9이하 이어야 하므로 &&조건 추가
 *    수정된 코드(14줄) : if(input >= 2 && input<=9) {
 * 
 * 4. 입력하려는 형태에 들어있는 %d(총 3개)에 대응되는 변수결과 값이 포함되도록 코드 변경
 *    수정된 코드(16줄) : System.out.printf("%d * %d = %d\n", input, num, input*num);
 * 
 * 
 * */
