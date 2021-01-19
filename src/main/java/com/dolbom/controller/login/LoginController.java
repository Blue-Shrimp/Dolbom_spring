package com.dolbom.controller.login;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.MemberService;
import com.dolbom.service.dao.MemberDAO;
import com.dolbom.vo.MemberVO;
import com.dolbom.vo.SessionVO;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login_proc.do", method=RequestMethod.POST)
	public String login_proc(MemberVO vo, RedirectAttributes rttr, HttpSession session) throws ClassNotFoundException, SQLException {
		SessionVO svo = memberService.getLogin(vo);
		String result = "";
		
		if(svo.getResult() != 0) {
			session.setAttribute("svo", svo);
			result = "redirect:/index";
		}else {
			rttr.addFlashAttribute("msg", false);
			result = "redirect:/login";
		}
		
		return result;
	}
	
	@RequestMapping(value="/login/findId", method=RequestMethod.GET)
	public String findId() {
		return "login/findId";
	}
	
	@RequestMapping(value="/login/findPass", method=RequestMethod.GET)
	public String findPass() {
		return "login/findPass";
	}

}
