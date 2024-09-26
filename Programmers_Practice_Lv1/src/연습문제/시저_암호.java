package 연습문제;

public class 시저_암호 {
    public String solution(String s, int n) {
    	
//    	System.out.println("a의 int형 : " + (int)'a');
//    	System.out.println("z의 int형 : " + (int)'z');
//    	System.out.println((char) ('z' + 1));
//    	System.out.println(" 의 int형 : " + (int)' ');
//    	System.out.println("A의 int형 : " + (int)'A');
//    	System.out.println("Z의 int형 : " + (int)'Z');
//    	System.out.println((char) ('Z' + 1));
    	
    	String answer = "";
    	
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i)>=65 && s.charAt(i)<=90) {
    			char temp = (char) (s.charAt(i) + n);
    			if((int)temp > 90) temp -= 26;
    			answer += temp;
    			
    		} else if(s.charAt(i)>=97 && s.charAt(i)<=122) {
    			char temp = (char) (s.charAt(i) + n);
    			if((int)temp > 122) temp -= 26;
    			answer += temp;    			
    		} else answer += " ";
    	}
    	
    	return answer;
    }
}
