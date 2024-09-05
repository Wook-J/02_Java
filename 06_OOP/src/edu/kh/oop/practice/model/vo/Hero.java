package edu.kh.oop.practice.model.vo;

public class Hero {
	
	// 필드, 멤버변수
	private String nickName;
	private String job;
	private int hp;
	private int mp;
	private int level;
	private double exp;
	
	// 생성자
	public Hero() {}
	public Hero(String nickName, String job, int hp, int mp, int level, double exp) {
		// 필드, 멤버변수
//		super();
		this.nickName = nickName;
		this.job = job;
		this.hp = hp;
		this.mp = mp;
		this.level = level;
		this.exp = exp;
		
		// 메서드
		System.out.println("=========== 캐릭터 생성 ===========");
		System.out.printf("전사직업으로 '%s'님이 생성되었습니다\n", nickName);
		System.out.printf("현재 레벨 : %d\n", level);
		System.out.printf("현재 hp : %d\n", hp);
		System.out.printf("현재 mp : %d\n", mp);
		System.out.printf("현재 경험치 : %.1f\n", exp);
	}
	
	// 메서드
	public void attack(double exp) {
		this.exp += exp;
		
		System.out.printf("'%s'은/는 공격을 했다!!! 현재 경험치 : %.1f\n", nickName, this.exp);
		
		if(this.exp>=300) {
			this.level++;
			System.out.println("레벨이 올랐습니다!! 현재 레벨 : " + this.level);
		}
	}
	
	public void dash() {
		mp -= 10;
		System.out.printf("'%s'의 엄청 빠른 대시!!! 남은 마력 : %d\n", nickName, mp);
		if(mp<=0) {
			System.out.println("[마력부족]더 이상 대시 할 수 없어요~!");
		}
	}
	
	@Override
	public String toString() {
		return "======='" + nickName +"'님의 정보=======\n"+
			   "- 현재 레벨 : " + level + "\n"+
			   "- 현재 hp : " + hp + "\n"+
			   "- 현재 mp : " + mp + "\n"+
			   "- 현재 exp : " + exp;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public double getExp() {
		return exp;
	}
	public void setExp(double exp) {
		this.exp = exp;
	}
}
