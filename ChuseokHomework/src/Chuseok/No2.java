package Chuseok;

import java.util.Scanner;

public class No2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double Celc = sc.nextDouble();
		
		
		// (섭씨온도 × 1.8) + 32 = 화씨온도
		System.out.printf("%.1f", ToFahren(Celc));

	}

	
	public static double ToFahren(double Celc) {
		double Fahren = (Celc * 1.8) + 32;
		return Fahren;
		
	}
}
