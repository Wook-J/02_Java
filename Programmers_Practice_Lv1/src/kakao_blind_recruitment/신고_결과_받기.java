package kakao_blind_recruitment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class 신고_결과_받기 {
	public int[] solution(String[] id_list, String[] report, int k) {
		
		List<String[]> reportList = new ArrayList<String[]>();
		for(String ele : report) reportList.add(ele.split(" "));
		
//		System.out.println("--------- reportList 확인용 ---------");
//		for(String[] strArr : reportList) {
//			System.out.println(Arrays.toString(strArr));
//		}
//		System.out.println("-------------------------------------");
		
		Map<String, Set<String>> nameDeclarationMap = new HashMap<String, Set<String>>();
		for(String id : id_list) {
			Set<String> declaSet = new HashSet<String>();
			
			for(String[] strArr : reportList) {
				if(id.equals(strArr[0])) declaSet.add(strArr[1]);
			}
			nameDeclarationMap.put(id, declaSet);
		}
		
		System.out.println("nameDeclarationMap : " + nameDeclarationMap);
		
		int[] declaration = new int [id_list.length];
		for(Entry<String, Set<String>> entry : nameDeclarationMap.entrySet()) {
			for(String ele : entry.getValue()) {
				
			}
			
		}
//		Set<String[]> reportSet = new HashSet<String[]>();
//		for(String rep : report) reportSet.add(rep.split(" "));
//		List<String[]> reportList = new ArrayList<String[]>(reportSet);
//
//		System.out.println("--------- reportSet 확인용 ---------");
//		for(String[] repArr : reportSet) {			// 어떻게 들어갔는지 확인용
//			System.out.println(Arrays.toString(repArr));
//		}
//		System.out.println("--------- ---------------- ---------");
//		
//		int[] declaration = new int [id_list.length];
//		for(String[] repArr : reportSet) {
//			declaration[Arrays.asList(id_list).indexOf(repArr[1])]++;
//		}
//		
//		System.out.println("  유저 ID    : " + Arrays.toString(id_list));
//		System.out.println("신고당한횟수 : " + Arrays.toString(declaration));
//		
//		List<String> decList = new ArrayList<String>();
//		for(int i=0; i<declaration.length; i++) {
//			if(declaration[i] >= k) {	// 신고당한 횟수가 k번 이상인 경우
//				decList.add(id_list[i]);
//			}
//		}
//		System.out.println("decList : " + decList);

		int[] answer = new int [id_list.length];
        return answer;
	}

}
