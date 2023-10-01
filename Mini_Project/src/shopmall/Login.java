package shopmall;

import java.util.*;
import java.io.*;
import java.nio.file.*;



	
	public class Login extends customerManagementMenu {
		
		static ShoppingMain sm = new ShoppingMain();
		
		public static void login() {
		    Scanner scanner = new Scanner(System.in);
		    System.out.println("=== 로그인 ===");

		    System.out.print("고객 번호를 입력하세요: ");
		    int customerNumber = scanner.nextInt();
		    scanner.nextLine(); // 버퍼 비우기

		    System.out.print("고객 이름을 입력하세요: ");
		    String customerName = scanner.nextLine();

		    Customer customer = customerMap.get(customerNumber);
		    if (customer != null && customer.getName().equals(customerName)) {
		        System.out.println("로그인 성공!");
		        
		        sm.shoppingMallMenu();	
		        // 로그인 성공 후 추가적인 동작 수행
		    } else {
		        System.out.println("로그인 실패: 유효한 고객 정보가 아닙니다.");
		    }
		}
	}


