package main;

import java.io.FileOutputStream;

public class Ex7 {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("src/output2.txt");
			byte[] arr = { 65, 66, 67 };
			
			fos.write(arr);  // 배열의 모든 데이터를 출력(쓰기)해준다. 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
