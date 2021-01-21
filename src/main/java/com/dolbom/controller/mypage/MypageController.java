package com.dolbom.controller.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dolbom.service.MemberService;

@Controller
@RequestMapping("/customer/mypage/")
public class MypageController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String list() {
		return "customer/myapply/detail";
	}

}
