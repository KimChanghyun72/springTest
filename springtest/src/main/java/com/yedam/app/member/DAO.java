package com.yedam.app.member;

import java.util.ArrayList;

public interface DAO {

	ArrayList<MemberVO> selectAll(MemberVO memberVO);

	MemberVO selectOne(MemberVO memberVO);

	int delete(MemberVO memberVO);//end of delete

	void update(MemberVO memberVO);//end of update

	int insert(MemberVO memberVO);//end of insert

}