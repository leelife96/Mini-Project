package OmokGame;

import java.util.Scanner;

public class Omok {
	private int x;
	private int y;
	private int type;
	
	public void input() {
		System.out.println("(x,y)를 입력해주세요.");
		Scanner sc = new Scanner(System.in);
		this.x = sc.nextInt();
		this.y = sc.nextInt();
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
