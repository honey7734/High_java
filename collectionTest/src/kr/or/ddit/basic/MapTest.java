package kr.or.ddit.basic;

import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
	/*
		Map ==> key값과 value값을 한 쌍으로 관리하는 객체
			 - key값은 중복을 허용하지 않고 순서가 없다.(Set의 특징)
			 - value 값은 중복을 허용한다.
	 */
		HashMap<String, String> map = new HashMap<String, String>();
		
		// 자료 추가하기 : put(key값, value값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map => " + map);
		System.out.println();
		
		// 자료 수정하기 ==> 데이터를 추가할 때 key값이 같으면 나중에 추가한 값이 저장된다. 
		map.put("addr", "서울");
		System.out.println("map => " + map);
		System.out.println();
		
		// 자료 삭제하기
		// remove(key값) ==> 'key값'이 같은 자료를 찾아서 삭제한다.
		//      반환값 ==> 삭제한 자료의 value값이 반환된다.
//		String delTel = map.remove("tel");
//		System.out.println("map => " + map);
//		System.out.println("삭제된 value값 : " + delTel);
//		System.out.println();
		
		// 자료 읽기 ==> get(key값)
		// get(key값) ==> 'key'값에 맞는 데이터를 찾아 value값을 반환한다.
		System.out.println("이름 : " + map.get("name"));
	}

}
