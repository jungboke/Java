package 입출력;

import java.io.IOException;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainClass2 {
	public static void main(String[] args) {
		
		/*
		OutputStream outputstream = null;
		try {
			outputstream = new FileOutputStream("C:\\Users\\customer\\Github\\Java\\javafirst\\hellow.txt");
			String data = "Hello java World.";
			byte[] arr = data.getBytes();
			
			try {
				outputstream.write(arr);
			} catch(IOException e) {
				e.printStackTrace();
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			}finally {
				try {
					if(outputstream != null) outputstream.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		*/
		OutputStream outputstream = null;
		try {
			outputstream = new FileOutputStream("C:\\Users\\customer\\Github\\Java\\javafirst\\hellow.txt");
			String data = "Hello java World2.";
			byte[] arr = data.getBytes();
			
			try {
				outputstream.write(arr, 0, 5);
			} catch(IOException e) {
				e.printStackTrace();
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			}finally {
				try {
					if(outputstream != null) outputstream.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
	}
}
