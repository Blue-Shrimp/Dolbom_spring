package com.dolbom.controller.facility;

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
import com.dolbom.service.FacilityService;
import com.dolbom.utils.PagingVO;
import com.dolbom.vo.ApplyMemberVO;

@Controller
@RequestMapping("/customer/facility/")
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;

	@Autowired
	private ApplyMemberService applyMemberService;
	
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(PagingVO pvo, Model model, 
				@RequestParam(defaultValue = "")String sido,
				@RequestParam(defaultValue = "")String gugun,
				@RequestParam(defaultValue = "")String keyword,
				@RequestParam(value="nowPage", required=false)String nowPage,
				@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
				HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		
		return facilityService.getFacilityList(pvo, model, sido, gugun, keyword, nowPage, cntPerPage, request, rttr);
	}
	
	@RequestMapping(value="detail", method= RequestMethod.GET)
	public String detail(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return facilityService.getFacilityContent(fid, model, request, rttr);
	}
	
	@RequestMapping(value="application", method= {RequestMethod.GET, RequestMethod.POST})
	public String application(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return applyMemberService.getApplyPage(fid, model, request, rttr);
	}
	
	@RequestMapping(value="/apply_proc.do", method= RequestMethod.POST)
	public String apply_proc(ApplyMemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return applyMemberService.insertApply(vo, request, rttr);
	}

}
