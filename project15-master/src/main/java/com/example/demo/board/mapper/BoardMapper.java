package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.domain.BoardDto;

@Mapper
public interface BoardMapper {
	
	public void insert(BoardDto dto);
	
	public List<BoardDto> selectList();
	
	public BoardDto select(int no);
	
	public int update(BoardDto dto);
	
	public int delete(int no);
	
}

