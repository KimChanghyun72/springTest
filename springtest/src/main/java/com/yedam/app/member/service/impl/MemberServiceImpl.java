package com.yedam.app.member.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.member.MemberVO;
import com.yedam.app.member.mapper.MemberDAO;
import com.yedam.app.member.service.MemberService;

@Service //컨테이너에 빈 등록
public class MemberServiceImpl implements MemberService {

	@Autowired MemberDAO memberDAO;
	
	@Override
	public List<MemberVO> selectAll() {
		
		return memberDAO.selectAll();
	}

	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return memberDAO.selectOne(memberVO);
	}

	@Override
	public int delete(MemberVO memberVO) {
		/*boardDAO.delete(memberVO);
		noticeDAO.delte(memberVO);*/
		return memberDAO.delete(memberVO);
	}

	@Override
	public int update(MemberVO memberVO) {

		return memberDAO.update(memberVO);
	}

	@Override
	public int insert(MemberVO memberVO) {

		return memberDAO.insert(memberVO);
	}

}
