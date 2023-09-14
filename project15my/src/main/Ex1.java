package main;

import java.io.IOException;

public class Ex1 {

	public static void main(String[] args) {
		System.out.println("알파벳 하나를 쓰고 Enter 누르세요.");
		
		int i;
		try {
			i = System.in.read();
			System.out.println(i);
			System.out.println((char) i);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

