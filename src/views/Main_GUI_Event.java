package views;


import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Main_GUI_Event extends JFrame implements MouseListener, ActionListener{
	private int i;
	
	private JPanel contentPane;
	private JTextField tfname;
	private JTextField tfkor;
	private JTextField tfeng;
	private JTextField tfmat;
	
	SalesManagerView smv= new SalesManagerView();
	MemberMnagerTest mm= new MemberMnagerTest();
	StockManagement sm = new StockManagement();
	public Main_GUI_Event() {
	}
	public Main_GUI_Event(int i) {
		this.i=i;
	}
	
	public void View() {
		setBounds(100, 100, 250, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		panel.add(lblNewLabel);
		
		tfname = new JTextField();
		panel.add(tfname);
		tfname.setColumns(15);
		
		JLabel lblNewLabel_1 = new JLabel("\uAD6D\uC5B4");
		panel.add(lblNewLabel_1);
		
		tfkor = new JTextField();
		panel.add(tfkor);
		tfkor.setColumns(15);
		
		JLabel lblNewLabel_2 = new JLabel("\uC601\uC5B4");
		panel.add(lblNewLabel_2);
		
		tfeng = new JTextField();
		panel.add(tfeng);
		tfeng.setColumns(15);
		
		JLabel lblNewLabel_3 = new JLabel("\uC218\uD559");
		panel.add(lblNewLabel_3);
		
		tfmat = new JTextField();
		panel.add(tfmat);
		tfmat.setColumns(15);
		
		JTextArea area = new JTextArea();
		contentPane.add(area, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("\uCC98\uB9AC");

		contentPane.add(btnNewButton, BorderLayout.EAST);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(i+"번 PC 클릭함");
		this.View();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="매출현황") {
			smv.setVisible(true);
		}
		if(e.getActionCommand()=="회원관리") {
			mm.frame.setVisible(true);
		}
		if(e.getActionCommand()=="재고관리") {
			sm.setVisible(true);
		}
		
	}

	
}
