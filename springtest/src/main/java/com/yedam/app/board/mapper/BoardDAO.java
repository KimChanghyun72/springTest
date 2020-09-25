package com.yedam.app.board.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.board.BoardVO;

public interface BoardDAO {

	public List<BoardVO> selectAll(BoardVO boardVO);
	public void insert(BoardVO boardVO);
	public void deleteAll(BoardVO boardVO);
	public List<Map<String, Object>> selectMap(); 
	public int selectCnt();

}
