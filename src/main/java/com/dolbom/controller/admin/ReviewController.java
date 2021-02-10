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

import com.dolbom.service.ReviewService;
import com.dolbom.utils.PagingVO;

@Controller("adminReviewController")
@RequestMapping("/admin/review/")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(PagingVO pvo, Model model,
			@RequestParam(defaultValue = "")String keyword,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage,
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		
		return reviewService.getReviewList(pvo, model, keyword, nowPage, cntPerPage, request, rttr);
	}
	
	@RequestMapping(value="detail", method= RequestMethod.GET)
	public String detail(@RequestParam(value = "rid") String rid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return reviewService.getReviewContent(rid, model, request, rttr);
	}
	
	@RequestMapping(value="hideProc.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String hideProc(@RequestParam(value = "rid") String rid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return reviewService.hideReivew(rid, model, request, rttr);
	}
	
	@RequestMapping(value="hideCancelProc.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String hideCancelProc(@RequestParam(value = "rid") String rid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return reviewService.hideCancelReivew(rid, model, request, rttr);
	}

}
