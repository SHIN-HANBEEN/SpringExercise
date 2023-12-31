package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Subject {
	String subjectName;

	public Subject(String subjectName, Teacher teacher) {
		super();
		this.subjectName = subjectName;
		this.teacher = teacher;
	}

	@Autowired
	Teacher teacher;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return teacher + this.subjectName;
	}
}
