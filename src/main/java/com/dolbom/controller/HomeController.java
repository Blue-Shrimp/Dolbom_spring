package com.dolbom.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.dao.FacilityDAO;
import com.dolbom.service.dao.NoticeDAO;
import com.dolbom.vo.FacilityVO;
import com.dolbom.vo.NoticeVO;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private FacilityDAO facilityDAO;
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@RequestMapping("index")
	public String index(Model model, HttpServletRequest request, RedirectAttributes rttr) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			ArrayList<NoticeVO> n_list = noticeDAO.getIndexNotice();
			ArrayList<FacilityVO> f_list = facilityDAO.getIndexFacility();
			
			model.addAttribute("n_list",n_list);
			model.addAttribute("f_list",f_list);
			result = "index";
		}
		
		return result;
	}
	
	@RequestMapping("customer/service/introduce")
	public String introduce(HttpServletRequest request, RedirectAttributes rttr) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			result = "customer/service/introduce";
		}
		
		return result;
	}
	
}
