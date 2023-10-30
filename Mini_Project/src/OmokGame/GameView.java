package OmokGame;

import java.util.Scanner;

public class GameView 

{
	private OmokBoard board;
	private StatusBar statusBar;
	private GameMenu menu;
	private Omok omok;

	public GameView() 
	{
		System.out.println("오목판 크기를 정해주세요");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		board = new OmokBoard(x,y); 		 // 위에서 예를 들면  x에 15, y에 15를 입력했다면 OmokBoard(x,y)의 매개변수에
											// 값을 넣고 전달하여 15x15 크기의 보드판을 만든다
		statusBar = new StatusBar();
		menu = new GameMenu();
	}

	public void print()
	{

		board.print();  					// OmokBoard 클래스의 print() 메소드 호출  오목판을 불러옴.
		statusBar.print(); 					// StatusBar 클래스의 print() 메소드 호출  "turn : black"
		menu.print();						// GameMenu 클래스의 print() 메소드 호출   "1)오목두기 2)중도포기 3)도움말\n"
		
		boolean gaming = true;
		while(gaming){
			
			switch(menu.input())   
			{

			case 1:  		
				omok = new Omok();
				omok.input(); 					// 'omok' 이라는 객체에 x, y 입력값을 넣는다
				board.put(omok); 				//board 클래스의 put() 메소드에 omok을 매개변수로 삽입
				// statusBar.print();
				menu.print();					// 1)오목두기 2)중도포기 3)도움말 출력하고  다시 switch(menu.input())  문으로 돌아간다
				
				if(board.checkWin()) {    		// 만약 게임에서 이기면 실행하는 if문이다.
					board.print();				// 업데이트 된 오목판 출력
					System.out.println("게임 종료. " + board.getWinner() +"승리!");
					gaming = false;
				}
				break;

			case 2:
				break;

			case 3:
				
				break;

			default :

			}
		}
	}
}


