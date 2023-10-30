package OmokGame;

import java.util.Scanner;

public class GameMenu {
	
	public void print() {
		System.out.println("====== 선택 하세요 ======");
		System.out.println("1)오목두기 2)중도포기 3)도움말\n");
	}
	
	public int input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("선택:>");
		int q = sc.nextInt();
		return q;
	}
}
