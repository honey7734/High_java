package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// Collection들은 자바의 객체만 저장할 수 있다
		
		// 객체 생성
		Vector v1 = new Vector();
		
		System.out.println("처음 크기 : " + v1.size() );
		
		// 데이터 추가하기 : add(추가할 데이터)
		// 반환값 : 성공(true), 실패(false)
		v1.add("aaaa");
		v1.add(new Integer(123));    //예전엔 숫자를 객체화 시켜서 저장해야했었다 -> 레퍼클래스로 변환
		v1.add(111);  // 오토박싱   <==> 오토 언박싱
		v1.add('a');
		v1.add(true);
		
		boolean r = v1.add(3.14);
		
		System.out.println("현재 크기 : " + v1.size());
		System.out.println("반환 값 : " + r);
		
		// 데이터 추가하기2 : addElement(추가할데이터)
		//  ==> 이전 버전에서부터 지원하는 메서드
		//      이전 버전의 프로그램도 사용할 수 있도록 하기 위해서 남아있는 메서드
		
		v1.addElement("CCCC");

		System.out.println("v1 => " + v1);
		
		// 데이터 추가하기2 : add(index, 데이터)
		//  ==> 'index'번째에 '데이터'를 끼워 넣는다.
		//  ==> 'index'는 0부터 시작한다.
		//  ==> 반환값이 없다.
		v1.add(1,"KKKK");
		System.out.println("v1 => " + v1);
		System.out.println();
		
		
		// 데이터 꺼내오기 : get(index)
		// ==> 'index'번째의 데이터를 꺼내와 반환한다.
		String temp = (String) v1.get(0);    //자식(String)의 데이터를 부모(Object)에 저장하는 것은 자동으로 형변환 되지만 반대의 경우 직접 형변환(casting)을 써주어야한다
		System.out.println("꺼내온 값 : " + temp);
		int i = (int) v1.get(2); // 오토 언박싱   (Integer)를 써도 된다
		System.out.println("꺼내온 값 : " + i);
		System.out.println();
		
		// 데이터 수정하기 : set(index, 새로운데이터)
		//  ==> 'index'번째의 데이터를 '새로운데이터'로 덮어쓴다.
		//  ==> 반환값 : 원래의 데이터
		String temp2 = (String) v1.set(0, "ZZZZ");
		System.out.println("v1 => " + v1);
		System.out.println("temp2 => " + temp2);
		System.out.println();
		
		// 데이터 삭제하기 : remove(index)
		//  ==> 'index'번째의 자료를 삭제한다.
		//  ==> 반환값 : 삭제된 데이터
		String temp3 = (String) v1.remove(0);
		System.out.println("삭제후 v1 => " + v1);
		System.out.println("삭제된 데이터 : " + temp3);
		System.out.println();
		
		// 데이터 삭제하기2 : remove(삭제할데이터)
		//  ==> '삭제할데이터'를 찾아서 삭제한다.
		//  ==> '삭제할데이터'가 여러개이면 앞에서부터 삭제된다.
		//  ==> 반환값 : 삭제성공(true), 삭제실패(false)
		v1.remove("CCCC");
		System.out.println("삭제후 v1 => " + v1);
		
		//v1.remove(123); // 123이 index로 인식되어 처리된다.
		v1.remove(new Integer(123));
		System.out.println("삭제후 v1 => " + v1);
		System.out.println();
	}

}
