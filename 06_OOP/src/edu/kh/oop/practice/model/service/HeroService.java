package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Hero;

public class HeroService {

	public void practice() {
		
		Hero hero1 = new Hero("이구역짱", "전사", 200, 20, 1, 0);
		Hero hero2 = new Hero("Zi존위자드", "마법사", 100, 100, 1, 0);
		
		System.out.printf("===========%s 시점===========\n", hero1.getNickName());
		
		hero1.attack(100.0);
		hero1.attack(50.5);
		hero1.attack(49.5);
		
		hero1.dash();
		hero1.dash();
		hero1.dash();
		
		System.out.println(hero1.toString());

//		System.out.printf(hero1.toString(), hero1.getNickName(), hero1.getLevel(), hero1.getHp(), hero1.getMp(), hero1.getExp());
//		printf로 할 경우에는 위에처럼 객체명.get~~ 해야함..! 복잡하므로 toString 자체에 대입하는 것도 좋음
		
		System.out.printf("===========%s 시점===========\n", hero2.getNickName());
		
		hero2.attack(300.0);
		hero2.dash();
		hero2.attack(300.0);
		hero2.attack(300.0);
		
		System.out.println(hero2.toString());

	}
}
