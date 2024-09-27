package 연습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 달리기_경주 {
	
	/**
	 * 원래 만든 것(몇개 시간초과)
	 */
	public String[] solution(String[] players, String[] callings) {
		
		List<String> playersList = new ArrayList<String>();
		List<String> callingsList = new ArrayList<String>();
		String[] playersTemp = players;
		
		for(String player : players) playersList.add(player);
		for(String call : callings) callingsList.add(call);
		
//		System.out.println("기존 : " + playersList +"\n");		// 처음에 들어온 playersList 확인용
		
		for(String call : callingsList) {
			int idx = playersList.indexOf(call);
//			System.out.println(idx);							// 인덱스 확인용
			playersList.set(idx-1, playersTemp[idx]);
			playersList.set(idx, playersTemp[idx-1]);
			
//			System.out.println(playersList);					// 교체되었는지 확인 용
			playersTemp = playersList.toArray(String[]::new);	// 교체된 상태의 String[] 생성
		}
		
		return playersTemp;
		// 시간이 오래걸림.....에잉
    }
	
	public String[] solution2(String[] players, String[] callings) {
		Map<String, Integer> playersMap = new HashMap<String, Integer>();
		
		for(int i=0; i<players.length; i++) playersMap.put(players[i], i);
		System.out.println(playersMap);
		
		for(String player : callings) {
			int playerRanking = playersMap.get(player);		// 순회하는 player(key String형) 의 Ranking(value int형)
			String frontPlayer = players[playerRanking-1];	// player의 앞사람 불러오기(key 를 얻어오고 있음)
			
			// playersMap 상에서 등수 바꾸기
			playersMap.put(player, playerRanking-1);
			playersMap.put(frontPlayer, playerRanking);
			
			// 호출한 player와 앞 player의 순서바꾸기
			players[playerRanking-1] = player;
			players[playerRanking] = frontPlayer;
			
		}
//		System.out.println(playersMap);
//		System.out.println(Arrays.toString(players));
		
		return players;
	}
}
