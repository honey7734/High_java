package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*
 	문제) Set을 활용하여 숫자 야구 게임 프로그램을 작성하시오.
 	    컴퓨터의 숫자는 난수를 이용해서 구한다.
 	    (스트라이크는 S, 볼은 B로 나타낸다.)
 	    
    예시) 
    	컴퓨터 난수 ==> 9 5 7
    실행예시)
    숫자입력 : 3 5 6
    3 5 6 => 1S 0B
    
    숫자입력 : 7 8 9
    7 8 9 => 0S 2B
    
    숫자입력 : 9 7 5
    9 7 5 => 1S 2B
    
    숫자입력 : 9 5 7
    9 5 7 => 3S 0B
    
    축하합니다...
    당신은 4번째만에 맞췄습니다.
 */
public class BaseballTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> num = new HashSet<Integer>();
		while (num.size() < 3) {
			int rnd = (int)(Math.random() * (9-1+1) + 1);
			num.add(rnd);
		}

		ArrayList<Integer> numList = new ArrayList<Integer>(num);
		
		Collections.shuffle(numList);
		System.out.println(numList);
		
		int s;
		int b;
		int count = 0;
		
		do {
			s = 0;
			b = 0;
			count++;
			
			System.out.print("숫자 입력 > ");
			int i1 = Integer.parseInt(sc.next());
			int i2 = Integer.parseInt(sc.next());
			int i3 = Integer.parseInt(sc.next());
			
			if(i1 == numList.get(0)) s++;
			if(i2 == numList.get(1)) s++;
			if(i3 == numList.get(2)) s++;
			
			if(i1 == numList.get(1)||i1 == numList.get(2)) b++;
			if(i2 == numList.get(0)||i1 == numList.get(2)) b++;
			if(i3 == numList.get(0)||i3 == numList.get(1)) b++;
			
			
			System.out.println(i1 + " " + i2 + " " + i3 + " => " + s + "S " + b + "B");
		}while(s != 3);
		
		System.out.println("축하합니다...");
		System.out.println("당신은 " + count +"번째만에 맞췄습니다");
		
	}

}
