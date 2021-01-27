package com.dolbom.controller.facility;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.ApplyMemberService;
import com.dolbom.service.FacilityService;
import com.dolbom.service.MemberService;
import com.dolbom.service.ReviewService;
import com.dolbom.utils.PagingVO;
import com.dolbom.vo.ApplyMemberVO;
import com.dolbom.vo.FacilityVO;
import com.dolbom.vo.MemberVO;
import com.dolbom.vo.ReviewVO;
import com.dolbom.vo.SessionVO;

@Controller
@RequestMapping("/customer/facility/")
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private ReviewService reviewService;

	@Autowired
	private ApplyMemberService applyMemberService;

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(PagingVO pvo, Model model, 
				@RequestParam(defaultValue = "")String sido,
				@RequestParam(defaultValue = "")String gugun,
				@RequestParam(defaultValue = "")String keyword,
				@RequestParam(value="nowPage", required=false)String nowPage,
				@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
				HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			int total = facilityService.getCountFacility(sido, gugun, keyword);
			if (nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "10";
			} else if (nowPage == null) {
				nowPage = "1";
			} else if (cntPerPage == null) { 
				cntPerPage = "10";
			}
			
			pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			ArrayList<FacilityVO> facility_list = facilityService.getFacilityList(sido, gugun, keyword, pvo);
			model.addAttribute("sido", sido);
			model.addAttribute("gugun", gugun);
			model.addAttribute("keyword", keyword);
			model.addAttribute("paging", pvo);
			model.addAttribute("list",facility_list);
			result = "customer/facility/list";
		}
		
		return result;
	}
	
	@RequestMapping(value="detail", method= RequestMethod.GET)
	public String detail(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			FacilityVO vo = facilityService.getFacilityContent(fid);
			ArrayList<ReviewVO> review_list = reviewService.getReviewList(fid);
			int review_cnt = reviewService.getReviewCnt(fid);
			double review_score = reviewService.getReviewScore(fid);
			
			model.addAttribute("cnt", review_cnt);
			model.addAttribute("score", review_score);
			model.addAttribute("list", review_list);
			model.addAttribute("detail", vo);
			model.addAttribute("fid", fid);
			model.addAttribute("did", svo.getId());
			result = "customer/facility/detail";
		}
		
		return result;
	}
	
	@RequestMapping(value="application", method= {RequestMethod.GET, RequestMethod.POST})
	public String application(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			FacilityVO vo = facilityService.getFacilityContent(fid);
			int acnt = applyMemberService.getApplyPeople(fid);
			MemberVO mvo = memberService.getMemberContent(svo.getId());
			
			if(vo.getFpeople() == acnt) {
				rttr.addFlashAttribute("msg1", true);
				String referer = request.getHeader("Referer");
				
				result = "redirect:" + referer;
			} else {
				model.addAttribute("member", mvo);
				model.addAttribute("facility", vo);
				model.addAttribute("fid", fid);
				model.addAttribute("did", svo.getId());
				result = "customer/facility/application";
				
			}
			
		}
		
		return result;
	}
	
	@RequestMapping(value="/apply_proc.do", method= RequestMethod.POST)
	public String apply_proc(ApplyMemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			boolean apply_result = applyMemberService.insertApply(vo);
			
			if(apply_result) {
				rttr.addFlashAttribute("msg1", true);
				result = "redirect:/customer/myapply/list";				
			} else { 
				rttr.addFlashAttribute("msg1", true); String referer =
				request.getHeader("Referer");
				result = "redirect:" + referer; 
			}
				 
		}
		
		return result;
	}

}
