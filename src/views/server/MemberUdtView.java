package views.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import member.MemberDAO;
import member.MemberDTO;
import member.MemberUp;
import product.ProductDTO;

public class MemberUdtView extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldid;
	private JTextField textFieldpw;
	private JTextField textFieldphone;
	private JTextField textFieldname;
	private JTextField textFieldsch;
	private JTable memlist;
	
	private String old_id;
	/*JTable memlist;
	
	public MemberUdt(JTable memlist) {
		super();
		this.memlist = memlist;
	}
*/
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MemberUdt frame = new MemberUdt();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MemberUdtView(JTable memlist,String _id, String _name, String _phone) {
		this.old_id=_id;
		/*int row = memlist.getSelectedRow(); //행 선택
		DefaultTableModel tm = (DefaultTableModel) memlist.getModel(); //테이블불러오기
	

		String memid =  (String)memlist.getValueAt(row,0 );
		String phone =  (String)memlist.getValueAt(row,4 );
		String memname =  (String)memlist.getValueAt(row,1 );*/
		
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel id = new JLabel("\uD68C\uC6D0 \uC544\uC774\uB514");
		id.setBounds(29, 41, 73, 15);
		contentPane.add(id);
		
		JLabel pw = new JLabel("\uD68C\uC6D0 \uBE44\uBC00\uBC88\uD638");
		pw.setBounds(12, 87, 90, 15);
		contentPane.add(pw);
		
		JLabel phonenum = new JLabel("\uC804\uD654\uBC88\uD638");
		phonenum.setBounds(45, 127, 57, 15);
		contentPane.add(phonenum);
		
		JLabel name = new JLabel("\uC774\uB984");
		name.setBounds(56, 170, 57, 15);
		contentPane.add(name);
		
		textFieldid = new JTextField();
		//textFieldid.setText(memid);
		textFieldid.setBounds(136, 38, 116, 21);
		contentPane.add(textFieldid);
		textFieldid.setColumns(10);
		
		textFieldpw = new JTextField();
		
		textFieldpw.setBounds(136, 84, 116, 21);
		contentPane.add(textFieldpw);
		textFieldpw.setColumns(10);
		
		textFieldphone = new JTextField();
//		textFieldid.setText(phone);
		textFieldphone.setBounds(136, 124, 116, 21);
		contentPane.add(textFieldphone);
		textFieldphone.setColumns(10);
		
		textFieldname = new JTextField();
//		textFieldid.setText(memname);
		textFieldname.setBounds(136, 167, 116, 21);
		contentPane.add(textFieldname);
		textFieldname.setColumns(10);
		
		
		//textfield 값설정
		textFieldid.setText(_id);
		textFieldphone.setText(_phone);
		textFieldname.setText(_name);
		
		JButton btnup = new JButton("\uC218\uC815");
		btnup.setBounds(29, 286, 97, 23);
		contentPane.add(btnup);
		
		btnup.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberUp mu= new MemberUp();
				mu.updateAccount(textFieldid.getText()
													,textFieldpw.getText()
													,textFieldphone.getText()
													,textFieldname.getText()
													,old_id
						);
				//JOptionPane.showMessageDialog(null, "수정 성공");
				DefaultTableModel tm = (DefaultTableModel) memlist.getModel();
				tm.setNumRows(0);
				MemberDAO dao=new MemberDAO();
				Vector<MemberDTO> dto= dao.Member("");
				Iterator<MemberDTO> it = dto.iterator();
				
				while(it.hasNext())
				{
					MemberDTO sd = it.next();
					tm.addRow(new Object[]{sd.getId(),sd.getName(),sd.getTotal_price(),sd.getLeft_time(),sd.getPhonenum()});
				}
				
				dispose();
				
				
			}
		});
		
		JButton btnexit = new JButton("\uB2EB\uAE30");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnexit.setBounds(155, 286, 97, 23);
		contentPane.add(btnexit);
	}
}
