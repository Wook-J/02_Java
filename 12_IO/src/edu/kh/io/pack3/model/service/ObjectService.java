package edu.kh.io.pack3.model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.kh.io.pack3.model.dto.Member;

public class ObjectService {

	/* ObjectInputStream / ObjectOutputStream
	 * 
	 * - Java 객체를 입/출력 할 때 사용하는 바이트 기반 "보조" 스트림
	 *   (보조스트림이므로 단독으로 사용 불가능!)
	 * 
	 *   **** 직렬화(Serializable) ****
	 *   - 객체를 직렬(직선)형태로 변환
	 *   - 직렬화란 객체의 상태(필드 값들)를 바이트 스트림으로 변환하는 과정
	 *  
	 *   -> 객체는 메모리에서만 존재하는 것이 아니라, 파일로 저장되거나 
	 *      네트워크를 통해 전송될 수 있음
	 *      
	 *   - 역직렬화는 바이트 스트림을 다시 객체로 복완하는 과정
	 *     즉, 저장하거나 전송된 데이터를 원래의 객체형태로 되돌리는 작업
	 *   ******************************
	 * */
	
	/**
	 * 객체를 외부 파일로 출력
	 * (내부 -> 외부) 직렬화 필요! 
	 */
	public void objectOutput() {
		
		// 스트림 참조변수 선언
		FileOutputStream fos = null;		// 파일 출력용 기반 스트림
		ObjectOutputStream oos = null;		// 객체 출력용 보조 스트림
		
		try {
			
			// .dat 확장자 : data 를 담고 있는 파일을 나타내는 확장자
			fos = new FileOutputStream("/io_test/20240926/Member.dat");
			oos = new ObjectOutputStream(fos);
			
			// Member 객체 하나 생성
			Member member = new Member("member01", "pass01", "김회원", 30);
			
			// ObjectOutputStream 을 이용하여 Member 객체 출력하기
			oos.writeObject(member);		// member 객체 출력
			
			System.out.println("회원 출력 완료!");
			// [직렬화가 되지 않음]
			// java.io.NotSerializableException: edu.kh.io.pack3.model.dto.Member

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {		// 예외가 발생하든 안하든 무조건 수행되는 부분
			try {
				if(oos != null) oos.close();	// 기반 스트림인 fos 도 함께 닫힘
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 외부 파일로부터 객체 입력 받기
	 * (외부 -> 내부) 역직렬화 필요! 
	 */
	public void objectInput() {
		
		// 스트림 참조변수 선언
		FileInputStream fis = null;			// 파일 입력용 기반 스트림
		ObjectInputStream ois = null;		// 객체 입력용 보조 스트림
		
		try {
			
			fis = new FileInputStream("/io_test/20240926/Member.dat");
			ois = new ObjectInputStream(fis);
			
			// 스트림을 이용해 파일에 작성된 직렬화된 Member 객체를 읽어와
			// 역직렬화를 수행하여 정상적인 Member 객체로 변경
			
			// Object ois.readObject() : 직렬화된 객체를 읽어와 역직렬화
			// + Member 객체로 변경하려면 다운캐스팅 필요!
			Member member = (Member) ois.readObject();
			
			// 읽어온 내용 확인
			System.out.println(member);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try {
				if(ois != null) ois.close();	// 기반 스트림인 fis 도 함께 닫힘
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
