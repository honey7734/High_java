package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;

/*
 	10마리의 말들이 경주하는 경마 프로그램 작성하기
 	
 	말은 Horse라는 이름의 쓰레드 클래스로 작성하는데
 	이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
 	그리고, 이 클래스는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다.
 	(Compare인터페이스 구현)
 	
 	경기 구간은 1 ~ 50구간으로 되어있다.
 	
 	경기가 끝나면 등수 순으로 출력한다.
 	
 	경기가 진행 중일때는 중간 중간에 말들의 취피를 아래와 같이 나타낸다.
 	
 	예)
 	01번말 : --->--------------------------------- 
 	02번말 : ------->----------------------------- 
 	...
 	10번말 : ---->-------------------------------- 
 	
 */
public class ThreadTest13 {
	public static ArrayList<String> finish = new ArrayList<String>();
	public static ArrayList<Horse> horses = new ArrayList<Horse>();
	
	public static void main(String[] args) {
		PrintGame pg = new PrintGame();
		pg.setDaemon(true);
		
		for(int i = 1; i <= 10; i++) {
			horses.add(new Horse(i+"번말"));
		}
		pg.start();
		
		for(Horse horse : horses) {
			horse.start();
		}
		
		
		for(Horse horse : horses) {
			try {
				horse.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
		
		Collections.sort(horses);
		System.out.println();
		System.out.println("경기결과");
		for(int i=0; i<horses.size(); i++) {
			System.out.println((i+1) + "등 : " + horses.get(i).gettingName());
		}

	}

}

class Horse extends Thread implements Comparable<Horse>{
	private String name;
	private int rank;
	private int num; //현재위치
	
	
	
	public Horse(String name) {
		this.name = name;
		this.rank = 1;
		this.num = 1;
	}
	

	@Override
	public void run() {
		for(num = 1; num <= 50; num++) {
			try {
				num++;
				Thread.sleep((int)(Math.random() * 300 + 201));
			} catch (InterruptedException e) {

			}
			
		}
		ThreadTest13.finish.add(name);
		rank = ThreadTest13.finish.size();
	}
	
	public String gettingName() {
		return name;
	}

	public int getRank() {
		return rank;
	}

	public int getNum() {
		return num;
	}


	@Override
	public int compareTo(Horse horse) {
		
		return ((Integer)this.rank).compareTo(horse.getRank());
	}

	
	
	
}

class PrintGame extends Thread{
	@Override
	public void run() {
		while(true) {
			
		for(int i = 0; i < ThreadTest13.horses.size(); i++) {
			System.out.print(ThreadTest13.horses.get(i).gettingName() + " : ");
			
			for(int j = 1; j <= 50; j++) {
				if(j==ThreadTest13.horses.get(i).getNum()) {
					System.out.print(">");
				}else {
					System.out.print("-");
				}
				
			}
			System.out.println();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		System.out.println("-------------------------------------------------------------");
		}
	}
}
