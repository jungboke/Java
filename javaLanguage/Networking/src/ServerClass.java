import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerClass {
	public static void main(String[] args) {
		
		ServerSocket serversocket = null;
		Socket socket = null;
		
		InputStream inputstream = null;
		DataInputStream datainputstream = null;
		OutputStream outputstream = null;
		DataOutputStream dataoutputstream = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			serversocket = new ServerSocket(9000);
			System.out.println("클라이언트 맞을 준비 완료~~");
			
			socket = serversocket.accept();
			System.out.println("클라이언트 연결~~");
			System.out.println("socket : " + socket);
			
			inputstream = socket.getInputStream();
			datainputstream = new DataInputStream(inputstream);
			outputstream = socket.getOutputStream();
			dataoutputstream = new DataOutputStream(outputstream);
			
			while(true) {
				String ClientMessage = datainputstream.readUTF();
				System.out.println("clientMessage : " + ClientMessage);
				
				dataoutputstream.writeUTF("메시지 전송 완료~~");
				dataoutputstream.flush();
				
				if(ClientMessage.equals("STOP")) break;
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(inputstream != null) inputstream.close();
				if(datainputstream != null) datainputstream.close();
				if(outputstream != null) outputstream.close();
				if(dataoutputstream != null) dataoutputstream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
