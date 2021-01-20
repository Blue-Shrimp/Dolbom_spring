package com.dolbom.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("adminHomeController")
@RequestMapping("/admin/")
public class HomeController {
	
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index() {
		return "admin/index";
	}

}
