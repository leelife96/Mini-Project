package shopmall;


import java.util.*;

import java.io.*;


public class ShoppingMain {
    private static final String PRODUCT_FILE_PATH = "C:\\Program Files\\eclipse\\products.txt";
    
    private static final String ORDER_HISTORY_FILE_PATH = "C:\\Program Files\\eclipse\\order_history.txt";
    
    private static Map<Integer, Product> productMap = new HashMap<>();
    private static List<Product> productList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int loggedInCustomerNumber; // 로그인한 고객 번호 저장
   
    
    
    public static void shoppingMallMenu() {
        Scanner scanner = new Scanner(System.in);
        Main mm = new Main();

        while (true) {
            System.out.println("========== 쇼핑몰 메인 ==========");
            System.out.println("1. 주문하기");
            System.out.println("2. 상품 리스트 보기");
            System.out.println("3. 주문 내역 보기");
            System.out.println("4. 고객 정보 보기");
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                 
                	showProductListAndOrder();
                    break;
                case 2:
                	ProductList();
                    break;
                case 3:	
                	showOrderHistory();
                    break;
              
                case 0:
                    mm.start();
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }
    
    private static void ProductList() {  // 2. 상품 리스트 보기
        System.out.println("========== 상품 목록 ==========");
        System.out.println("상품ID     상품명     가격     수량");
        System.out.println("==============================");

	    List<String> productList = loadProductListFromFile("C:\\Program Files\\eclipse\\products.txt"); // 상품 목록이 저장된 텍스트 파일 경로
	    if (productList.isEmpty()) {
	        System.out.println("상품이 없습니다.");
	    } else {
	        for (String product : productList) {
	            System.out.println(product);
	        }
	    }
    }

    private static void showProductListAndOrder() {
        System.out.println("========== 상품 목록 ==========");
        System.out.println("상품ID     상품명     가격     수량");
        System.out.println("==============================");

	    List<String> productList = loadProductListFromFile("C:\\Program Files\\eclipse\\products.txt"); // 상품 목록이 저장된 텍스트 파일 경로
	    if (productList.isEmpty()) {
	        System.out.println("상품이 없습니다.");
	    } else {
	        for (String product : productList) {
	            System.out.println(product);
	        }

	        System.out.println("----------------------------");
	        System.out.print("주문할 상품 번호를 입력하세요: ");
	        int productNumber = scanner.nextInt();
	        scanner.nextLine(); // 개행 문자 제거

	        if (productNumber >= 1 && productNumber <= productList.size()) {
	            String selectedProduct = productList.get(productNumber - 1);
	            String[] productInfo = selectedProduct.split(",");

	            String pid = productInfo[0].trim();
	            String productName = productInfo[1].trim();
	            String price = productInfo[2].trim();
	            String productCount = productInfo[3].trim();

	            System.out.print("주문할 수량을 입력하세요: ");
	            int quantity = scanner.nextInt();
	            scanner.nextLine(); // 개행 문자 제거

	            int availableQuantity = Integer.parseInt(productCount);
	            if (quantity <= availableQuantity) {
	                // 주문 가능한 수량인 경우
	                int remainingQuantity = availableQuantity - quantity;

	                // 업데이트된 상품 정보를 생성
	                String updatedProductInfo = pid + ", " + productName  + ", " +  price + ", " + remainingQuantity;
	                
	                // 상품 목록 업데이트
	                productList.set(productNumber - 1, updatedProductInfo);
	                
	                System.out.println(quantity + "개의 " + productName + "을(를) 주문하였습니다.");
	                System.out.println("주문이 완료되었습니다.");
	                
	            

	                
	                // 상품 정보를 파일에 업데이트
	                String filePath = "C:\\Program Files\\eclipse\\products.txt";
	                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	                    for (String product : productList) {
	                        writer.write(product);
	                        writer.newLine();
	                    }
	                    System.out.println("데이터가 파일에 저장되었습니다.");
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	                
	                
	                // 주문 내역에 추가
                    double totalPrice = Double.parseDouble(price) * quantity;
                    String orderDetails = "고객 번호: " + loggedInCustomerNumber +
                            ", 상품번호: " + productNumber +
                            ", 상품명: " + productName +
                            ", 가격: " + price +
                            ", 수량: " + quantity +
                            ", 총액: " + totalPrice;
                    updateOrderHistory(orderDetails);
                    
                    
	              
	            } else {
	                System.out.println("주문 가능한 수량을 초과하였습니다.");
	            }
	        } else {
	            System.out.println("잘못된 상품 번호입니다.");
	        }
        }
    }

 
    
    private static List<String> loadOrderHistoryFromFile(String filePath) {
        List<String> orderHistory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orderHistory.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orderHistory;
    }

    
    private static void updateOrderHistory(String orderDetails) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_HISTORY_FILE_PATH, true))) {
            writer.write(orderDetails);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private static void showOrderHistory() {
        System.out.println("========== 주문 내역 ==========");
        List<String> orderHistory = loadOrderHistoryFromFile(ORDER_HISTORY_FILE_PATH);
        if (orderHistory.isEmpty()) {
            System.out.println("주문 내역이 없습니다.");
        } else {
            for (String order : orderHistory) {
                System.out.println(order);
            }
        }
    }
    

    private static List<String> loadProductListFromFile(String filePath) {
        List<String> productList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                productList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productList;
    }

   private static void saveProductListToFile(String filePath, List<String> productList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String product : productList) {
                writer.write(product);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
	
   
   
   
   
		    
		    public static void main(String[] args) {
				ShoppingMain sm = new ShoppingMain();
				sm.shoppingMallMenu();
			}
		    
		    
		    
}
