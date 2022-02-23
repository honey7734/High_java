package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	문제1) 5명 별명을 입력받아 ArrayList에 저장하고
 	    이 별명 중에 제일 긴 별병을 출력하시오
 	    (단, 별명의 길이는 모두 다르게 입력한다.)
 	    
 */
public class ArrayListTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.print("별명 입력 > ");
			nameList.add(sc.nextLine());
		}

		int max = 0;
		for(int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).length() > max ) max = i;
		}
		
		System.out.println("제일 긴 별명 : " + nameList.get(max));
	
	//선생님 답안
		//제일 긴 별명이 저장될 변수 선언
		//    ==> List의 첫번째 자료로 초기화 한다.
		String maxAlias = nameList.get(0);
		
		for(int i = 1 ; i < nameList.size(); i++) {
			if(maxAlias.length() < nameList.get(i).length()) maxAlias = nameList.get(i); 
		}
		
		System.out.println(maxAlias);
	
	
	}
	
	

}
