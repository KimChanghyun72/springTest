package com.yedam.app.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MemberDAOClient {
	
	@Autowired MemberDAO dao;
	
	@Test
	//@Ignore
	public void selectTest() {
		MemberVO memberVO = MemberVO.builder().id("testId").build();
		memberVO = dao.selectOne(memberVO);
		assertEquals("testpw", memberVO.getPassword());
	}
	
	@Test
	@Ignore //테스트를 안하도록 설정.
	public void insertTest() {
		MemberVO memberVO = MemberVO.builder().id("testId2").password("testpw2").build();  //생성자를 대신해줌.
		dao.insert(memberVO);
		//memberVO = dao.selectOne(memberVO);
		//assertNotNull( memberVO );//not null 여부 체크
		//("tetsId", memberVO.getId()); //인설트 이후 아이디에서 조회. 만약 없다면 null값 넘어올것.
	}
}
