package ClientInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextField;

public class ClientThread implements Runnable{
	private Socket socket;
	private JTextField lb_time;
	private JTextField lb_cur_time;

	public  ClientThread(Socket socket,JTextField textField_2, JTextField textField_3) {
		this.socket=socket;
		this.lb_time=textField_2;
		this.lb_cur_time=textField_3;
	}

	@Override
	public void run() {
		BufferedReader in=null;
		try {
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str=null;
			while((str=in.readLine())!=null){
				if(str.equals("충전"))
					System.out.println("충전이셈");
				String[] text = str.split("@");
				if(text[0].equals("left"))
					lb_time.setText(text[1]);
				if(text[0].equals("cur"))
					lb_cur_time.setText(text[1]);
					
			}//while
		}catch(IOException e){
			System.out.println(e);
		}
		finally{
//			System.out.println((num+1) + "PC 종료.");	
			if(socket != null)
				try{ socket.close(); } catch(IOException e){}
		}		
	}
}
