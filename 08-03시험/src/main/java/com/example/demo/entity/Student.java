package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="tbl_student")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
    @Column(length = 100, nullable = true)
    private String address;
    
    @Column(nullable = false)
    private int grade;
    
    @Column(length = 10, nullable = false)
	private String name;
	
}
