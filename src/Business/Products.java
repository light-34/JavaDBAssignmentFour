package Business;

public class Products {
	private int productid;
	private String productName;
	private double listPrice;
	
	
	
	public Products(int productid, String productName, double listPrice) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.listPrice = listPrice;
	}

	public Products(String productName, double listPrice) {
		this.productName = productName;
		this.listPrice = listPrice;
	}
	
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

}
