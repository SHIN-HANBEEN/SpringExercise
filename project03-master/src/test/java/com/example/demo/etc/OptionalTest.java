package com.example.demo.etc;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * optional은 객체를 감싸는 wrapper 클래스이다
 * 객체에 값이 있는지 없는지를 확인하기 위한 용도이다
 * optional을 사용하면 값이 있는지 편리하게 확인할 수 있다
 * 그리고 null을 다룰때 발생하는 오류를 방지할 수 있다
 * */

@SpringBootTest
public class OptionalTest {
	
	@Test
	void Optional사용하기() {
		Optional<String> opt = Optional.of("apple"); //값 저장
		System.out.println(opt.get());//값 꺼내기
		System.out.println(opt.isEmpty()); //값이 없는지 확인하기
		System.out.println(opt.isPresent()); //값이 있는지 확인하기
		System.out.println(opt.orElse("banana")); //값이 없으면 banana로 대체
	}

	@Test 
	void of와ofNullable의차이(){
		String str = null;
		Optional<String> opt1 = Optional.of(str); //of메소드로 null값을 입력받으면 에러남
//		Optional<String> opt2 = Optional.ofNullable(str); //ofNullable메소드는 null값을 입력받을 수 있음
	}
	
	@Test
	void 빈객체를사용하는경우() {
		Optional<String> opt = Optional.ofNullable(null);
		System.out.println(opt.get());//에러남
	}
	
	@Test
	void if를사용하여null값체크하기() {
		String str = "banana";
		if(str != null) {
			System.out.println("값이 존재합니다");
		}
	}
	
	@Test
	void optinal을사용하여null값체크하기() {
		String str = "banana";
		Optional<String> opt = Optional.ofNullable(str);
		opt.ifPresent(name -> System.out.println("값이 존재합니다")); //람다식 사용
		
		//위의 if null 체크 방식을 더 간결하게 표현할 수 있다
	}
}
