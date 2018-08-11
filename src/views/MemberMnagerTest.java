package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class MemberMnagerTest extends JFrame{

	//¡÷ºÆ√≥∏Æ: 0811_¿±∞«»Ò_∏ﬁ¿Œ∫‰øÕ ø¨∞·
//	private JFrame frame;
	public JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MemberMnagerTest mm= new MemberMnagerTest();
		mm.frame.setVisible(true);
		
		//¡÷ºÆ√≥∏Æ: 0811_¿±∞«»Ò_∏ﬁ¿Œ∫‰øÕ ø¨∞·
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MemberMnagerTest window = new MemberMnagerTest();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	//¡÷ºÆ√≥∏Æ: 0811_¿±∞«»Ò_∏ﬁ¿Œ∫‰øÕ ø¨∞·
//	public MemberMnagerTest() {
//		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	public MemberMnagerTest() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 0, 760, 98);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 ID");
		lblNewLabel.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		lblNewLabel.setBounds(57, 49, 78, 22);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(131, 46, 180, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.setBounds(353, 43, 109, 37);
		panel.add(btnNewButton);
		
		JButton btnWjscprjator = new JButton("\uC804\uCCB4 \uAC80\uC0C9");
		btnWjscprjator.setBounds(565, 29, 127, 64);
		panel.add(btnWjscprjator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 442, 760, 109);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("\uCD94\uAC00");
		btnNewButton_2.setBounds(59, 21, 133, 60);
		panel_2.add(btnNewButton_2);
		
		JButton button = new JButton("\uC218\uC815");
		button.setBounds(256, 21, 133, 60);
		panel_2.add(button);
		
		JButton button_1 = new JButton("\uC0AD\uC81C");
		button_1.setBounds(453, 21, 133, 60);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("\uB2EB\uAE30");
		button_2.setBounds(637, 58, 111, 41);
		panel_2.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 102, 760, 351);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\uD68C\uC6D0ID", "\uD68C\uC6D0 \uC774\uB984", "\uC0AC\uC6A9 \uC2DC\uAC04", "\uB0A8\uC740 \uC2DC\uAC04"
			}
		));
		scrollPane.setViewportView(table);
	}
}
