package 연습문제;

public class 문자열_내_p와_y의_개수 {

    boolean solution(String s) {

        int numOfP = 0;
        int numOfY = 0;
        
        for(int i=0; i<s.length(); i++) {
        	if(s.toLowerCase().charAt(i)=='p') numOfP ++;
        	if(s.toLowerCase().charAt(i)=='y') numOfY ++;
        }
        
        return numOfP==numOfY ? true : false;
    }
}
