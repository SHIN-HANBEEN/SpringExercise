package main;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex5 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src/input3.txt");
			byte[] arr = new byte[10];
			int i;
			
			while ((i = fis.read(arr)) != -1) {
				for (int k = 0; k < i; k++) {
					System.out.println((char) arr[k]);
				}
				System.out.println(": " + i + "바이트 읽음");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
