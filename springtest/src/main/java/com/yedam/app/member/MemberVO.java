package com.yedam.app.member;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberVO {
	private String id;
	private String password;
	private String job;
	private String reason;
	private String gender;
	private String mailsend;
	private String hobby;
	private String regdate;
	
}
