import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientClass {
	public static void main(String[] args) {
		
		Socket socket = null;
		OutputStream outputstream = null;
		DataOutputStream dataoutputstream = null;
		InputStream inputstream = null;
		DataInputStream dataintputstream = null;
		Scanner scanner = null;
		try {
			socket = new Socket("localhost",9000);
			System.out.println("서버 연결 완료~~");
			
			outputstream = socket.getOutputStream();
			dataoutputstream = new DataOutputStream(outputstream);
			inputstream = socket.getInputStream();
			dataintputstream = new DataInputStream(inputstream);
			scanner = new Scanner(System.in);
			
			while(true) {
				System.out.println("메시지 입력~~");
				String outMessage = scanner.nextLine(); // nextLine: 한줄 입력받음
				dataoutputstream.writeUTF(outMessage);
				dataoutputstream.flush();
				
				String inMessage = dataintputstream.readUTF();
				System.out.println("inMessage : " + inMessage);
				
				if(outMessage.equals("STOP")) break;

			} 
						
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dataoutputstream != null) dataoutputstream.close();
				if(outputstream != null) outputstream.close();
				if(dataintputstream != null) dataintputstream.close();
				if(inputstream != null) inputstream.close();
					
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
