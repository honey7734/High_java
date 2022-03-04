package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
	
	컴퓨터와 가위 바위 보는 난수를 이용해서 구하고, 
	사용자의 가위 바위 보는 showInputDialog()를 이용해서 입력 받는다.
	
	입력 시간은 5초로 제안하고 카운트 다운을 진행한다.
 	5초 안에 입력이 없으면 게임에 진것으로 처리한다.
 	
 	5초 안에 입력이 있으면 승패를 구해서 출력한다.
 	
 	결과 예시) 
 	1) 5초 안에 입력이 없을 때
 	- 결 과 -
 	시간 초과로 당신이 졌습니다.
 	
    2) 5초 안에 입력이 있을 때
    - 결 과 -
    컴퓨터 : 가위
    당 신 : 바위
    결 과 : 당신이 이겼습니다.
 */
public class ThreadTest07 {
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		Count th = new Count();
		
		// 난수를 이용해서 컴퓨터의 가위 바위 보 정하기
		String[] data = {"가위","바위","보"};
		int index = (int)Math.random() * 3;  // 0~2사이의 난수만들
		String computer = data[index];
		
		th.start(); // 카운트 다운 시작...
		
		
		String player = null;
		do {
			player = JOptionPane.showInputDialog("가위, 바위, 보를 입력 하세요");
		}while(!(player.equals("가위") || player.equals("바위") || player.equals("보")));
//	    }while(!player.equals("가위") && !player.equals("바위") && !player.equals("보"));
		
		inputCheck = true;
		
		// 결과 판정하기
		String result = "";
		if(computer.equals(player)) {
			result = "비겼습니다.";
		}else if(computer.equals("가위") && player.equals("보") 
			  || computer.equals("바위") && player.equals("가위")
			  || computer.equals("보") && player.equals("바위")) {
			result = "당신이 졌습니다";
		}else {
			result = "당신이 이겼습니다.";
		}
		
		// 결과 출력하기
		System.out.println("   - 결 과 -");
		System.out.println("컴퓨터 : " + computer);
		System.out.println("당 신 : " + player);
		System.out.println  ("결 과 : " + result);

	}

}
class Count extends Thread{
	@Override
	public void run() {
		System.out.println("카운트다운을 시작합니다...");
		for(int i = 5; i >= 1; i--) {
			if(ThreadTest07.inputCheck) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}

		}
		System.out.println("- 결 과 -");
		System.out.println("시간초과로 당신이 졌습니다.");
		System.exit(0);
	}
}
