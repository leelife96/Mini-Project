package Chuseok;

import java.util.Scanner;

public class No3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] vertexs = new int[3][2];
		
		for(int i = 0; i<3; i++) {
			for(int j =0; j<2; j++) {
				vertexs[i][j] = sc.nextInt();
			}
		}
		System.out.printf("%.2f",TriArea(vertexs));

	}
	
	public static double TriArea(int[][] vertexs) {
		
		
//		1/2 |(x1y2 + x2y3 + x3y1) - (x2y1 + x3y2 + x1y3)|
		int[][] A = vertexs;
		int[][] B = vertexs;
		int[][] C = vertexs;
		
		int x1 = A[0][0], y1 = A[0][1];
		int x2 = B[1][0], y2 = B[1][1];
		int x3 = C[2][0], y3 = C[2][1];
		
		int width = ( (x1*y2)+(x2*y3)+(x3*y1) - (x2*y1)+(x3*y2)+(x1*y3) );
		double result = Math.abs(width) / 2.0;
		
		return result;
		
	}

}
