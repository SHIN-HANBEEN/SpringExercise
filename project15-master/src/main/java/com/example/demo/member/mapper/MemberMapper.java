package com.example.demo.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.member.domain.MemberDto;

@Mapper
public interface MemberMapper {
	
	public int insert(MemberDto dto);
	
	public List<MemberDto> selectList();
	
	public MemberDto select(String id);
	
	public int update(MemberDto dto);
	
	public int delete(String id);
	
}

