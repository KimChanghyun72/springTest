package com.yedam.app.member.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.yedam.app.member.MemberVO;

//@Component
public class MemberSpringDAO implements MemberDAO{

	@Autowired JdbcTemplate template;
	
	final static String INSERT_MEMBER = "INSERT INTO MEMBER (ID, PASSWORD, JOB, REASON, GENDER, MAILSEND, HOBBY, REGDATE) "
			+ " VALUES (?,?,?,?,?,?,?,SYSDATE) ";
	
	final static String DELETE_MEMBER = "DELETE FROM MEMBER WHERE ID=?";
	final static String SELECT_MEMBER = " SELECT * FROM MEMBER WHERE ID=?";
	final static String SELECT_ALL_MEMBER = "SELECT * FROM MEMBER";
	
	@Override
	public ArrayList<MemberVO> selectAll() {
		return (ArrayList<MemberVO>) template.query(SELECT_ALL_MEMBER, new MemberRowMapper());
	}

	
	@Override
	public int delete(MemberVO memberVO) {
		return template.update(DELETE_MEMBER, memberVO.getId());
	}

	
	@Override
	public int insert(MemberVO memberVO) {
		Object[] args = {memberVO.getId(), memberVO.getPassword(), memberVO.getJob(), memberVO.getReason(), memberVO.getGender(),
				memberVO.getMailsend(), memberVO.getHobby()};
		//template.update(INSERT_MEMBER, args);
		return template.update(INSERT_MEMBER, args);
	}
	

	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		Object[] args = {memberVO.getId()}; //배열로만 넘겨줄 수 있음..
		return template.queryForObject(SELECT_MEMBER, args, new MemberRowMapper());
	}


	@Override
	public int update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	class MemberRowMapper implements RowMapper<MemberVO>{

		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO resultVO = new MemberVO();
			resultVO.setId(rs.getString("id"));
			resultVO.setPassword(rs.getString("password"));
			resultVO.setJob(rs.getString("job"));
			resultVO.setReason(rs.getString("reason"));
			resultVO.setGender(rs.getString("gender"));
			resultVO.setMailsend(rs.getString("mailsend"));
			resultVO.setHobby(rs.getString("hobby"));
			resultVO.setRegdate(rs.getString("regdate"));
			return resultVO;
		}
		
	}

}
