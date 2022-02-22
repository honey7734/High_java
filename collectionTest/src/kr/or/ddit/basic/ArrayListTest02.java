package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	문제) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후 이들 중 '김'씨 성의 이름을 모두 출력하시오.
 	    (입력은 Scanner객체를 이용한다.)
 */

public class ArrayListTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.print("이름 입력 > ");
			nameList.add(sc.nextLine());
		}
		System.out.println(nameList);
		//방법1
		for(int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).charAt(0) == '김') System.out.println(nameList.get(i));
		}
		//방법2
		for(int i = 0; i < nameList.size(); i++) {
			char[] nameChar = nameList.get(i).toCharArray();
			if(nameChar[0] == '김') System.out.println(nameList.get(i));
		}
		//방법3
		for(int i = 0; i < nameList.size(); i++) {
			ArrayList<Character> nameChar = new ArrayList<Character>();
			for(int j = 0; j < nameList.get(i).length(); j++) nameChar.add(nameList.get(i).toCharArray()[j]);
			if(nameChar.get(0) == '김') System.out.println(nameList.get(i));
			//if(nameChar.contains('김') && nameChar.get(0) == '김') System.out.println(nameList.get(i));
		}
		//방법4
		for(int i = 0; i < nameList.size(); i++) {
			ArrayList<Character> nameChar = new ArrayList<Character>();
			for(int j = 0; j < nameList.get(i).length(); j++) nameChar.add(nameList.get(i).toCharArray()[j]);
			if(nameChar.indexOf('김') == 0 ) System.out.println(nameList.get(i));
		}
		
	}

}
