package Chuseok;

import java.util.Scanner;

public class No5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] order = new int[5];
		
		for(int i=0; i<order.length; i++) {
			order[i] = sc.nextInt();
		}
		
//		Bubble(order);	
		Selection(order);
		for(int i : order) {
			System.out.print(i+ " ");
		}
		
		

	}
	
	private static void Selection(int[] order) {
		for(int i=0; i<order.length - 1; i++) {
			int min = i;
			for(int j=i+1; j<order.length; j++) {
				if(order[min]>order[j]) {
					min = j;
				}
			}
			int temp = order[min];
			order[min] = order[i];
			order[i] = temp;
		}
		
	}

	public static void Bubble(int[] order) {
		for(int i=0; i<order.length; i++) {
			for(int j=0; j<order.length - i - 1; j++) {
				if(order[j]>order[j+1]) {
					int temp = order[j+1];
					order[j+1] = order[j];
					order[j] = temp;
				}
			}
		}
	}
	
	

}
