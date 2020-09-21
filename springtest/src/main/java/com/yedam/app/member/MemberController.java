package com.yedam.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	//getBean("memberDAO")
	//new MemberDAO()
	@Autowired DAO dao;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		//회원조회
		model.addAttribute("list",dao.selectAll(null));
		
		return "/member/memberAll";
	}
	
	//등록처리
	@RequestMapping("/memberInsert")
	//public String memberInsert(MemberVO vo) {
	public String memberInsert(Model model) {
		//System.out.println(vo);
		model.addAttribute("list", dao.selectOne(null));
		//return "redirect:/memberList";
		return "/member/memberList";
	}
}
