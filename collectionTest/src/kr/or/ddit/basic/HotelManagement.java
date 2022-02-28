package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HotelManagement {
	private Scanner scan = new Scanner(System.in);
	private HashMap<Integer, Room> roomList = new HashMap<Integer, Room>();
	
	public static void main(String[] args) {
		new HotelManagement().start();
	}

	private void start() {
		initRoom();
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시오.");
		System.out.println("*********************************************\n\n");
		while(true) {
			int choice = displayMenu();
			scan.nextLine();
			switch (choice) {
			case 1:  //체크인
				checkIn();
				break;
			case 2:  //체크아웃
				checkOut();
				break;
			case 3: //객실상태
				status();
				break;
			case 4:  //업무종료
				System.out.println("*********************************************");
				System.out.println("       호텔문을 닫았습니다.");
				System.out.println("*********************************************");
				return;

			default:
				System.out.println("번호를 잘못 선택했습니다.");
				break;
			}
		}
		
	}


	private void initRoom() {
		for(int i = 2; i <= 4; i++) {
			for(int j = 1; j < 10; j++) {
				int num = i * 100 + j;
				String type = i == 2 ? "싱글룸" : i == 3 ? "더블룸" : "스위트룸" ;
				String name = "-";
				roomList.put(num, new Room(num, type, name));
			}
		}
	}
	
	private int displayMenu() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택 >> ");
		int input = scan.nextInt();
		
		return input;
		
	}
	

	private void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		int roomNum = scan.nextInt();
		if(!roomList.containsKey(roomNum)) {
			System.out.println(roomNum + "객실은 존재하지 않습니다.");
			return;
		}else if(!roomList.get(roomNum).getName().equals("-")) {
			System.out.println(roomNum+"호 객실은 이미 손님이 있습니다.");
			return;
		}
		System.out.print("이름 입력>>");
		String name = scan.nextLine();
		
		roomList.put(roomNum, new Room(roomNum, roomList.get(roomNum).getType(), name));
		System.out.println("체크인이 완료되었습니다.");
	}
	
	private void checkOut() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방번호 입력 >> ");
		int roomNum = scan.nextInt();
		if(!roomList.containsKey(roomNum)) {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
			return;
		}else if(roomList.get(roomNum).getName().equals("-")) {
			System.out.println(roomNum + "호 객실에는 체크인 한 사람이 없습니다.");
			return;
		}
		System.out.println(roomNum +"호 객실의 " + roomList.get(roomNum).getName() + "님의 체크아웃을 완료하였습니다.");
		roomList.put(roomNum, new Room(roomNum, roomList.get(roomNum).getType(), "-"));
	
	}
	
	private void status() {
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	 방 종류	 투숙객 이름");
		System.out.println("----------------------------------------------");
		Set<Integer> keySet = roomList.keySet();
		for(Integer key : keySet) {
			Room room = roomList.get(key);
			System.out.println(room.getNum() + "	 " + room.getType() + " 	  " + room.getName());
		}
		System.out.println("----------------------------------------------");
	}

}

class Room{
	private int num;
	private String type;
	private String name;
	public Room(int num, String type, String name) {
		this.num = num;
		this.type = type;
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}