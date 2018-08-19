

package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import product.ProductDTO;
import product.SelectProduct;
import snackChoose.buysnack;
import snackChoose.cart;

public class ChooseSnackView extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	javax.swing.Timer timer; 
	private Client ci;
	private JTextField tf_id;
	private JTextField tf_lefttime;
	private JTextField textShowPrice;
	
	public ChooseSnackView(Client c, JTextField id, JTextField lefttime) {
		this.ci=c;
		this.tf_id=id;
		this.tf_lefttime=lefttime;
		SelectProduct sp = new SelectProduct();
		Vector<ProductDTO> arr = sp.SelectPro();
		Vector<ProductDTO> buy_arr = new Vector<>();
		int MAX = arr.size();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buybtn = new JButton("\uAD6C\uB9E4");
		buybtn.setBounds(462, 494, 107, 52);
		contentPane.add(buybtn);
		
		JButton canclebtn = new JButton("\uCDE8\uC18C");
		canclebtn.setBounds(605, 494, 107, 52);
		contentPane.add(canclebtn);
		canclebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(57, 14, 669, 534);
		
		panel.setLayout(new GridLayout((MAX%2==0)?MAX/2:MAX/2+1, 2, 150, 40));
		JScrollPane scroll_pan = new JScrollPane(panel);
		scroll_pan.setBounds(48, 10, 688, 445);
		contentPane.add(scroll_pan);
		JPanel[] pan_snack = new JPanel[MAX];
		JPanel[] pan_left =new JPanel[MAX];
		JPanel[] pan_right =new JPanel[MAX];
		JLabel[] lb_pname = new JLabel[MAX];
		JLabel[] lb_pprice = new JLabel[MAX];
		JButton[] btn_tocart = new JButton[MAX];
		JComboBox[] cb_amount = new JComboBox[MAX];/*panel처럼객체생성해서해줘야함*/
		
		
		DefaultTableModel model = new DefaultTableModel(new Object[]{"productname","productprice","amount"},0);
		table = new JTable(model);
		JScrollPane sp_table = new JScrollPane(table);
		sp_table.setBounds(48, 494, 389, 187);
		contentPane.add(sp_table);
		
		JButton deleterow_btn = new JButton("\uC544\uC774\uD15C \uC0AD\uC81C");
		deleterow_btn.setBounds(324, 691, 113, 30);
		
		contentPane.add(deleterow_btn);
		
		JLabel lblNewLabel = new JLabel("\uC7A5\uBC14\uAD6C\uB2C8");
		lblNewLabel.setBounds(48, 475, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\uBA54\uB274");
		label.setBounds(12, 10, 35, 15);
		contentPane.add(label);
		

		textShowPrice = new JTextField();
		textShowPrice.setBounds(462, 612, 250, 42);
		textShowPrice.setEditable(false);
		contentPane.add(textShowPrice);
		textShowPrice.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uAE08\uC561");
		lblNewLabel_1.setBounds(462, 574, 43, 28);
		contentPane.add(lblNewLabel_1);
		
		for(int i=0;i<MAX;i++) {
			pan_snack[i] =new JPanel();
			pan_snack[i].setLayout(new GridLayout(1, 2));
			
			pan_left[i]=new JPanel();
			pan_right[i]=new JPanel();
			pan_left[i].setLayout(new BoxLayout(pan_left[i],BoxLayout.Y_AXIS));
			pan_right[i].setLayout(new BoxLayout(pan_right[i],BoxLayout.X_AXIS));
			
			lb_pname[i]=new JLabel(arr.get(i).getProName());
			lb_pprice[i]=new JLabel(arr.get(i).getProPrice());//left
			
			btn_tocart[i] = new JButton("담기");
			
			cb_amount[i] = new JComboBox(new String[] {"1","2","3","4","5"});//right
			
			pan_left[i].add(lb_pname[i]);
			pan_left[i].add(lb_pprice[i]);
			
			pan_right[i].add(cb_amount[i]);
			pan_right[i].add(btn_tocart[i]);
			
			pan_snack[i].add(pan_left[i]);
			pan_snack[i].add(pan_right[i]);
			
			btn_tocart[i].addActionListener(new cart(buy_arr,lb_pname[i].getText(),lb_pprice[i].getText(),cb_amount[i],table,textShowPrice));
			
			panel.add(pan_snack[i]);
		}//end for
		
		deleterow_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				int m= Integer.parseInt(model.getValueAt(table.getSelectedRow(), 1).toString().substring(3, 5));
				int cnt= Integer.parseInt(model.getValueAt(table.getSelectedRow(), 2).toString());
				int result = Integer.parseInt(textShowPrice.getText().substring(0, textShowPrice.getText().length()-1).trim()) - (m*cnt);
				textShowPrice.setText(result+" 분");
				buy_arr.remove(table.getSelectedRow());
				model.removeRow(table.getSelectedRow());
//				textShowPrice.setText();
			}
		});//end addActionListener
		
		buybtn.addActionListener(new buysnack(ci,this,table,tf_id,tf_lefttime,textShowPrice));
	}//end constructors
}//end class
