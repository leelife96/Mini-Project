package shopmall;

public class Product {
		private int productid;
	    private String productname;
	    private String price;
	    private String productnumber;
	   

	    public Product(int productid, String productname, String price, String productnumber) {
	        this.productid = productid;
	        this.productname = productname;
	        this.price = price;
	        this.productnumber = productnumber;
	      
	    }

	    
	    public int getProductId() {
	        return productid;
	    }

	    public String getProductName() {
	        return productname;
	    }

	    public String getPrice() {
	        return price;
	    }

	    public String getProductNumber() {
	        return productnumber;
	    }
}
