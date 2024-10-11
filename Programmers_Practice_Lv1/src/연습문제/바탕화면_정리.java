package 연습문제;

import java.util.Arrays;

public class 바탕화면_정리 {
	public int[] solution(String[] wallpaper) {
		System.out.println(Arrays.toString(wallpaper));		// 매개변수 확인용
		int min_col = wallpaper[0].length();
		int min_row = wallpaper.length;
		int max_col = 0;
		int max_row = 0;
		
		for(int i=0; i<wallpaper.length; i++) {
			if(wallpaper[i].contains("#")) {
				if(min_row > i) min_row = i;
				if(max_row < i) max_row = i;
			}
			if(min_col > wallpaper[i].indexOf("#") && wallpaper[i].indexOf("#") != -1) min_col = wallpaper[i].indexOf("#");
			if(max_col < wallpaper[i].lastIndexOf("#")) max_col = wallpaper[i].lastIndexOf("#");
		}
		

		int[] answer = {min_row, min_col, max_row+1, max_col+1};
		return answer;
	}
}
