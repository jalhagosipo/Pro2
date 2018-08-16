package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;

public class chooseSnackView extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTable table = new JTable();
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(12, 10, 760, 513);
		contentPane.add(scrollpane);
		
		
		JList list = new JList();
		list.setBounds(12, 533, 447, 188);
		contentPane.add(list);
		
		JButton buybtn = new JButton("\uAD6C\uB9E4");
		buybtn.setBounds(643, 559, 129, 52);
		contentPane.add(buybtn);
		
		JButton canclebtn = new JButton("\uCDE8\uC18C");
		canclebtn.setBounds(643, 637, 129, 52);
		contentPane.add(canclebtn);
	}
}
