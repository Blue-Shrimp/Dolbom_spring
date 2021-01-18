package com.dolbom.controller.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dolbom.service.MemberService;

@Controller
@RequestMapping("/join/")
public class JoinController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join() {
		return "join/join";
	}

}
