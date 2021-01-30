package com.dolbom.controller.join;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.MemberService;
import com.dolbom.vo.MemberVO;

@Controller
@RequestMapping("/join/")
public class JoinController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join() {
		return "join/join";
	}
	
	@RequestMapping(value="/idCheck.do", method=RequestMethod.GET)
	@ResponseBody
	public String idCheck(String did) throws ClassNotFoundException, SQLException {
		return memberService.getIdCheck(did);
	}
	
	@RequestMapping(value="/join_proc.do", method=RequestMethod.POST)
	public String join_proc(RedirectAttributes rttr, MemberVO vo) throws ClassNotFoundException, SQLException {
		return memberService.insertMember(rttr, vo);
	}

}
