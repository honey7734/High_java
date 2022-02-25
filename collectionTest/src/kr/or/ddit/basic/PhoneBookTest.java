package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 	문제) 이름, 주소, 전화번호를 멤버로 찾는 Phone클래스를 만들고,
 	    Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 	    
 	    전화번호 정보는 Map에 저장하여 관리한다.
 	    (key값은 입력받은 사람의 '이름'으로 하고, value값은 'Phone 클래스의 인스턴스'로 한다.)
 	    
 	    아래 메뉴의 기능을 모두 작성하시오.
 	    (삭제, 검색 기능은 '이름'을 입력 받아 처리한다.)
 	    
 		메뉴 예시)
 		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
	-----------------------------
	실행예시)
		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
		--------------------
		번호입력 >> 1
		
		새롭게 등록할 전화번호 정보를 입력하세요.
		이름 >> 홍길동
		전화번호 >> 010-1111-1111
		주소 >> 대전시 중구 오류동
		
		'홍길동'전화번호 정보 등록 완료!!
		
		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
		--------------------
		번호입력 >> 1
		
		새롭게 등록할 전화번호 정보를 입력하세요.
		이름 >> 홍길동
		
		'홍길동'은 이미 등록된 사람입니다.
		
		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
		--------------------
		번호입력 >> 5
		
		-----------------------------------------
		번호    이 름    전 화 번 호      주    소
		-----------------------------------------
		 1     홍길동  010-1111-1111 대전시 중구 오류동
		 ~~~
		 ~~~
		-----------------------------------------
		 출력 완료...
		 
		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
		--------------------
		번호입력 >> 0
		
		프로그램을 종료합니다.
		
*/
public class PhoneBookTest {
	private Scanner scan = new Scanner(System.in);
	private HashMap<String, Phone> phoneBook = new HashMap<String, Phone>();
	
	
	public static void main(String[] args) {
		new PhoneBookTest().start();

	}

	private void start() {
		while(true) {
			int choice = displayMenu();
			
			switch(choice){
			case 1: // 등록
				inputPhone();
				break;
			case 2: // 수정
				updatePhone();
				break;
			case 3: // 삭제
				deletePhone();
				break;
			case 4: // 검색
				reshearchPhone();
				break;
			case 5:
				printAll();
				break;
			case 0:
				System.out.println();
				System.out.println("프로그램을 종료합니다.");
				return;
			default : 
				System.out.println("번호를 선택했습니다.");
			}
		}
	}
	



	
	private int displayMenu() {
		System.out.println("1. 전화번호 등록\n"
				         + "2. 전화번호 수정\n"
				         + "3. 전화번호 삭제\n"
				         + "4. 전화번호 검색\n"
				         + "5. 전화번호 전체 출력\n"
				         + "0. 프로그램 종료");
		System.out.print("번호입력 >> ");
		int num = scan.nextInt();
		return num;
	}

	private void inputPhone() {
		scan.nextLine();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.nextLine();
		
		if(phoneBook.containsKey(name)) {
			System.out.println("'" + name + "'은 이미 등록된 사람입니다.");
			return;
		}
		System.out.print("전화번호 >> ");
		String tel = scan.nextLine();
		System.out.print("주소 >> ");
		String addr = scan.nextLine();
		
		phoneBook.put(name, new Phone(name, tel, addr));
		System.out.println("'" + name + "'전화번호 정보 등록 완료!!");
		
	}

	private void updatePhone() {
		scan.nextLine();
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.nextLine();
		if(!phoneBook.containsKey(name)) {
			System.out.println("등록되지 않은 사람입니다.");
			return;
		}
		System.out.print("전화번호 >> ");
		String tel = scan.nextLine();
		
		System.out.print("주소 >> ");
		String addr = scan.nextLine();
		
		phoneBook.put(name, new Phone(name, tel, addr));
		System.out.println("'" + name + "'전화번호 정보 수정 완료!!");
		
	}
	
	private void deletePhone() {
		scan.nextLine();
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.nextLine();
		if(!phoneBook.containsKey(name)) {
			System.out.println("등록되지 않은 사람입니다.");
			return;
		}
		phoneBook.remove(name);
		System.out.println("'" + name + "'전화번호 정보 삭제 완료!!");
	}
	
	private void reshearchPhone() {
		scan.nextLine();
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.nextLine();
		if(!phoneBook.containsKey(name)) {
			System.out.println("등록되지 않은 사람입니다.");
			return;
		}
		System.out.println("-----------------------------------");
		System.out.println("이 름    전 화 번 호      주    소");
		System.out.println("-----------------------------------");
		System.out.println(phoneBook.get(name).toString());
		System.out.println("-----------------------------------");
		System.out.println("검색 완료...");
		
	}
	
	private void printAll() {
		int num = 1;
		System.out.println("-----------------------------------------");
		System.out.println("번호    이 름    전 화 번 호      주    소");
		System.out.println("-----------------------------------------");
		for(Phone phone : phoneBook.values()) {
			System.out.println(" "+ num + "     " + phone.toString());
			num++;
		}
		System.out.println("-----------------------------------------");
		System.out.println("출력 완료...");
	}
}

class Phone{
	private String name;
	private String tel;
	private String addr;
	
	public Phone(String name, String tel, String addr) {
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}


	@Override
	public String toString() {
		return  name + "  " + tel + " " + addr ;
	}
	
	
}
