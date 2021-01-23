package com.dolbom.controller.myapply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.ApplyMemberService;

@Controller
@RequestMapping("/customer/myapply/")
public class MyapplyController {
	
	@Autowired
	private ApplyMemberService applyMemberService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(HttpServletRequest request, RedirectAttributes rttr) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			result = "customer/myapply/list";
		}
		
		return result;
	}

}
