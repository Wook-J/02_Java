package edu.kh.io.pack1.model.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileService {

	/* File 클래스
	 *
	 * - java.io 패키지
	 *
	 * - 파일/디렉토리(폴더)를 관리하는 클래스
	 *   (파일/디렉토리 존재 유무 관계 없음)
	 * 
	 * - 파일 생성, 제거, 이름, 크기, 마지막 수정일, 존재여부 등의 기능 제공
	 * 
	 * - File 클래스 메서드
	 *
	 * boolean  mkdir()          : 디렉토리 생성
	 * boolean  mkdirs()         : 경로상의 모든 디렉토리 생성
	 * boolean  createNewFile()  : 파일 생성
	 * boolean  delete()         : 파일/디렉토리 삭제
	 * String   getName()        : 파일/디렉토리 이름 반환
	 * String   parent()         : 파일이 저장된 디렉토리 반환
	 * String   getPath()        : 전체 경로 반환
	 * boolean  isFile()         : 현재 File 객체가 관리하는게 파일이면 true
	 * boolean  isDirectory()    : 현재 File 객체가 관리하는게 디렉토리 true
	 * boolean  exists()         : 파일/디렉토리가 존재하면 true, 아님 false
	 * long     length()         : 파일 크기 반환
	 * long     lastModified()   : 파일 마지막 수정일 (1970.01.01 09:00 부터 현재까지 지난 시간을 ms 단위로 반환)
	 * String[] list()          : 디렉토리 내 파일 목록을 String[] 배열로 반환
	 * File[]   listFiles()     : 디렉토리 내 파일 목록을 File[] 배열로 반환
	 */
	
	/* [개발자 상식!]
	 *
	 * OS : 운영 체제
	 *
	 *  (Windows)    /     (Linux, Mac)
	 *    폴더       /      디렉토리
	 * 
	 * - 경로 표기 방법(하위 폴더, 파일 표시)
	 *
	 * 백슬래시 (\, Windows)     -> C:\workspace\02_Java
	 * 슬래시   (/, Linux, Mac ) -> C:/workspace/02_Java
	 *
	 *
	 * - Java 언어의 특징 : 플랫폼(OS)에 독립적
	 * -> OS 관계 없이 똑같은 코드 작성이 가능
	 *
	 * -> 이 특징을 유지하기 위해 /, \ 둘다 호환 가능
	 *   (런타임 시 실행되는 OS에 맞게 자동으로 변경)
	 *
	 *
	 * -------------------------------------------------------------
	 *
	 * - 경로 표기 방법
	 *
	 * 1) 절대 경로 : 하나의(절대적인) 기준으로 부터
	 * 				 목표까지의 경로를 모두 표기하는 방법
	 *
	 * - 기준
	 * [Windows] :   C:/  , D:/
	 * [Linux, Mac] : /Users ,   /
	 *
	 *
	 * 2) 상대 경로 : 현재 위치를 기준으로 목표까지의 경로를 표기하는 방법
	 *
	 *
	 * */
	
	/**
	 * File 클래스로 객체 생성
	 * + 폴더가 존재하지 않으면 폴더 생성
	 */
	public void method1() {
		
		// 경로의 제일 앞에 /로 시작 : 최상위폴더를 의미함 ( == root, 절대경로의 기준점)
		
		// C:/io_test/20240926 폴더를 지정
		File directory = new File("/io_test/20240926");		// C:/io_test/20240926
		
		// 존재하지 않는 폴더를 관리하는 File 객체 생성
		if(!directory.exists()) {		// 폴더가 존재하지 않으면
			
			directory.mkdirs();			// 경로상의 모든 디렉토리 생성
			
			System.out.println(directory.getName());		// 20240926
			System.out.println(directory.getPath());		// \io_test\20240926
		}else System.out.println("이미 폴더가 존재합니다.");
	}
	
	/**
	 * File 객체를 이용해서 지정된 위치에 파일 생성
	 */
	public void method2() {
		// Java 에서 역슬래시(\)는 이스케이프 문자로 사용됨
		// -> \n 줄바꿈, \t 탭 과 같이 특정 문자 뒤에 특별한 의미를 부여하는 역할을 함
		// -> 역슬래시 자체를 문자로 사용하고 싶을 땐 2개를 사용!!! \\
		
		// 문자열에서 "\"를 표기하는 방법 : "\\"
		
		File file = new File("\\io_test\\20240926\\파일생성.txt");
		
		if(!file.exists()) {			// 파일이 존재하지 않으면
			try {
				// File 클래스의 메서드는 대부분 IOException 발생시킴
				// -> IOException은 반드시 예외처리를 해야하는 Checked Exception
				if(file.createNewFile()) {	// 파일이 생성 성공, true 인 경우
					System.out.println(file.getName() + " 파일이 생성되었습니다.");
				}
			} catch (IOException e) {
				e.printStackTrace();	// 예외 정보 + 예외가 발생한 위치까지의 메서드 추적
			}
		} 
	}
	
	/**
	 * File 클래스가 제공하는 메서드 활용하기
	 */
	public void method3() {
		File directory = new File("\\workspace\\02_Java\\12_IO");
		
		// 지정된 경로에 있는 모든 파일 또는 디렉토리를 File[] 형태로 얻어오기
		File[] files = directory.listFiles();
		
//		System.out.println(Arrays.toString(files));
		/* 실행 시 나오는 결과
		 * [
		 * \workspace\02_Java\12_IO\.classpath, 
		 * \workspace\02_Java\12_IO\.project, 
		 * \workspace\02_Java\12_IO\.settings, 
		 * \workspace\02_Java\12_IO\bin, 
		 * \workspace\02_Java\12_IO\src
		 * ]
		 * */
		
		// 향상된 for 문 이용하여 (파일명, 수정날짜, 타입, 크기) 출력
		for(File f : files) {
		// 파일명
			String fileName = f.getName();
			
		// 마지막으로 수정한 날짜
			long lastModified = f.lastModified();
			
			// java.text.SimpleDateFormat : 간단히 날짜 형식을 지정할 수 있는 객체
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a h:mm");
			
			// String SimplaDateFormat.format(long)
			// -> 매개변수 long 값을 지정된 패턴 형식으로 반환하여
			// -> 문자열 형태로 반환
			String date = sdf.format(lastModified);
			
		// 유형 : 파일 or 폴더 
			String type = null;
			if(f.isFile()) type = "파일";
			else type = "폴더";
			
		// 파일 크기(byte)
			String size = f.length() + " B";	// 폴더의 경우에는 .length() 없음..!
			if(f.isDirectory()) size = "";		// 폴더라면 size 를 빈문자열로 변경
			// 폴더의 크기를 구하는 메서드는 java 에서 제공하지 않음
			// -> 구하려면 폴더 안의 모든 파일을 순회하여 각 파일 크기를 합산해서 써야함!
			
			String result = String.format("%-20s %-20s %-5s %10s", fileName, date, type, size);
			System.out.println(result);
		}
	}
	
	/*
	 * 스트림은 파일이나 데이터의 입출력 작업을 위해서 사용됨
	 * 즉, 파일이나 폴더에 실제 데이터를 읽거나 쓸 때 스트림을 이용함.
	 * 
	 * 하지만 폴더/파일 생성 및 삭제하는 것은 입출력 작업이 아닌
	 * 파일 시스템과의 일반적인 상호작용이기 때문에 스트림을 사용할 필요 없음
	 * */

}
