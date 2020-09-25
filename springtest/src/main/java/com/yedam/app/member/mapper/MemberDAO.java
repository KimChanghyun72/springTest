package com.yedam.app.member.mapper;

import java.util.List;

import com.yedam.app.member.MemberVO;

public interface MemberDAO {
	//전체조회
	List<MemberVO> selectAll();
	//단건조회
	MemberVO selectOne(MemberVO memberVO);
	//삭제
	int delete(MemberVO memberVO);//end of delete
	//수정
	int update(MemberVO memberVO);//end of update
	//등록
	int insert(MemberVO memberVO);//end of insert

}