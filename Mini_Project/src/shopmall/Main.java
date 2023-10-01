package shopmall;

import java.util.*;
import java.io.*;

	public class Main {
		
		public static final String CUSTOMER_FILE_PATH = "customers.txt";
		public static Map<Integer, Customer> customerMap = new HashMap<>();
		 private static int customerCount = 0;	
		
		public static void start() {
			
			 customerManagementMenu cmm = new  customerManagementMenu();
			 productManagementMenu pmm = new productManagementMenu();
			 Login login = new Login();
		        Scanner scanner = new Scanner(System.in);
	
		        while (true) {
		            System.out.println("====== 쇼핑몰 프로그램 ======");
		            System.out.println("1. 쇼핑몰");
		            System.out.println("2. 고객관리");
		            System.out.println("3. 제품관리");
		           
		            System.out.print("메뉴를 선택 하시오.: ");
		            int choice = scanner.nextInt();
	
		            switch (choice) {
		                case 1:
		                    login.login();
		                    break;
		                case 2:
		                	
		                    cmm.cusman();
		                    break;
		                case 3:
		                    pmm.proman();
		                    break;
		               
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		                    break;
		            }
		        }
		    }
			
	
	



	public static void main(String[] args) {
		
		 	start();
}
	 }
