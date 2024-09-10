package com.hw3.controller;

import java.util.Scanner;

import com.hw3.model.vo.Product;

public class ProductController {
	
	// 필드, 매개변수
	private Product[] pro = null;
	public static int count = 0;
	Scanner sc = new Scanner(System.in);
	
	// 초기화블록 : 객체 생성시 생성자보다 먼저 수행되는 블록/ 중괄호{}를 이용함
	{pro = new Product[10];}
	
	// 생성자
	
	// 메서드
	// 기본 상태 메서드
	public void mainMenu() {

		int menuNum = 0;
		do {
			System.out.println("============ 제품 관리 메뉴 ============");
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
			case 3: productDelete(); break;						// 제품 삭제 메서드
			case 4: productUpdate(); break;						// 제품 수정 메서드
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
		
		System.out.println("새로운 제품 정보가 추가되었습니다.\n");
	}
	
	// 제품 전체 조회 메서드
	public void productPrint() {
		System.out.println("\n======= 제품 전체 조회 =======");
		
		if(count == 0){
			System.out.println("조회할 제품이 없습니다. 제품을 추가해 주세요\n");
			return;
		}
		for(int i=0; i<count; i++) {
			System.out.println(pro[i].information());
		}
		System.out.println();
	}
	
	// 제품 삭제 메서드
	public void productDelete() {
		System.out.println("\n======= 제품 삭제 =======");
		
		if(count == 0) {
			System.out.println("삭제할 제품이 없습니다. 제품을 추가해 주세요\n");
			return;
		}
		
		System.out.println("삭제할 제품 번호를 입력해 주세요 : ");
		int delpId = sc.nextInt();
		boolean flag = true;
		
		for(int i=0; i<count; i++) {	
			if(delpId == pro[i].getpId()) {
				System.out.println("제품 번호 "+pro[i].getpId()+"이/가 삭제되었습니다.\n");
				pro[i] = null;
				
				for(int j=i; j<count-1; j++) {		// 삭제된 이후 제품번호가 갖고 있는 방을 한칸씩 당겨오기
					pro[j] = pro[j+1] ;
				}
				
				flag = false;
				pro[count-1]=null;					// 삭제된 이후 마지막 방의 제품정보 삭제
				count--;							// 다시 추가할 수 있도록 count--
				break;								// 한번 수행후 탈출
			}
		}
		
		if(flag) System.out.println(delpId + "와 일치하는 제품 번호가 없습니다. 올바른 제품번호를 입력해 주세요.\n");
	}
	
	// 제품 수정 메서드
	public void productUpdate() {
		System.out.println("\n======= 제품 수정 =======");
		
		if(count==0) {
			System.out.println("수정할 제품이 없습니다. 제품을 추가해 주세요\n");
			return;
		}
		
		System.out.print("수정할 제품 번호를 입력해주세요 : ");
		int revisepId = sc.nextInt();
		boolean flag = true;
		
		for(int i=0; i<count; i++) {
			if(revisepId == pro[i].getpId()) {
				System.out.println("제품 번호 " + pro[i].getpId() + "의 기존 정보입니다");
				System.out.println(pro[i].information());
				
				System.out.print("수정할 제품 번호(동일할 경우 기존번호 입력) : ");
				pro[i].setpId(sc.nextInt());
				
				System.out.print("수정할 제품명(동일할 경우 기존명 입력) : ");
				pro[i].setpName(sc.next());
				
				System.out.print("수정할 제품 가격(동일할 경우 기존가격 입력) : ");
				pro[i].setPrice(sc.nextInt());
				
				System.out.print("수정할 제품 세금(동일할 경우 기존세금 입력) : ");
				pro[i].setTax(sc.nextDouble());
				
				System.out.println("제품 정보가 변경되었습니다.\n");
				flag = false;
				break;
			}
		}
		
		if(flag) System.out.println(revisepId + "와 일치하는 제품 번호가 없습니다. 올바른 제품번호를 입력해 주세요.\n");
	}
}
