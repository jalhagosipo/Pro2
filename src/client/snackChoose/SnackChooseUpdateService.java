package client.snackChoose;

import java.util.Vector;

import DB.DAO.ProductDAO;
import DB.DTO.ProductDTO;

public class SnackChooseUpdateService {
    String name;
    int minusAmount;
    String price;

    public SnackChooseUpdateService(String name,String price,int minusAmount) {
        this.name=name;
        this.minusAmount= minusAmount;
        this.price=price;
    }

    public boolean stockchange() {
        ProductDAO sp = new ProductDAO();
        Vector<ProductDTO> vc = sp.Product(name);
        int total = vc.get(0).getProStock();

        int newStock = total - minusAmount;

        if(newStock<0) {
            return false;
        }
        else {
            sp.updateProduct(name, price, newStock, name);
            //chargein테이블에도삽입해야함.
            return true;
        }

    }
}
