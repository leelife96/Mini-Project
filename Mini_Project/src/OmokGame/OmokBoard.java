package OmokGame;

public class OmokBoard {
	private char [][]buf;  
	private char [][]om;
	private int width;
	private int height;
	private int count;

	public OmokBoard(int width, int height) //생성자 - 초기값설정

	{

		count = 0;
		buf = new char[30][40];
		this.width = width;
		this.height = height;

		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++)
			{

				if(i==0 && j==0)
				{
					buf[i][j] = '┌';
				}

				else if (i ==height-1 && j==width-1)
				{
					buf[i][j] = '┘';
				}

				else if (i ==height-1 && j==0)
				{
					buf[i][j] = '└';
				}

				else if (i ==0&& j==width-1)
				{
					buf[i][j] = '┐';
				}

				else if (i ==0)
				{
					buf[i][j] = '┬';
				}

				else if (j==0)
				{
					buf[i][j] = '├';
				}

				else if (i==height-1)
				{
					buf[i][j] = '┴';
				}
				
				else if (j==width-1)
				{
					buf[i][j] = '┤';
				}
				
				else  
				buf[i][j] = '┼';
			}

		
	}

	public void print()
	{
		for(int i=0; i<height; i++)
		{
			for(int j=0; j<width; j++)
				System.out.printf("%c",  buf[i][j]);
			System.out.println();
		}
	}



	public void put(Omok omok) 
	{
		int x	=	omok.getX();   // omok 객체의 getX() 메소드를 통해 값을 가져와서 x에 대입
		int y	=	omok.getY();
		
		if(buf[x-1][y-1] =='○' || buf[x-1][y-1] == '●') // 이미 돌이 놓여 있는 경우, "다시놔주세요"를 출력. 
			System.out.println("다시놔주세요");				// buf[x-1][y-1]로 한 이유는 배열의 인덱스는 0부터 시작하기 때문

		else if(count%2 == 0)   // count가 짝수인 경우  '●'를 사용하는 플레이어의 차례이다.
		{
			this.buf[x-1][y-1] = '●';
			count++;
		}
		else
		{
			this.buf[x-1][y-1] = '○';
			count++;
		}
		this.print(); 			// 돌을 놓은 후, print() 메소드를 호출해서 업데이터 된 보드판을 보여준다
		}

	public boolean checkWin() {
	    char[] stonesToCheck = {'●', '○'}; 		// 검사해야 할 돌의 종류인 '흑돌' 과 '백돌'을 지정한다.
	    
	    for (char stone : stonesToCheck) {
	        if (checkWinForStone(stone)) {		// stonesToCheck 배열의 각 돌에 대해 승리 상태를 체크함. 
	            return true;					// 승리하면 true를 반환 
	        }
	    }
	    
	    return false;
	}

	private boolean checkWinForStone(char stone) {
	    for (int row = 0; row < height; row++) {			// 초기에 오목판의 넓이와 높이를 설정한 만큼의 수치까지 for문을 반복시킴
	        for (int col = 0; col < width; col++) {
	            if (buf[row][col] == stone) {    // 현재 검사 중인 셀이 지정한 돌과 일치하는지 확인
	               
	                if (checkDirection(row, col, 0, 1, stone, 1) ||		// 가로 방향 승리 확인. row와 col은 현재 위치를 나타냄. 
	                													// '0'과 '1'은 가로방향. stone은 확인하려는 돌의 종류. '1'은 승리조건 확인할때 시작돌을 1로 초기화
	                  
	                    checkDirection(row, col, 1, 0, stone, 1) ||		// 세로 방향 승리 확인
	                  
	                    checkDirection(row, col, 1, 1, stone, 1) ||		// 대각선 방향 (왼쪽 위에서 오른쪽 아래로) 승리 확인
	                  
	                    checkDirection(row, col, 1, -1, stone, 1)) {	// 대각선 방향 (오른쪽 위에서 왼쪽 아래로) 승리 확인
	                	
	                    return true;				// 만약 어느 한 방향으로라도 승리 조건이 만족된다면 true 반환
	                }
	            }
	        }
	    }
	    return false;
	}

	private boolean checkDirection(int row, int col, int deltaRow, int deltaCol, char stone, int count) {    // 다섯 가지 방향(가로, 세로, 대각선 두 가지)으로 승리 여부를 확인
	    if (count == 5) {  		// 현재 방향에서 돌이 5개 연속으로 나타난 경우 승리 조건을 만족하고 true 반환 
	        return true;
	    }
	    int newRow = row + deltaRow;	// 현재 위치에서 주어진 방향으로 한 칸 이동한 새로운 위치를 계산. deta는 현재 위치에서 어떤 방향으로 이동할지를 나타내는 벡터
	    int newCol = col + deltaCol;

	    if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width && buf[newRow][newCol] == stone) {    // 새로운 위치가 게임 보드 내부에 있고, 그 위치의 돌이 주어진 돌과 같은지를 확인
	    																										  // newRow >= 0 && newRow < height && newCol >= 0 && newCol < width 이 코드는 윗,아래,오른,왼쪽 테두리 범위를 벗어나는지를 체크
	        return checkDirection(newRow, newCol, deltaRow, deltaCol, stone, count + 1);  // 위의 조건이 참이라면 checkDirection 메소드를 재귀적으로 호출하여 같은 방향으로 다음 위치 검사하고 count+1 해줌
	    }

	    return false;  
	}

	public String getWinner() {
	    char[] stonesToCheck = {'●', '○'};
	    
	    for (char stone : stonesToCheck) {
	        if (checkWinForStone(stone)) {
	            return (stone == '●') ? "흑돌 승리!" : "백돌 승리!";
	        }
	    }

	    return "무승부"; 
	}

	
	
}
