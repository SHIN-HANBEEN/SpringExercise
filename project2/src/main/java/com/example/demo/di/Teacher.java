package com.example.demo.di;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class Teacher {
	String name;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Teacher : " + name;
	}
}
