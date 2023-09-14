package main;

import java.io.FileReader;
import java.io.IOException;

public class Ex8 {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("src/reader.txt");
			
			while (true) {
				int i = fr.read(); // 한 문자(2바이트)씩 읽기
				if (i == -1) {
					break;
				}
				System.out.println((char) i);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
