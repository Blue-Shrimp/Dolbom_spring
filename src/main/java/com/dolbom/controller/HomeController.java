package com.dolbom.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dolbom.service.MemberService;
import com.dolbom.vo.MemberVO;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private MemberService indexService;
	
	@RequestMapping("index")
	public String index(Model model) throws ClassNotFoundException, SQLException {
		ArrayList<MemberVO> list = indexService.getList();
		model.addAttribute("list", list);
		
		return "index";
	}

	//@Override
	//public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	
	//	ModelAndView mv = new ModelAndView("root.index");
	//	//mv.setViewName("/WEB-INF/view/index.jsp");
	//	
	//	ArrayList<Index> list = indexService.getList();
	//	mv.addObject("list", list);
	//	
	//	return mv;
	//}
	
}
