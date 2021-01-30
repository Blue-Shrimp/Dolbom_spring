package com.dolbom.controller.mypage;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.MemberService;
import com.dolbom.vo.MemberVO;
import com.dolbom.vo.SessionVO;

@Controller
@RequestMapping("/customer/mypage/")
public class MypageController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String list(Model model,HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return memberService.getMemberContent(model, request, rttr);
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(Model model,HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO)obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			model.addAttribute("did",svo.getId());
			result = "customer/mypage/delete";
		}
		
		return result;
	}
	
	@RequestMapping(value="memberDeleteProc.do", method=RequestMethod.POST)
	public String memberDeleteProc(Model model,HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return memberService.deleteMember(model, request, rttr);
	}
	
	@RequestMapping(value="passEdit", method=RequestMethod.GET)
	public String passEdit(Model model,HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO)obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			model.addAttribute("did",svo.getId());
			result = "customer/mypage/passEdit";
		}
		
		return result;
	}
	
	@RequestMapping(value="passEditProc.do", method=RequestMethod.POST)
	public String passEditProc(MemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return memberService.passEdit(vo, request, rttr);
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(Model model,HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return memberService.getMemberUpdateContent(model, request, rttr);
	}
	
	@RequestMapping(value="memberUpdateProc.do", method=RequestMethod.POST)
	public String memberUpdateProc(MemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return memberService.updateMember(vo, request, rttr);
	}

}
