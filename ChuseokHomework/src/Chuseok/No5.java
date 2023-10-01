package Chuseok;

import java.util.Scanner;

public class No5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] order = new int[5];
		
		for(int i=0; i<order.length; i++) {
			order[i] = sc.nextInt();
		}
		
		int[] sorted = Bubble(order);
		for(int i=0; i<sorted.length; i++) {
			System.out.print(sorted[i] + " ");
		}
		
		

	}
	
	public static int[] Bubble(int[] order) {
		
		int[] bubble = order;
		int temp = 0;
		for(int i=0; i<bubble.length; i++) {
			if (bubble[i] > bubble[i+1]) {
				temp = bubble[i];
				bubble[i] =  bubble[i+1];
				bubble[i+1] = temp;
						
			}
		}
		
		return bubble;
		
	}

}
