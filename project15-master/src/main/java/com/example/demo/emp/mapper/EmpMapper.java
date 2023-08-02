package com.example.demo.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.emp.domain.EmpDto;

@Mapper
public interface EmpMapper {
	
	public int insert(EmpDto dto);
	
	public List<EmpDto> selectList();
	
	public EmpDto select(int empNo);
	
	public int update(EmpDto dto);
	
	public int delete(int empNo);

}

