package 입출력;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
	
		/*
		//read()
		InputStream inputstream = null;
		try {
			
			inputstream = new FileInputStream("C:\\Users\\customer\\Github\\Java\\javafirst\\hello.txt");
			int data = 0;
			
			while(true) {
				
				try {
					data = inputstream.read();
				} catch(IOException e) {
					e.printStackTrace();
				}
				if(data == -1) break;
				System.out.println("data :" + data);
			}
				
				
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(inputstream != null) inputstream.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		
		}
		*/
		// read(byte[])
			InputStream inputstream = null;
			try {
				inputstream = new FileInputStream("C:\\Users\\customer\\Github\\Java\\javafirst\\hello.txt");
				int data = 0;
				byte[] bs = new byte[3];
				
				while(true) {
					
					try {
						data = inputstream.read(bs);
					} catch(IOException e) {
						e.printStackTrace();
					}
					if(data == -1) break;
					System.out.println("data : " + data);
					for(int i=0;i<bs.length;i++)
					{
						System.out.println("bs[" + i + "] : " + bs[i]);
					}
				}
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if(inputstream != null) inputstream.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
				}
		
	}
}
