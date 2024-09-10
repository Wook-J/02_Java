package com.kh.inheritance.model.dto;

public class SmartPhone extends Phone {
	
	// 필드, 멤버변수
	private String operatingSystem;
	private int storageCapacity;
	
	// 생성자
	public SmartPhone() {}

	public SmartPhone(String brand, String model, int year, int price, String operatingSystem, int storageCapacity) {
		super(brand, model, year, price);
		this.operatingSystem = operatingSystem;
		this.storageCapacity = storageCapacity;
	}
	
	// 메서드
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf("Operating System : %s\nStorage Capacity : %dGB\n", operatingSystem, storageCapacity);
	}
	
	// getter, setter
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public int getStorageCapacity() {
		return storageCapacity;
	}
	public void setStorageCapacity(int storageCapacity) {
		this.storageCapacity = storageCapacity;
	}
}
