

package client.snackChoose;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DB.DTO.ProductDTO;

public class Cart implements ActionListener{
    String name;
    String price;
    JComboBox amount;
    Vector<ProductDTO> cartV;
    JTable table;
    Vector<ProductDTO> buy_arr;
    JTextField textShowPrice;

    public Cart(Vector<ProductDTO> buy_arr,String name, String price, JComboBox amount,JTable table,JTextField textShowPrice) {
        this.buy_arr=buy_arr;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.table = table;
        this.textShowPrice = textShowPrice;
    }

    public int sumCart(DefaultTableModel tm)
    {

        int row = tm.getRowCount();
        int total=0;
        for(int i = 0; i < row; i++) {
            int m= Integer.parseInt(tm.getValueAt(i, 1).toString().substring(3, 5));
            int cnt= Integer.parseInt(tm.getValueAt(i, 2).toString());
            total+=m*cnt;
        }
        return total;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        DefaultTableModel tm = (DefaultTableModel) table.getModel();
        ProductDTO pd = new ProductDTO(name,price,amount.getSelectedIndex()+1);
        buy_arr.add(pd);
        tm.addRow(new Object[]{pd.getProName(),pd.getProPrice(),pd.getAmount()});
        amount.setSelectedIndex(0);
        textShowPrice.setText(sumCart(tm)+" 분");
    }

}
