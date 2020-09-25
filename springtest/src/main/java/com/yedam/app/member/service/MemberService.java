package com.yedam.app.member.service;

import java.util.ArrayList;
import java.util.List;

import com.yedam.app.member.MemberVO;

public interface MemberService {

	List<MemberVO> selectAll();

	MemberVO selectOne(MemberVO memberVO);

	int delete(MemberVO memberVO);//end of delete

	int update(MemberVO memberVO);//end of update

	int insert(MemberVO memberVO);//end of insert

}