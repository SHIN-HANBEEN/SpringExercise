package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	Chef chef1 = new Chef(); // 필요한 객체를 직접 생성함
	
	// 필요한 객체를 컨테이너에서 꺼내서 사용함.
	@Autowired
	Chef chef2;
	
	public Chef getChef() {
		return chef2;
	}
}
