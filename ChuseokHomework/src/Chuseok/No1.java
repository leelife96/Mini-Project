package Chuseok;

import java.util.Scanner;

public class No1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double fahren = sc.nextDouble();
		
		
		// (화씨온도 - 32) ÷ 1.8 = 섭씨온도
		System.out.printf("%.3f", ToCelcius(fahren));

	}

	
	public static double ToCelcius(double fahren) {
		double Celc = (fahren - 32) / 1.8;
		return Celc;
		
	}
}
