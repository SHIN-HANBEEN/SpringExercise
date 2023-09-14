package quiz;

import java.io.FileWriter;
import java.io.IOException;

public class Quiz3 {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("src/quiz3.txt");
			
			for (int i = 1; i < 11; i++) {
				if (i % 2 == 0) {
					fw.write(i + " ");  // 2, 4, 6, 8, 10 을 출력해야하는데, fw 는 아스키코드로
					//인식한다. 아스키 코드에서 숫자 0은 49번이다. 
					// 다른 방법으로는 위의 코드처럼 i + " " 로 char + char -> String 으로 
					// 출력할 수도 있다. 
					// 여기서 주의할 점은 (char)i 는 동작을 하지 않는데, 
					// (char)2 로 자바는 인식을 하는데 2에 해당하는 아스키 코드가 없기 때문에
					// 오류가 발생하게 된다. 
				}
			}
			fw.flush();
		} catch (IOException e) {
			System.out.println(e);		
		}
	}
}
