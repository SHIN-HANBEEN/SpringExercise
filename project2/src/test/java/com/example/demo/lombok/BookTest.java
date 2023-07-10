package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {
	
	@Test
	public void test() {
		Book book1 = new Book();
		book1.setTitle("어린왕자");
		book1.setPrice(10000);
		book1.setPublisher("한빛미디어");
		book1.setNumberOfPage(100);
		System.out.println(book1.toString());
		
		Book book2 = new Book("어린왕자2", 20000, "한빛미디어2", 200);
		System.out.println(book2.toString());
	}

}
