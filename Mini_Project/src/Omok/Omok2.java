package Omok;

import java.util.Scanner;

public class Omok2 {
    public static void main(String[] args) {
        Player user = new Player("사용자", "O");
        Player computer = new Player("컴퓨터", "X");
        Board board = new Board(19);
        play(board, user, computer);
    }

    private static void play(Board board, Player user, Player computer) {
        Scanner scanner = new Scanner(System.in);

        boolean gameOver = false;

        while (!gameOver) {
            board.print();
            System.out.println();
            if (userTurn(board, user, scanner)) {
                gameOver = true;
                break;
            }
            
            board.print();
            System.out.println();
            if (userTurn(board, computer, scanner)) {
                gameOver = true;
                break;
            }
        }

        scanner.close();
    }

    private static boolean userTurn(Board board, Player player, Scanner scanner) {
        System.out.println(player.name + " 차례입니다.");
        System.out.print("행 입력 (1-19, 게임 종료: -1): ");
        String colInput = scanner.next().toUpperCase();
        
                if (colInput.equals("-1")) {
                    System.out.println("게임을 종료합니다.");
                    return true;
                }
        


        System.out.print("열 입력 (A-S, 게임 종료: -1): ");
        int row = scanner.nextInt();
        
                if (row == -1) {
                    System.out.println("게임을 종료합니다.");
                    return true;
                }


        int col = convertColInput(colInput);

        if (row < 1 || row > 19 || col < 0 || col >= 19) {
            System.out.println("올바른 행과 열을 입력하세요.");
            return false;
        }

        if (board.placeStone(row - 1, col, player.stone)) {
            if (checkWin(board, row - 1, col, player.stone)) {
                board.print();
                System.out.println();
                System.out.println(player.name + " 승리!");
                return true;
            }
        } else {
            System.out.println("해당 위치에 돌을 놓을 수 없습니다. 다시 시도하세요.");
        }

        return false;
    }

    private static int convertColInput(String colInput) {
        // 알파벳 열 입력을 숫자로 변환하는 함수
        char colChar = colInput.charAt(0);
        if (colChar >= 'A' && colChar <= 'S') {
            return colChar - 'A';
        } else {
            return -1; // 잘못된 입력일 경우 -1 반환
        }
    }

    private static boolean checkWin(Board board, int row, int col, String stone) {
        int size = board.size;
        int count;

        // 가로 방향 검사
        count = 0;
        for (int c = col - 4; c <= col; c++) {
            if (c >= 0 && c < size && board.map[row][c].equals(stone)) {
                count++;
            } else {
                count = 0;
            }
            if (count == 5) {
                return true;
            }
        }

        // 세로 방향 검사
        count = 0;
        for (int r = row - 4; r <= row; r++) {
            if (r >= 0 && r < size && board.map[r][col].equals(stone)) {
                count++;
            } else {
                count = 0;
            }
            if (count == 5) {
                return true;
            }
        }

        // 대각선 방향 (왼쪽 상단에서 오른쪽 하단)
        count = 0;
        for (int r = row - 4, c = col - 4; r <= row && c <= col; r++, c++) {
            if (r >= 0 && r < size && c >= 0 && c < size && board.map[r][c].equals(stone)) {
                count++;
            } else {
                count = 0;
            }
            if (count == 5) {
                return true;
            }
        }

        // 대각선 방향 (왼쪽 하단에서 오른쪽 상단)
        count = 0;
        for (int r = row + 4, c = col - 4; r >= row && c <= col; r--, c++) {
            if (r >= 0 && r < size && c >= 0 && c < size && board.map[r][c].equals(stone)) {
                count++;
            } else {
                count = 0;
            }
            if (count == 5) {
                return true;
            }
        }

        return false;
    }
}