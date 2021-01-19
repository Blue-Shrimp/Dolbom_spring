package com.dolbom.controller.join;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dolbom.service.MemberService;
import com.dolbom.service.dao.MemberDAO;

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
		int result = memberService.getIdCheck(did);
		
		return String.valueOf(result);
	}

}
