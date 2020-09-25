package com.yedam.app.board;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.mapper.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/*-context.xml" }) //config 안의 mybatis, datasource 다 읽어옴.
public class BoardDAOClient {
	
	@Autowired BoardDAO boardDAO;
	
	//@Test
	public void cntTest() {
		System.out.println(
				boardDAO.selectCnt()
				);
	}
	
	//@Test
	public void selectMap() {
		System.out.println(
				boardDAO.selectMap()
				);
	}
	
	//@Test
	public void deleteAllTest() {
		List<String> list = Arrays.asList(new String[] {"100","101","102","103"});  
		BoardVO vo = BoardVO.builder()
						.nos(list)
						.build();
		boardDAO.deleteAll(vo);
	}
	
	@Test
	//@Ignore
	public void selectAllTest() {
		BoardVO vo = BoardVO.builder()
						//.board_poster("test06").board_subject("TEST5")
				.first(5)
				.last(10)
				.build();
		List<BoardVO> list = boardDAO.selectAll(vo);
		for(BoardVO board : list) {
			System.out.println(board.getBoardNo() + ":" + 
								board.getBoardPoster() + ":" +
								board.getBoardSubject() + ":" +
								board.getLastpost());
			
		}
	}
	
	//@Test
	public void InsertTest() {
		BoardVO vo = BoardVO.builder()
										.poster("test")
										.subject("mybatis selectKey test")
										.contents("test")
										.build();
		boardDAO.insert(vo);
		System.out.println("글번호 : " + vo.getNo());
	}
}
