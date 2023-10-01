package Chuseok;

import java.util.Scanner;

public class No4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] vertexs = new int[4][2];
		
		for(int i = 0; i<4; i++) {
			for(int j =0; j<2; j++) {
				vertexs[i][j] = sc.nextInt();
			}
		}
		
		System.out.printf("%.2f",TriArea(vertexs));

	}

	private static Object TriArea(int[][] vertexs) {
		int[][] A = vertexs;
		int[][] B = vertexs;
		int[][] C = vertexs;
		int[][] D = vertexs;
		
		int x1 = A[0][0], y1 = A[0][1];
		int x2 = B[1][0], y2 = B[1][1];
		int x3 = C[2][0], y3 = C[2][1];
		int x4 = D[3][0], y4 = C[3][1];
		
		int width1 = ( (x1*y2)+(x2*y3)+(x3*y1) - (x2*y1)+(x3*y2)+(x1*y3) );
		int width2 = ( (x2*y3)+(x3*y4)+(x4*y2) - (x3*y2)+(x4*y3)+(x2*y4) );
		int sum = width1 + width2;
		double result = Math.abs(sum) / 2.0;
		
		return result;
	}

	

}
