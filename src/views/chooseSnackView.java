package views;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import product.ProductDTO;
import product.SelectProduct;

public class chooseSnackView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chooseSnackView frame = new chooseSnackView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public chooseSnackView() {
		SelectProduct sp = new SelectProduct();
		Vector<ProductDTO> arr = sp.SelectPro();
		int MAX = arr.size();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buybtn = new JButton("\uAD6C\uB9E4");
		buybtn.setBounds(464, 650, 129, 52);
		contentPane.add(buybtn);
		
		JButton canclebtn = new JButton("\uCDE8\uC18C");
		canclebtn.setBounds(621, 650, 129, 52);
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
			
			panel.add(pan_snack[i]);
		}
		
		table = new JTable();
		table.setBounds(18, 568, 419, 136);
		contentPane.add(table);
	}
}
