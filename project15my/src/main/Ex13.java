package main;

import java.io.File;


public class Ex13 {

	public static void main(String[] args) {
		File dir = new File("C:\\atemp");
		
		File[] files = dir.listFiles(); // 폴더 밑에 있는 파일 목록
		
		for (int i = 0; i<files.length; i++) {
			System.out.println(files[i]);
		}
	}
}
