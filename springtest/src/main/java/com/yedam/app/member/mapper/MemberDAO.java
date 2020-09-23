package com.yedam.app.member.mapper;

import java.util.ArrayList;

import com.yedam.app.member.MemberVO;

public interface MemberDAO {

	ArrayList<MemberVO> selectAll();

	MemberVO selectOne(MemberVO memberVO);

	int delete(MemberVO memberVO);//end of delete

	int update(MemberVO memberVO);//end of update

	int insert(MemberVO memberVO);//end of insert

}