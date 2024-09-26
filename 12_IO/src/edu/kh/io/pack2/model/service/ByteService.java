package edu.kh.io.pack2.model.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteService {
	/*
	 * 스트림(Stream) : 데이터가 이동하는 통로(기본적으로 한 방향임)
	 * 
	 * Byte 기반 스트림 : 1Byte 단위로 데이터를 입/출력하는 스트림
	 * 
	 * - 최상위클래스 : InputStream, OutputStream
	 * 
	 * - 문자열, 이미지, 영상, 오디오, pdf 등 모든 것을 입/출력 가능
	 *   (단, 통로가 좁다보니 속도가 느림)
	 *   (char 형(2Byte 단위) 문자는 깨질 우려가 있음)
	 * */
	
	// IO 관련된 코드는 IOException 이 발생될 가능성이 높음!
	// ->  거의 모든 메서드가 throws IOException 가 포함됨
	// -> IOException 예외 처리 구문을 작성하는 것이 필수!
	
	/** 
	 * 바이트 기반 스트림을 이용한 파일 출력
	 * + 데이터 출력
	 */
	public void fileByteOutput() {
		
		// FileOutputStream 참조변수 선언 (OutputStream 을 상속받은 자식 클래스)
		FileOutputStream fos = null;
		
		try {
			
			// new FileOutputStream("경로") : 
			// -> 경로에 작성된 파일과 연결된 파일 출력 스트림 객체 생성
			// -> 출력 스트림에 연결된 파일이 존재하지 않으면 파일 자동생성 해줌!
			//    단, 폴더는 생성되지 않음!(폴더 없으면 에러발생)
			// -> 기존 파일이 존재하면 내용을 덮어쓰기함
			
			fos = new FileOutputStream("/io_test/20240926/바이트기반_테스트.txt");
			
			// String 불변성 문제를 해결한 객체 -> 가변성 
			// StringBuilder(비동기) / StringBuffer(동기)
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("Hello World!\n");
			sb.append("1234567890\n");
			sb.append("~!@#$%^&*()_+<>?\n");
			sb.append("가나다라마바사아\n");
			sb.append("집에 가고 싶다....\n");
			sb.append("아침저녁 지하철에 사람이 너무많아....\n");
			sb.append("그래도 자바는 재밌지\n");
			
			// StringBuilder -> String 변환
			String content = sb.toString();
			
			// 출력방법 1 : 한 글자(2byte)씩 파일로 출력
			// -> 2byte 범주의 문자(영어, 숫자, 기본 특수문자 제외)는 바이트 기반 스트림 통과 시
			//    데이터 손실이 발생해서 글자가 깨지는 문제 발생!!
			
			/* 출력방법 1 코드
			for(int i=0; i<content.length(); i++) {
				char ch = content.charAt(i);
				fos.write(ch);					// 1byte 출력 스트림이 연결된 파일에 ch 쓰기
			}
			*/
			
			
			
			// ******* 수행시간 확인 *******
			// System.nanoTime() : 1970.01.01 09:00:00 부터 현재시간 까지의 
			// 차이를 ns(nano second)로 반환
			
			long startTime = System.nanoTime();			// 시점 1 : write() 수행 전 시간
			
			fos.write(content.getBytes());		// 출력방법 2 : String 을 byte[] 로 변환 후 출력
			
			long endTime = System.nanoTime();			// 시점 2 : write() 수행 후 시간
			
			System.out.println("[수행 시간] : " + (endTime-startTime) + "ns");
			// 기반 스트림만 사용한 경우 : 65000 ~ 85000 ns 정도 나옴
			
			fos.flush();						// stream 에 남아있는 모든 데이터를 밀어내는 용도
			
			System.out.println("출력 완료!");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {		// try 예외 발생 여부에 관계 없이 무조건 수행되는 구문
			
			// 사용완료한 스트림을 제거(닫기, 메모리 반환)하는 코드 작성
			// -> 메모리 누수 방지
			
			try {
				// 스트림이 정상 생성된 경우
				// close() 도 IOException이 발생하므로 try-catch 구문 작성 필요
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 버퍼를 이용한 파일 출력
	 * + BufferedOutputStream 보조 스트림 이용
	 */
	public void bufferedFileByteOutput() {
		/* 버퍼(Buffer) :  데이터를 모아두는 박스, 바구니 같은 메모리 공간
		 * 
		 * 
		 * * 버퍼링
		 *   - 인터넷 속도 낮거나 스트리밍 코드가 효율이 안좋을 때
		 *   - 동영상 재생 중 미리 앞에 재생될 부분을 다운 받아놔서
		 *   - 영상을 끊김없이 볼 수 있게 함!
		 *   -> 다운받아서 저정해놓는 공간 == 버퍼
		 *   
		 * BufferedOutputStream / BufferedInputStream  : 바이트 기반
		 *  출력용 보조 스트림  /  입력용 보조 스트림
		 *  
		 * - FileOutputStream은 1바이트씩 데이터를 입출력하는데
		 *   통로가 좁아서 데이터 입출력이 느림
		 * -> 보조스트림 이용 시 버퍼에 입출력할 내용을 모아서 한 번에 입출력함!
		 * -> 기반 스트림을 이용하는 횟수가 적어져서 성능, 시간 효율 상승! 
		 * */
		
		FileOutputStream fos = null;				// 기반 스트림 참조변수 선언
		BufferedOutputStream bos = null;			// 보조 스트림 참조변수 선언
		
		try {
			fos = new FileOutputStream("/io_test/20240926/바이트기반_테스트_Buffered.txt");
			bos = new BufferedOutputStream(fos);	// 기반 스트림 fos 를 이용해 보조 스트림 bos 생성
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("Hello World!\n");
			sb.append("1234567890\n");
			sb.append("~!@#$%^&*()_+<>?\n");
			sb.append("가나다라마바사아\n");
			sb.append("집에 가고 싶다....\n");
			sb.append("아침저녁 지하철에 사람이 너무많아....\n");
			sb.append("그래도 자바는 재밌지\n");
			
			String content = sb.toString();

			long startTime = System.nanoTime();		// 시점 1 : write() 수행 전 시간
			
			bos.write(content.getBytes());
			
			long endTime = System.nanoTime();		// 시점 2 : write() 수행 후 시간
			
			System.out.println("[수행 시간] : " + (endTime-startTime) + "ns");
			// 보조 스트림도 사용한 경우 : 35000 ~ 43000 ns 정도 나옴
			
			bos.flush();
			System.out.println("출력 완료!");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {		
				if(bos != null) bos.close();
				// 보조 스트림 close() 시 보조스트림 생성에 사용된 기반스트림도 같이 close() 됨!
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 바이트 기반 파일 입력 1
	 */
	public void fileByteInput() {
		
		FileInputStream fis = null;			// 파일 입력용 바이트 기반 스트림 선언
		
		try {
			
			fis = new FileInputStream("\\io_test\\20240926\\노래가사.txt");
			// InputStream 만들 때는 해당 경로에 실제 파일이 있어야 함!! 없으면 Error 발생
			
			// 방법 1. 파일 내부 내용을 1 byte 씩 끊어서 가져오기
			// -> 2 byte 범주의 글자들이 깨지는 문제가 발생함
			
			// byte -> 자바에서 정수형
			// -> 다루기 힘들기 때문에 정수형 기본형인 int 로 변환해서 사용
			int value = 0;					// 읽어온 바이트값을 저장할 변수
			
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				value = fis.read();			// 1 byte 씩 읽어오기
				// .read() 에서 더 이상 읽어올 값이 없으면 -1 을 반환
				
				if(value == -1) break;		// 다 읽었으면 반복문 탈출
				
				sb.append((char) value);	// char 로 강제 형변환(글자형태) 하여 sb 에 추가
			}
			
			System.out.println(sb.toString());
			
			// InputStream 은 flush() 없음
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 바이트 기반 파일 입력 2
	 */
	public void fileByteInput2() {
		
		FileInputStream fis = null;			// 파일 입력용 바이트 기반 스트림 선언
		
		try {
			
			fis = new FileInputStream("\\io_test\\20240926\\노래가사.txt");
			
			// 방법 2. 파일에 저장된 모든 byte 값을 다 읽어와서 byte[] 형태로 반환받기
			// -> byte[] 배열을 이용해서 String 객체 생성
			
			byte[] bytes = fis.readAllBytes();
			String content = new String(bytes);
			
			System.out.println(content.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(fis != null) fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * BufferedInputStream 보조 스트림을 이용한 성능 향상
	 * 
	 * InputStream의 경우 외부 파일을 읽어올 때 사용
	 * -> 읽어오는 파일의 크기가 작으면 보조 스트림의 성능 이점이 크게 눈에 띄지 않음...
	 */
	public void bufferedFileByteInput() {
		
		FileInputStream fis = null;			// 파일 입력용 바이트 기반 스트림 선언
		BufferedInputStream bis = null;		// 파일 입력용 바이트 보조 스트림 선언
		
		try {
			
			fis = new FileInputStream("\\io_test\\20240926\\노래가사.txt");
			bis = new BufferedInputStream(fis);
			
			byte[] bytes = bis.readAllBytes();
			String content = new String(bytes);
			
			System.out.println(content.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(bis != null) bis.close();	// 보조 스트림 close 하면 기반 스트림도 같이 close 됨 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 파일 복사
	 * 
	 * 파일 경로를 입력 받아 지정된 파일과 같은 경로에 
	 * 복사된 파일 출력하기 
	 * 
	 * [실행화면]
	 * 파일 경로 입력 : /io_test/20240926/노래가사.txt
	 * 복사 완료 : /io_test/20240926/노래가사_copy.txt
	 * 
	 * 1) 입력된 경로에 파일이 있는지 검사
	 * 
	 * 2) 있으면 파일 내용을 모두 읽어오기 : FileInputStream + BufferedInputStream
	 * 
	 * 3) 읽어온 내용을 같은 경로 위치에 "파일명_copy" 이름으로 출력
	 *    : FileOutputStream + BufferedOutputStream
	 * 
	 * + Scanner 대신 BufferedReader 이용(문자열 입력용 Stream)
	 */
	public void fileCopy() {

		BufferedReader br = null;				// 문자열 입력용 스트림
		
		FileInputStream fis = null;				// 파일 입력용 기반 스트림
		BufferedInputStream bis = null;			// 파입 입력용 보조 스트림
		
		FileOutputStream fos = null;			// 파일 출력용 기반 스트림
		BufferedOutputStream bos = null;		// 파일 출력용 보조 스트림
		
		try {
			// 키보드 입력을 받기위한 스트림 객체 생성
			br = new BufferedReader(new InputStreamReader(System.in));
			
			// 경로 입력 받기
			System.out.print("파일 경로 입력 : ");
			String target = br.readLine();		// 입력된 한 줄 읽어오기
			
			// 해당 경로에 파일이 존재하는지 확인
			File file = new File(target);
			
			if(!file.exists()) {				// 해당 경로에 파일이 존재하지 않는 경우
				System.out.println("[해당 경로에 파일이 존재하지 않습니다.]");
				return;
			}
			
			// 해당 경로에 파일이 존재하는 경우
			// target 이 가리키는 파일을 입력받을 수 있도록 입력용 스트림 생성
			// FileInputStream(매개변수) : 매개변수에 File 타입이나 String 타입 대입 가능
			fis = new FileInputStream(target);	// 입력용 기반 스트림 생성
			bis = new BufferedInputStream(fis);	// 입력용 보조 스트림 생성

			byte[] bytes = bis.readAllBytes();
			
			// 출력할 파일의 경로 + _copy 가 붙은 파일이름 생성
			// target : /io_test/20240926/노래가사.txt
			// copy   : /io_test/20240926/노래가사_copy.txt
			
			StringBuilder sb = new StringBuilder();
			sb.append(target);					// sb : /io_test/20240926/노래가사.txt
			
			// int String.lastIndexOf("문자열")
			// -> String 뒤에서부터 검색하여 "문자열"과 일치하는 부분의 인덱스를 반환
			// -> 일치하는 부분 없으면 -1을 반환
			
			int insertPoint = target.lastIndexOf(".");
			sb.insert(insertPoint, "_copy");	// sb : /io_test/20240926/노래가사_copy.txt
			String copy = sb.toString();		// 복사할 파일의 경로를 String 형으로 변환
			
			// 출력용 스트림 생성
			fos = new FileOutputStream(copy);		// 출력용 기반 스트림 생성
			bos = new BufferedOutputStream(fos);	// 출력용 보조 스트림 생성
			
			// 읽어왔던 내용(bytes)을 bos 를 이용해서 출력
			bos.write(bytes);
			bos.flush();						// 스트림에 남아있는 데이터 모두 밀어내기
			System.out.println("복사 완료 : " + copy);
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {	// 사용한 스트림 메모리 모두 반환
				if(br != null) br.close();
				if(bis != null) bis.close();	// bis 가 close 되면 fis 도 close 됨
				if(bos != null) bos.close();	// bos 가 close 되면 fos 도 close 됨
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
