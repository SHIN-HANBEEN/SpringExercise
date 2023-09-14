package main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex12 {

	public static void main(String[] args) {
		long start = 0;
		long end = 0;
		
		try {
			FileInputStream fis = new FileInputStream("src/a.txt"); // 기반 스트림 생성
			FileOutputStream fos = new FileOutputStream("src/copy2.txt");
			
			BufferedInputStream bis = new BufferedInputStream(fis); // 버퍼 보조 스트림 생성
			BufferedOutputStream bos = new BufferedOutputStream(fos); // 버퍼 보조 스트림 생성
			
			start = System.currentTimeMillis();
			int i;
			while ((i = bis.read()) != -1) { // 8kb 씩 읽어서 복사한다. 
				bos.write(i);
			}
			end = System.currentTimeMillis();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println(end - start + "ms 초 걸렸습니다.");
	}
}
