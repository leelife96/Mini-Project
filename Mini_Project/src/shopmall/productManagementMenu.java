package shopmall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

public class productManagementMenu {
	
	public static final String PRODUCT_FILE_PATH = "C:\\Program Files\\eclipse\\products.txt";
	public static Map<Integer, Product> productMap = new HashMap<>();
	private static List<Product> productList = new ArrayList<>();
	private static int productCount = 0;	

	public static void proman() {
		 Scanner scanner = new Scanner(System.in);
		    
		    Main mm = new Main();

		    while (true) {
		        System.out.println("=== 제품관리 ===");
		        System.out.println("1. 상품 추가");
		        System.out.println("2. 상품 조회");
		        System.out.println("3. 상품 삭제");
		        System.out.println("4. 메인 메뉴로 돌아가기");
		        System.out.print("원하는 메뉴를 선택하세요: ");
		        int choice = scanner.nextInt();

		        switch (choice) {
		            case 1:
		            	addProduct();
		                break;
		            case 2:
		            	displayProductRecords();
		            	break;
		            	
		            case 3:
		            	
		            	deleteProduct();
		            	break;
		            case 4: 
		            	mm.start();
		            	break;
		            	
		            default:
		                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
		                break;
		        }
		    }
	}

	
	public static void addProduct() {
		
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("=== 상품 추가 ===");
	
	    System.out.print("상품명을 입력하세요: ");
	    String productName = scanner.nextLine();
	
	    System.out.print("상품가격을 입력하세요: ");
	    String productPrice = scanner.nextLine();
	    
	    System.out.print("상품 수량을 입력하세요: ");
	    String productNumber = scanner.nextLine();
	
	
	    
	    // 고객 정보를 저장할 문자열 생성
	    Product product = new Product(++productCount, productName, productPrice, productNumber );
	
	    // HashMap에 고객 정보 추가
	    productMap.put(productCount, product);
	    
	 // ArrayList에 고객 정보 추가
	    productList.add(product);
	    
	    // 텍스트 파일에 고객 정보 저장
	    try (PrintWriter writer = new PrintWriter(new FileWriter(PRODUCT_FILE_PATH, true))) {
	        String productInfo = productCount + ", " + product.getProductName() + ", " + product.getPrice() + ", " + product.getProductNumber();
	       /* String productInfo = "상품번호 : " + productCount + ", " + "상품명 : " + product.getProductName() + ", " + "가격 : " + product.getPrice() + ", " + "수량 : " + product.getProductNumber(); */
	        writer.println(productInfo);
	        writer.flush();
	        System.out.println("상품 정보가 성공적으로 추가되었습니다.");
	    } catch (IOException e) {
	        System.out.println("상품 정보 추가 중 오류가 발생했습니다: " + e.getMessage());
	    }
	}
	
	public static void deleteProduct() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("삭제할 상품 번호를 입력하세요: ");
	    int productNumberToDelete = scanner.nextInt();

	    // HashMap에서 고객 정보 삭제
	    Product deletedProduct = productMap.remove(productNumberToDelete);

	    if (deletedProduct != null) {
	        // ArrayList에서 고객 정보 삭제
	    	productList.remove(deletedProduct);

	        // 텍스트 파일에서 해당 고객 정보 삭제
	        try {
	            List<String> lines2 = Files.readAllLines(Paths.get(PRODUCT_FILE_PATH));
	            List<String> updatedLines2 = new ArrayList<>();

	            for (String line2 : lines2) {
	                // 해당 고객 번호의 정보를 제외하고 다시 작성
	                if (!line2.contains("상품번호 : " + productNumberToDelete)) {
	                    updatedLines2.add(line2);
	                }
	            }

	            // 파일에 업데이트된 내용 쓰기
	            Files.write(Paths.get(PRODUCT_FILE_PATH), updatedLines2, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

	            System.out.println("상품 정보가 성공적으로 삭제되었습니다.");
	        } catch (IOException e) {
	            System.out.println("상품 정보 삭제 중 오류가 발생했습니다: " + e.getMessage());
	        }
	    } else {
	        System.out.println("입력한 상품 번호에 해당하는 상품 정보가 없습니다.");
	    }
	}
	
	public static void displayProductRecords() {
	    System.out.println("=== 상품 정보 조회 ===");

	    try (BufferedReader reader2 = new BufferedReader(new FileReader(PRODUCT_FILE_PATH))) {
	        String line2;
	        while ((line2 = reader2.readLine()) != null) {
	            System.out.println(line2);
	        }
	    } catch (IOException e) {
	        System.out.println("상품 정보 조회 중 오류가 발생했습니다: " + e.getMessage());
	    }
	}
	
	
	  public static void main(String[] args) {
		  productManagementMenu pmm = new productManagementMenu();
			pmm.proman();
		}
}
