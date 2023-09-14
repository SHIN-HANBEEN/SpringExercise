package main;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Ex10 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src/reader.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			int i;
			while (true) {
				i = isr.read();
				if(i == -1) break;
				
				System.out.println((char) i);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
