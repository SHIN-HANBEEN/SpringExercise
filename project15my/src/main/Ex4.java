package main;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex4 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src/hello.txt");
			
			while (true) {
				int i = fis.read(); // 1 바이트 읽기
				if(i == -1) {  // 파일의 끝에 도달하면 반복문 종료
					break;
				}
				System.out.println((char)i); // 문자 하나씩 출력
			}
		} catch (IOException e) {  // Input Output 에서 발생하는 모든 예외를 한번에 처리하여 
//			try catch 문을 여러 번 작성하는 것을 방지했다.
			System.out.println(e);
		}
	}
}
