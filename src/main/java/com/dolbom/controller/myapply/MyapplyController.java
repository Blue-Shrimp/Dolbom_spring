package com.dolbom.controller.myapply;

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
import com.dolbom.service.ReviewService;
import com.dolbom.vo.ReviewVO;

@Controller
@RequestMapping("/customer/myapply/")
public class MyapplyController {
	
	@Autowired
	private ApplyMemberService applyMemberService;
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return applyMemberService.getMyApplyList(model, request, rttr);
	}
	
	@RequestMapping(value="/reviewInsert_proc.do", method= RequestMethod.POST)
	public String reviewInsert_proc(ReviewVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return reviewService.insertReview(vo, request, rttr);
	}
	
	@RequestMapping(value="/reviewDelete_proc.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String reviewDelete_proc(@RequestParam(value = "rid") String rid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return reviewService.deleteReview(rid, request, rttr);
	}
	
	@RequestMapping(value="/reviewUpdate_proc.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String reviewUpate_proc(ReviewVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return reviewService.updateReview(vo, request, rttr);
	}
	
	@RequestMapping(value="detail", method= RequestMethod.GET)
	public String detail(@RequestParam(value = "aid") String aid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return applyMemberService.getApplyContent(aid, model, request, rttr);
	}
	
	@RequestMapping(value="/applyDelete_proc.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String applyDelete_proc(@RequestParam(value = "aid") String aid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return applyMemberService.deleteApply(aid, request, rttr);
	}

}
