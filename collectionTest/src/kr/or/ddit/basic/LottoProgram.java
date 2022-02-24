package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class LottoProgram {

	public static void main(String[] args) {
		while(true) {
			menu();
		}

	}
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==========================\n"
				         + "       Lotto 프로그램\n"
				         + "--------------------------\n"
				         + "      1. Lotto 구입\n"
				         + "      2. 프로그램 종료\n"
				         + "==========================");
		System.out.print("메뉴선택 : ");
		int input = sc.nextInt();
		
		switch (input) {
		case 1:
			lottoBuy();
			break;
		case 2:
			System.out.println("감사합니다");
			System.exit(0);

		}
	}
	
	public static void lottoBuy() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lotto 구입시작\n");
		
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액입력 : ");
		int pay = sc.nextInt();
		
		System.out.println();
		
		if(pay < 1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
		}else if(pay > 1000*100) {
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
		}else {
			List<HashSet<Integer>> lottoList = new ArrayList<HashSet<Integer>>();
			while (lottoList.size() < (int)pay/1000) {
				HashSet<Integer> num = new HashSet<Integer>();
				while (num.size() < 6) {
					int rnd = (int)(Math.random() * (45-1+1) + 1);
					num.add(rnd);
				}
				lottoList.add(num);
			}
			
			System.out.println("행운의 로또번호는 아래와 같습니다.");
			for(int i = 0; i < lottoList.size(); i++) {
				System.out.print("로또번호" + (i+1)+ " : ");
				for(Integer num : lottoList.get(i)) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("받은 금액은 " + pay + "이고 거스름돈은 " + (pay-((int)pay/1000)*1000) + "원입니다.");
		}
		
	}
}
