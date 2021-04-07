import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClass {
	public static void main(String[] args) {
		
		ServerSocket serversocket = null;
		Socket socket = null;
		
		try { // 네트워크 관련된 코드는 항상 예외처리 해주는게 좋음
			serversocket = new ServerSocket(9000);
			System.out.println("클라이언트 맞을 준비 완료!!");
			
			socket = serversocket.accept();
			System.out.println("클라이언트 연결!!");
			System.out.println("socket : " + socket);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null) socket.close();
				if(serversocket != null) serversocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
