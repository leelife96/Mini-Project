package Omok;

class Board {
    int size;
    String[][] map;

    Board(int size) {
        this.size = size;
        map = new String[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                map[row][col] = ".";
            }
        }
    }


    public void print() {
        for (int row = 0; row < size; row++) {
        	
        	if (row<10) {
        		System.out.print(" "+row);
        	}
        	else
        		System.out.print(row);
        	
        	
            for (int col = 0; col < size; col++) {
                System.out.print(" " + map[row][col]);
            }
            System.out.println(); 
            
        }
        System.out.print("  ");
        for (int col=0; col<size; col++) {
        	char character = (char)(col + 65);
            System.out.print(" " + character);
        }
    }
    

    boolean placeStone(int row, int col, String stone) {
        if (map[row][col].equals(".")) {
            map[row][col] = stone;
            return true;
        } else {
            return false;
        }
    }
}