package kakao_blind_recruitment;

public class 신규_아이디_추천 {
	
	public String solution(String new_id) {
		System.out.println("[new_id] " + new_id);
		
		// 1단계 : new_id의 모든 대문자를 대응되는 소문자로 치환
		String answer = new_id.toLowerCase();
		System.out.println("stage1 : " + answer);
		
		// 2단계 : 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
		answer = answer.replaceAll("[^a-z0-9-_.]*", "");
		System.out.println("stage2 : " + answer);
		
		// 3단계 : 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
		answer = answer.replaceAll("\\.{2,}", ".");
		System.out.println("stage3 : " + answer);
		
		// 4단계 : 마침표(.)가 처음이나 끝에 위치한다면 제거
		answer = answer.replaceAll("^\\.|\\.$", "");
		System.out.println("stage4 : " + answer);
		
		// 5단계 : 빈 문자열이라면, "a" 대입
		if (answer.isEmpty()) answer = "a";
		System.out.println("stage5 : " + answer);
		
		// 6단계 : 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
		// 만약 제거 후 마침표(.)가 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
		if (answer.length() >= 16) {
			answer = answer.substring(0,15);
			answer = answer.replaceAll("\\.$", "");
        }
		System.out.println("stage6 : " + answer);
		
		// 7단계 : 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 추가
		if(answer.length() < 3) {
			for(int i=0; i<4-answer.length(); i++) answer += answer.charAt(answer.length()-1);
		}
		System.out.println("stage7 : " + answer);


        return answer;
    }
}
