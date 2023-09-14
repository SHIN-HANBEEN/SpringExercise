package quiz;

import java.io.FileOutputStream;
import java.io.IOException;


public class Quiz2 {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("src/quiz2.txt");
			byte[] arr = new byte[26];
			byte A = 65;
			for (int i = 0; i<26; i++) {
				 arr[i] = A;
				 A++;
			}
			fos.write(arr);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
