package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Student;

public interface StudentRepository2 extends JpaRepository<Student, Integer> {
	    
    @Query("select m from Student m where m.address like '인천%'")
	List<Student> getIncheon();
    
    @Query("select m from Student m where m.grade = :grade1 or "
    		+ "m.grade = :grade2")
    List<Student> getByGrade(@Param("grade1") int grade1, 
    		@Param("grade2") int grade2);
}
