package OmokGame;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		RankingView rankingView = new RankingView(); // RankingView 객체 생성
		
		GameView gameView = new GameView();		// (GameView 클래스로 넘어감) 
												// GameView 디폴트 생성자를 만들어주고 GameView 클래스로 넘어가서 
												// 오몬판의 크기를 정해준다. 
		
		boolean menuling = true;
		
		while(menuling) {
			System.out.println("====== 오목 프로그램 ======");
			System.out.println("1.게임하기 2.순위보기 3.종료하기");
			System.out.print(">");
			
			Scanner sc = new Scanner(System.in);
			int q = sc.nextInt();
			
			switch(q)
				{
					case 1:
						gameView.print(); 
						break;
		
					case 2:
						rankingView.print();   
						break;
						
					case 3:
						System.out.println("게임을 종료합니다.");
						menuling = false;
						break;
				}
	}	
  }
}
