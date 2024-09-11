package edu.kh.poly.ex1.model.dto;

public class Tesla extends Car {
	
	// 속성(필드, 멤버변수)
	private int batteryCapacity;	// 배터리 용량
	
	// 생성자
	public Tesla() {}

	public Tesla(String engine, String fuel, int wheel, int batteryCapacity) {
		super(engine, fuel, wheel);
		this.batteryCapacity = batteryCapacity;
	}
	
	// 메서드
	@Override
	public String toString() {
		return super.toString() + " / " + batteryCapacity;
	}
	
	// getter, setter
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
}
