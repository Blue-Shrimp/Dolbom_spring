package com.dolbom.controller.myapply;

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
import com.dolbom.service.ReviewService;
import com.dolbom.vo.ApplyMemberVO;
import com.dolbom.vo.FacilityVO;
import com.dolbom.vo.ReviewVO;
import com.dolbom.vo.SessionVO;

@Controller
@RequestMapping("/customer/myapply/")
public class MyapplyController {
	
	@Autowired
	private ApplyMemberService applyMemberService;
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			ArrayList<ApplyMemberVO> apply_list = applyMemberService.getMyApplyList(svo.getId());
			ArrayList<ReviewVO> review_list = reviewService.getMyReviewList(svo.getId());
			
			model.addAttribute("review_list", review_list);
			model.addAttribute("did",svo.getId());
			model.addAttribute("list", apply_list);
			result = "customer/myapply/list";
		}
		
		return result;
	}
	
	@RequestMapping(value="/reviewInsert_proc.do", method= RequestMethod.POST)
	public String reviewInsert_proc(ReviewVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			boolean insert_result = reviewService.insertReview(vo);
			
			if(insert_result) {
				rttr.addFlashAttribute("msg2", true);
				result = "redirect:/customer/myapply/list";				
			} else { 
				rttr.addFlashAttribute("msg3", true); 
				String referer = request.getHeader("Referer");
				result = "redirect:" + referer; 
			}
				 
		}
		
		return result;
	}
	
	@RequestMapping(value="/reviewDelete_proc.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String reviewDelete_proc(@RequestParam(value = "rid") String rid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			boolean delete_result = reviewService.deleteReview(rid);
			
			if(delete_result) {
				rttr.addFlashAttribute("msg4", true);
				result = "redirect:/customer/myapply/list";				
			} else { 
				rttr.addFlashAttribute("msg5", true); 
				String referer = request.getHeader("Referer");
				result = "redirect:" + referer; 
			}
				 
		}
		
		return result;
	}
	
	@RequestMapping(value="/reviewUpdate_proc.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String reviewUpate_proc(ReviewVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			boolean update_result = reviewService.updateReview(vo);
			
			if(update_result) {
				rttr.addFlashAttribute("msg6", true);
				result = "redirect:/customer/myapply/list";				
			} else { 
				rttr.addFlashAttribute("msg7", true); 
				String referer = request.getHeader("Referer");
				result = "redirect:" + referer; 
			}
				 
		}
		
		return result;
	}
	
	@RequestMapping(value="detail", method= RequestMethod.GET)
	public String detail(@RequestParam(value = "aid") String aid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			
			model.addAttribute("aid", aid);
			model.addAttribute("did", svo.getId());
			result = "customer/myapply/detail";
		}
		
		return result;
	}

}
