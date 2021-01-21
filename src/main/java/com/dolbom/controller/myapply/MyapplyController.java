package com.dolbom.controller.myapply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dolbom.service.ApplyMemberService;

@Controller
@RequestMapping("/customer/myapply/")
public class MyapplyController {
	
	@Autowired
	private ApplyMemberService applyMemberService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list() {
		return "customer/myapply/list";
	}

}
