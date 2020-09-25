package com.yedam.app.member.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

import com.yedam.app.member.MemberVO;
import com.yedam.app.member.mapper.MemberDAO;
import com.yedam.app.member.service.MemberService;

@Controller
public class MemberController {
	
	//getBean("memberDAO")
	//new MemberDAO()
	@Autowired MemberService memberService;
	
	
	@RequestMapping("/memberOneAjax")
	@ResponseBody  //ajax값으로 넘겨줌.
	public MemberVO memberOneAjax(MemberVO memberVO) {
		//회원조회
		return memberService.selectOne(memberVO);
	}
	
	
	
	@RequestMapping("/memberListAjax")
	@ResponseBody  //ajax값으로 넘겨줌.
	public List<MemberVO> memberListAjax() {
		//회원조회
		return memberService.selectAll();
	}

	
	@RequestMapping("/memberList.do")
	public String memberList(Model model,
							 HttpServletRequest request, 
							 HttpSession session) {
		//회원조회
		model.addAttribute("list",memberService.selectAll());
		return "/member/memberAll";
	}
	//등록페이지
	@RequestMapping(value ="/memberInsert", method=RequestMethod.GET)
	public  String memberInsertForm() {
		return "member/memberInsert";
	}
	
	
	//등록처리
	@RequestMapping(value="/memberInsert", 
						method=RequestMethod.POST)
	public String memberInsert(MemberVO memberVO) {
	//public String memberInsert(Model model) {
		memberService.insert(memberVO);
		//System.out.println(vo);
		//model.addAttribute("list", memberService.selectOne(null));
		//return "redirect:/memberList";
		return "redirect:/memberList.do";
	}
	
	@RequestMapping(value="/memberSelect") 
	public String memberSelect(@RequestParam(name="id", //String mid = request.getParameter("id"); 아이디 파라미터 필수
												required = false,
												defaultValue = "36"  //if(id != null) {id="36"}
												) String mid, 
								Model model,
								HttpServletRequest request) {
		//String mid = request.getParameter("id"); //옛날방식
		
		MemberVO vo = new MemberVO();
		vo.setId(mid);
		model.addAttribute("member", memberService.selectOne(vo));
		return "member/memberSelect";
	}
	//경로명에 변수가 포함된 경우(pathvariable)
	@RequestMapping("/userSelectPath/{id}/{password}") //파라미터가 여러개라면 /userSelectPath/{id}/{password}/.... 와 같이 사용가능.
	public String userSelectPath(Model model, @PathVariable String id, String password) {
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		model.addAttribute("member", memberService.selectOne(vo));
		return "member/memberSelect";
	}
	
	//parameter를 map에 
	@RequestMapping("/userSelectMap")
	public String userSelectMap(@RequestParam Map map) {
		System.out.println(map);
		return "";
	}
}
