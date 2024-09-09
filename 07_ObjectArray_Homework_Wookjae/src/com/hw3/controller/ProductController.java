package com.hw3.controller;

import java.util.Scanner;

import com.hw3.model.vo.Product;

public class ProductController {
	
	// 필드, 매개변수
	private Product[] pro = new Product[10];
	public int count = 0;
	Scanner sc = new Scanner(System.in);
	
	// 생성자
	
	// 메서드
	public void mainMenu() {

		int menuNum = 0;
		do {
			System.out.println("====== 제품 관리 메뉴 ======");
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("3. 제품 삭제");
			System.out.println("4. 제품 수정");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("번호 입력 : ");
			menuNum = sc.nextInt();
			sc.nextLine();			// 입력버퍼에 있는 개행문자 제거
			
			switch(menuNum) {
			case 1: productInput(); break;						// 제품 정보 추가 메서드
			case 2: productPrint(); break;						// 제품 전체 조회 메서드
			case 3: break;						// 제품 삭제 메서드
			case 4: break;						// 제품 수정 메서드
			case 0: System.out.println("프로그램 종료"); break;	// 프로그램 종료
			default: System.out.println("올바른 번호를 입력하세요"); break;
			}
		}while(menuNum != 0);

	}
	
	// 제품 정보 추가 메서드
	public void productInput() {
		
		System.out.println("\n======= 제품 정보 추가 =======");
		
		if(count==10) {
			System.out.println("제품을 더 이상 늘릴 수 없습니다(최대 10개)\n");
			return;
		}

		System.out.print("제품 번호 : ");
		int pId = sc.nextInt();
		
		System.out.print("제품명 : ");
		String pName = sc.next();
		
		System.out.print("제품 가격 : ");
		int price = sc.nextInt();
		
		System.out.print("제품 세금 : ");
		double tax = sc.nextDouble();
		
		pro[count] = new Product(pId, pName, price, tax);
		count++;
		
		System.out.println("새로운 제품 정보가 추가되었습니다.\n");
	}
	
	// 제품 전체 조회 메서드
	public void productPrint() {
		for(int i=0; i<count; i++) {
			System.out.println(pro[i].information());
		}		
	}
	
	// 제품 삭제 메서드    -> 작성 중
	public void productDelete() {
		System.out.println("\n======= 제품 삭제 =======");
		
		System.out.println("삭제할 제품 번호를 입력해 주세요");
		int delpId = sc.nextInt();
		
		boolean flag = true;
		
		for(int i=0; i<count; i++) {
			if(pro[i].getpId() == delpId) pro[i] = null;
			for(int j=i+1; j<count-1; j++) {
				pro[j] = pro[j+1];
			}
			pro[count] = null;
		}
	}
	
	// 제품 수정 메서드
	
	// 제품 검색 메서드
}
