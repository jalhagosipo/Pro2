package snackChoose;

import java.util.Vector;

import product.ProductDAO;
import product.ProductDTO;
import product.SelectProduct;
import product.UpdateProduct;

public class snackChooseUpdateService {

	
	String name;
	int minusAmount;
	String price;
	
	public snackChooseUpdateService(String name,String price,int minusAmount) {
		this.name=name;
		this.minusAmount= minusAmount;
		this.price=price;
	}
	
	public void stockchange() {
		UpdateProduct up = new UpdateProduct();
		ProductDAO sp = new ProductDAO();
		Vector<ProductDTO> vc = sp.Product(name);
		int total = vc.get(0).getProStock();

		int newStock = total - minusAmount;
		up.updateProduct(name, price, newStock, name);
		//chargein테이블에도삽입해야함.
		
		
	}
}
