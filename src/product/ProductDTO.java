package product;

public class ProductDTO {
	String proName;
	int proPrice;
	int proStock;
	int proNumber;
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public int getProStock() {
		return proStock;
	}
	public void setProStock(int proStock) {
		this.proStock = proStock;
	}
	public int getProNumber() {
		return proNumber;
	}
	public void setProNumber(int proNumber) {
		this.proNumber = proNumber;
	}
	public ProductDTO(String proName, int proPrice, int proStock, int proNumber) {
		super();
		this.proName = proName;
		this.proPrice = proPrice;
		this.proStock = proStock;
		this.proNumber = proNumber;
	}
	public ProductDTO() {
		
	}

}
