package 입출력;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;

public class MainClass3 { // DataInputStream, DataOutputStream, BufferedWriter, BufferedReader 도 활용가능함
	public static void main(String[] args) {
		
		InputStream inputstream = null;
		OutputStream outputstream = null;
		
		try {
			inputstream = new FileInputStream("C:\\Users\\customer\\Github\\Java\\javafirst\\hello.txt");
			outputstream = new FileOutputStream("C:\\Users\\customer\\Github\\Java\\javafirst\\helloCopy.txt");
			
			byte[] arr = new byte[3];
			
			while(true) {
				int len = inputstream.read(arr);
				if(len==-1) break;
				outputstream.write(arr, 0, len);
			}
					
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(inputstream != null) {
				try {
					inputstream.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(outputstream != null) {
				try {
					outputstream.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			
		}
	}
}
