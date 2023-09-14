package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex11 {

	public static void main(String[] args) {
		long start = 0;
		long end = 0;
		try {
			FileInputStream fis = new FileInputStream("src/a.txt");
			FileOutputStream fos = new FileOutputStream("src/copy.txt");
			
			start = System.currentTimeMillis(); // 복사 시작 시간
			int i;
			while ((i = fis.read()) != -1) { // 파일에서 한 글자씩 읽어가면서 복사시작
				fos.write(i);
			}
			end = System.currentTimeMillis(); // 복사 종료 시간
		} catch (IOException e) {
			System.out.println(e);
		}
		
		System.out.println("파일 복사하는 데 " + (end - start) + " ms 소요되었습니다.");
	}
}
