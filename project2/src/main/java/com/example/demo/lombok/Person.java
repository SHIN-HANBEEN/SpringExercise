package com.example.demo.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	String name;
	int age;

}
