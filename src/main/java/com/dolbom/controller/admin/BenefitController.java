package com.dolbom.controller.admin;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.ApplyMemberService;
import com.dolbom.utils.PagingVO;
import com.dolbom.vo.ApplyMemberVO;

@Controller("adminBenefitController")
@RequestMapping("/admin/benefitMember/")
public class BenefitController {
	
	@Autowired
	private ApplyMemberService applyMemberService;
	
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(PagingVO pvo, Model model, 
			@RequestParam(defaultValue = "")String status,
			@RequestParam(defaultValue = "")String facility,
			@RequestParam(defaultValue = "")String name,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		
			return applyMemberService.getBenefitList(pvo, model, status, facility, name, nowPage, cntPerPage, request, rttr);
	}
	
	@RequestMapping(value="detail", method= RequestMethod.GET)
	public String detail(@RequestParam(value = "aid") String aid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return applyMemberService.getBenefitContent(aid, model, request, rttr);
	}
	
	@RequestMapping(value="benefit_update.do", method= RequestMethod.POST)
	public String benefit_update(ApplyMemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		
		return applyMemberService.updateBenefit(vo, request, rttr);
	}

}
