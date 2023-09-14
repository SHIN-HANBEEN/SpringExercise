package main;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ex6 {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("src/output.txt");
			
			byte a = 65;
			byte b = 66;
			
			fos.write(a);
			fos.write(b);
			fos.write('c');
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

