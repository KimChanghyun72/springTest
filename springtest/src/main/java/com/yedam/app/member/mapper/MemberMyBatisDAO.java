package com.yedam.app.member.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.member.MemberVO;

//@Repository   //component도 가능하다.
public class MemberMyBatisDAO implements MemberDAO{
	
	@Autowired SqlSessionTemplate sqlsession;
	
	//전체조회
	@Override
	public List<MemberVO> selectAll() {
		System.out.println("mybatis selectAll");
		return sqlsession.selectList("memberDAO.selectAll");
		//member_mapper의 namespace + 메소드명
	}

	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		System.out.println("mybatis selectOne");
		return sqlsession.selectOne("memberDAO.selectOne", memberVO);
	}

	@Override
	public int delete(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
