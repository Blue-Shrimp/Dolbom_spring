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
			if(vo.getDid().equals("admin")) {
				session.setAttribute("svo", svo);
				result = "redirect:/admin/index";	
			} else {
				session.setAttribute("svo", svo);
				result = "redirect:/index";				
			}
		}else {
			rttr.addFlashAttribute("msg", false);
			result = "redirect:/login";
		}
		
		return result;
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session, RedirectAttributes rttr) {
		SessionVO svo = (SessionVO)session.getAttribute("svo");
		String result = "";
		
		if(svo != null) {
			session.invalidate();
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/login";
		}else {
			rttr.addFlashAttribute("msg1", true);
			result = "redirect:/index";
		}
		
		return result;
	}
	
	@RequestMapping(value="/login/findId", method=RequestMethod.GET)
	public String findId() {
		return "login/findId";
	}
	
	@RequestMapping(value="/login/findId_proc.do", method=RequestMethod.POST)
	public String findId_proc(MemberVO vo, Model model, RedirectAttributes rttr, HttpSession session) throws ClassNotFoundException, SQLException {
		String id = memberService.getFindId(vo);
		String result = "";
		
		if(id.equals("")) {
			rttr.addFlashAttribute("msg", true);
			result = "redirect:/login/findId";				
		}else {
			model.addAttribute("id", id);
			result = "login/findId_success";
		}
		
		return result;
	}
	
	@RequestMapping(value="/login/findId_success", method=RequestMethod.GET)
	public String findId_success() {
		return "login/findId_success";
	}
	
	@RequestMapping(value="/login/findPass", method=RequestMethod.GET)
	public String findPass() {
		return "login/findPass";
	}
	
	@RequestMapping(value="/login/findPass_proc.do", method=RequestMethod.POST)
	public String findPass_proc(MemberVO vo, Model model, RedirectAttributes rttr, HttpSession session) throws ClassNotFoundException, SQLException {
		String pass = memberService.getFindPass(vo);
		String result = "";
		
		if(pass.equals("")) {
			rttr.addFlashAttribute("msg", true);
			result = "redirect:/login/findPass";				
		}else {
			model.addAttribute("pass", pass);
			result = "login/findPass_success";
		}
		
		return result;
	}
	
	@RequestMapping(value="/login/findPass_success", method=RequestMethod.GET)
	public String findPass_success() {
		return "login/findPass_success";
	}

}
