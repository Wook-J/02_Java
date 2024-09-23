package com.hw1.run;

import java.util.ArrayList;
import java.util.Random;

import com.hw1.model.dto.Friend;

public class Run {

	public static void main(String[] args) {
		
		ArrayList<Friend> friend = new ArrayList<Friend>();
		friend.add(new Friend("짱구"));
		friend.add(new Friend("철수"));
		friend.add(new Friend("유리"));
		friend.add(new Friend("훈이"));
		friend.add(new Friend("맹구"));

		Random random = new Random();
		friend.get(random.nextInt(friend.size()) ).pickLeader();
		
	}

}
