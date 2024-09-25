package com.hw4.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hw4.model.dto.Book;

public class BookService {

	// 필드, 맴버변수
	private Scanner sc = new Scanner(System.in);
	
	private List<Book> library = new ArrayList<Book>();	// 부모타입 참조변수 = 자식객체의 주소(다형성 중 업캐스팅)
	private List<Book> favList = new ArrayList<Book>();
	
	// 생성자
	public BookService() {
		library.add(new Book(1111, "세이노의 가르침", "세이노", 6480, "데이원"));
		library.add(new Book(2222, "문과남자의 과학공부", "유시민", 15750, "돌베개"));
		library.add(new Book(3333, "역행자", "자청", 17550, "웅진지식하우스"));
		library.add(new Book(4444, "꿀벌의 예언", "베르나르 베르베르", 15120, "열린책들"));
		library.add(new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스"));
	}
	
	// 일반 메서드
	public void displayMenu() {
		
		try {			
			int menuNum = 0;
			
			do {
				System.out.println("=== 도서 목록 프로그램 ===");
				System.out.println("1. 도서 등록");
				System.out.println("2. 도서 조회");
				System.out.println("3. 도서 수정");
				System.out.println("4. 도서 삭제");
				System.out.println("5. 즐겨찾기 추가");
				System.out.println("6. 즐겨찾기 삭제");
				System.out.println("7. 즐겨찾기 조회");
				System.out.println("8. 추천도서 뽑기");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴를 입력하세요 : ");
				menuNum = sc.nextInt();
				
				switch(menuNum) {
				case 1: addBook(); break;							// 도서 등록
				case 2: showBookList(library); break;				// 도서 조회
				case 3: System.out.println(editBook()); break;		// 도서 수정
				case 4: System.out.println(deleteBook()); break;	// 도서 삭제
				case 5: addFavorite(); break;						// 즐겨찾기 추가
				case 6: deleteFavorite(); break;					// 즐겨찾기 삭제
				case 7: showBookList(favList); break;				// 즐겨찾기 조회
				case 8: randomBook(); break;						// 추천도서 뽑기
				case 0: System.out.println("프로그램을 종료합니다."); break;
				default: System.out.println("메뉴에 있는 번호만 입력하세요!"); break;
				
				}
			}while(menuNum != 0);
			
		}catch (Exception e) {				// Exception : 예외 클래스의 최상위 클래스
			System.out.println("예외 발생");
			e.printStackTrace();
		}

	}
	
	/** 1. 도서 등록 메서드
	 * 
	 */
	public void addBook() {
		System.out.println("========= 도서 등록 =========");
		
		System.out.print("도서 번호 : ");
		int bookNum = sc.nextInt();
		sc.nextLine();						// 입력버퍼에 남은 개행문자 제거용
		
		System.out.print("도서 제목 : ");
		String title = sc.nextLine();
		
		System.out.print("도서 저자 : ");
		String writer = sc.nextLine();
		
		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();						// 입력버퍼에 남은 개행문자 제거용
		
		System.out.print("도서 출판사 : ");
		String publisher = sc.nextLine();
		
		Book newBook = new Book(bookNum, title, writer, price, publisher);
		library.add(newBook);
		System.out.println("등록 완료");
	}
	
	/** 2. 도서 조회 메서드
	 * @param List<Book>
	 */
	public void showBookList(List<Book> temp) {
		
		if(temp.isEmpty()) {
			System.out.println("등록된 도서가 없습니다. 도서를 등록해주세요!");
		}else {
			
			for(Book book : temp) {
				System.out.println(book);
			}
			
			System.out.println();
		}
	}
	
	/** 3. 도서 수정 메서드
	 * @return "수정완료" 기타
	 */
	public String editBook() {
		
		showBookList(library);				// 등록된 도서를 출력하기
		System.out.println("======= 도서 수정 =======");
		
		
		System.out.print("수정할 도서 번호를 입력하세요 : ");
		int bookNum = sc.nextInt();
		
		boolean flag = true;
		int editMenu = 0;					// 수정 메뉴 선택용 변수
		
		for(Book temp : library) {
			if(temp.getBookNum() == bookNum) {	// 입력한 도서번호화 도서목록의 도서 번호가 일치하는걸 찾은 경우
				flag = false;
				
				System.out.println("1. 도서명");
				System.out.println("2. 도서 저자");
				System.out.println("3. 도서 가격");
				System.out.println("4. 도서 출판사");
				System.out.println("0. 수정 종료");
				System.out.print("어떤 정보를 수정하시겠습니까? ");
				
				editMenu = sc.nextInt();
				sc.nextLine();				// 입력버퍼에 남은 개행문자 제거
				
				switch(editMenu) {
				case 1: 
					System.out.println("===== 도서명 수정 =====");
					System.out.print("수정할 도서명을 입력하세요 : ");
					String title = sc.nextLine();
					temp.setTitle(title);
					break;
				case 2:
					System.out.println("===== 도서 저자 수정 =====");
					System.out.print("수정할 저자명을 입력하세요 : ");
					String writer = sc.nextLine();
					temp.setWriter(writer);
					break;
				case 3:
					System.out.println("===== 도서 가격 수정 =====");
					System.out.print("수정할 가격을 입력하세요 : ");
					int price = sc.nextInt();
					temp.setPrice(price);
					break;
				case 4:
					System.out.println("===== 도서 출판사 수정 =====");
					System.out.print("수정할 출판사명을 입력하세요 : ");
					String publisher = sc.nextLine();
					temp.setPublisher(publisher);
					break;
				case 0: System.out.println("종료합니다..."); break;
				default: System.out.println("메뉴에 있는 번호만 선택하세요"); break;
				}
			}
		}
		
		if(flag) {
			return "일치하는 도서 번호가 없습니다.\n";
		}
		
		return "수정 완료\n";
		
	}
	
	/** 4. 도서 삭제용 메서드
	 * @return "삭제 완료" 또는 "삭제를 진행하지 않습니다"
	 */
	public String deleteBook() {
		System.out.println("======= 도서 삭제 =======");
		
		showBookList(library);
		
		System.out.print("삭제할 도서의 번호를 입력하세요 : ");
		int deleteNum = sc.nextInt();
		
		for(Book temp : library) {
			if(temp.getBookNum() == deleteNum) {
				int index = library.indexOf(temp);		// List 에 일치하는 객체가 있으면 그 객체의 index 번호 반환
				
				System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
				char answer = sc.next().toUpperCase().charAt(0);
				
				if(answer == 'Y') {
					library.remove(index);
					break;
				} else {
					return "삭제를 진행하지 않습니다.\n";
				}
			}
		}
		
		return "삭제 완료\n";
	}
	
	/** 5. 즐겨찾기 추가 메서드
	 * 
	 */
	public void addFavorite() {
		System.out.println("=== 즐겨찾기 등록 ===");
		
		System.out.println("현재 등록된 도서 목록");
		for(Book book:library) {
			System.out.println(book);
		}
		
		System.out.print("등록할 도서 번호 등록 : ");
		int addFavBookNum = sc.nextInt();
		
		boolean flag = true;
		
		for(Book book : library) {
			if(book.getBookNum()==addFavBookNum) {
				flag = false;
				favList.add(book);
				System.out.println("등록 성공\n");
				break;
			}
		}
		
		if(flag) System.out.println("일치하는 도서 번호가 없습니다.\n");

	}
	
	/** 6. 즐겨찾기 삭제 메서드
	 * 
	 */
	public void deleteFavorite() {
		System.out.println("=== 즐겨찾기 삭제 ===");
		
		System.out.println("현재 등록된 즐겨찾기 목록");
		for(Book book : favList) {
			System.out.println(book);
		}
		
		System.out.print("즐겨찾기 삭제할 도서 번호를 입력하세요 : ");
		int delFavBookNum = sc.nextInt();
		
		boolean flag = true;
		
		for(Book book : favList) {
			if(book.getBookNum() == delFavBookNum) {
				flag = false;
				favList.remove(favList.indexOf(book));
				System.out.println("삭제 성공\n");
				break;
			}
		}
		
		if(flag) System.out.println("삭제하려는 도서 번호가 없습니다.\n");
	}
	
	/** 8. 추천도서 뽑기 메서드
	 * 
	 */
	public void randomBook() {
		
		int random = (int) (Math.random() * library.size());
		System.out.println(library.get(random) + "\n");
	}
	
	// getter, setter
}
