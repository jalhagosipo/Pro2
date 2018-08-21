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
			String[] text=null;
			String[] text2=null;
			while((str=in.readLine())!=null){
				text = str.split("@");
//				switch(text[0]) {
//				case "left":lb_time.setText(text[1]);
//							System.out.println("남은시간:"+text[1]);
//							break;
//				case "cur":lb_cur_time.setText(text[1]);
//							System.out.println("사용시간:"+text[1]);
//							break;
//				}
				
				
				//switch랑 if 중 선택
				if(text[0].equals("left")) {
//					if(text[1]!=null)
					lb_time.setText(text[1]);
					System.out.println("남은시간:"+text[1]);
				}
				text2 = str.split("@");
				if(text2[0].equals("cur")) {
//					if(text[1]!=null)
					lb_cur_time.setText(text2[1]);
					System.out.println("사용시간:"+text2[1]);
				}
			}//while
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
//			System.out.println((num+1) + "PC 종료.");	
			if(in != null)
				try{ in.close(); } catch(IOException e){}
			if(socket != null)
				try{ socket.close(); } catch(IOException e){}
		}		
	}
}
