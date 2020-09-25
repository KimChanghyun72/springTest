package com.yedam.app.board;

import java.util.List;

import com.yedam.app.member.MemberVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor  //?
@AllArgsConstructor  //?
public class BoardVO {
	private Integer boardNo;
	private String boardPoster;
	private String boardSubject;
	private String contents;
	private String lastpost;
	private Integer views;
	private String filename;
	private String sortCol;
	private List<String> nos;
	private MemberVO member; //작성자.
	private int first;
	private int last;
	
	
}
