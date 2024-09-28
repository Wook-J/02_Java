package 연습문제;

import java.util.ArrayList;
import java.util.List;

public class 둘만의_암호 {
	
	public String solution(String s, String skip, int index) {
//		System.out.println("[s : "+s +"] , [skip : "+ skip +"], [index : "+ index + "]");
		String answer = "";
		
		String[] alphaArr = "abcdefghijklmnopqrstuvwxyz".split("");
		
		List<String> alphaList = new ArrayList<String> ();
		for(String alphabet : alphaArr) alphaList.add(alphabet);
		for(String skipAlphbet : skip.split("")) alphaList.remove(skipAlphbet);
		
//		System.out.println(alphaList);			// skip에 포함된 알파벳 삭제된 배열 확인용
		for(String str : s.split("")) {
			int finalIndex = (alphaList.indexOf(str)+index) % alphaList.size();
						
			answer += alphaList.get(finalIndex); 
		}
		return answer;
    }

}
