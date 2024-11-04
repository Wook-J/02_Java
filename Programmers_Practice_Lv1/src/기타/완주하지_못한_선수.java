package 기타;

import java.util.ArrayList;
import java.util.List;

public class 완주하지_못한_선수 {
	public String solution(String[] participant, String[] completion) {

		List<String> partiList = new ArrayList<String>();
		for(String str : participant) partiList.add(str);
		for(String complete : completion) partiList.remove(complete);

		return partiList.get(0);
    }

}
