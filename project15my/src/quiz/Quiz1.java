package quiz;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		while (true) {
			System.out.println("종료합니까? (stop입력)");
			Scanner scanner = new Scanner(System.in);
			String isEnd = scanner.nextLine();
			if (isEnd.equalsIgnoreCase("STOP")) {
				System.out.println("program is over");
				break;
			}
		}
	}
}
