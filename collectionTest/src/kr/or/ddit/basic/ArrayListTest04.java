package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	문제2) 문제1에서 별명의 길이가 같은 것이 있을 경우를 처리하시오.
 */
public class ArrayListTest04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.print("별명 입력 > ");
			nameList.add(sc.nextLine());
		}
		
		ArrayList<Integer> max = new ArrayList<Integer>();
		int maxlength = nameList.get(0).length();
		
		for(int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).length() > maxlength) {
				if(max.size() != 1) {
					max.clear();
					max.add(i);
				}else {
					max.set(0,i);
				}
				maxlength = nameList.get(i).length() ;
				
			}else if(nameList.get(i).length() == maxlength) {
				max.add(i);
			}
		}
		
		for(int i = 0; i < max.size(); i++) {
			System.out.println(nameList.get(max.get(i)));
		}
		
	//선생님 답안
		//제일 긴 별명의 길이가 저장될 변수 선언
		//    ==> 첫번째 별명의 길이로 초기화
		int maxLength = nameList.get(0).length();
		
		for(int i = 1; i < nameList.size(); i++) {
			if(maxLength < nameList.get(i).length()) {
				maxLength = nameList.get(i).length();
			}
		}
		System.out.println("제일 긴 별명들");
		for(String alias : nameList) {
			if(maxLength == alias.length()) System.out.println(alias);
		}
		
		
	}
}
