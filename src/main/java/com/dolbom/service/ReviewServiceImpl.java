package com.dolbom.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.dao.ReviewDAO;
import com.dolbom.utils.PagingVO;
import com.dolbom.vo.ReviewVO;
import com.dolbom.vo.SessionVO;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDAO reviewDAO;

	@Override
	public String insertReview(ReviewVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			boolean insert_result = reviewDAO.insertReview(vo);
			
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

	@Override
	public String updateReview(ReviewVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			boolean update_result = reviewDAO.updateReview(vo);
			
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

	@Override
	public String deleteReview(@RequestParam(value = "rid") String rid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			boolean delete_result = reviewDAO.deleteReview(rid);
			
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
	
	@Override
	public String getReviewList(PagingVO pvo, Model model,
			@RequestParam(defaultValue = "")String keyword,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage,
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			int total = reviewDAO.getReviewCntSearch(keyword);
			if (nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "10";
			} else if (nowPage == null) {
				nowPage = "1";
			} else if (cntPerPage == null) { 
				cntPerPage = "10";
			}
			
			pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			ArrayList<ReviewVO> review_list = reviewDAO.getReviewListSearch(keyword, pvo);
			model.addAttribute("keyword", keyword);
			model.addAttribute("paging", pvo);
			model.addAttribute("list",review_list);
			result = "admin/review/list";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}

	@Override
	public String getReviewContent(@RequestParam(value = "rid") String rid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			ReviewVO vo = reviewDAO.getReviewContent(rid);
			vo.setRcontent(vo.getRcontent().replace("\r\n", "<br>"));
			
			model.addAttribute("detail", vo);
			model.addAttribute("rid", rid);
			result = "admin/review/detail";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}

	@Override
	public String hideReivew(@RequestParam(value = "rid") String rid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			boolean hide_result = reviewDAO.hideReivew(rid);
			
			if(hide_result) {
				rttr.addFlashAttribute("msg1", true);
				result = "redirect:/admin/review/list";
			} else {
				rttr.addFlashAttribute("msg2", true); 
				String referer = request.getHeader("Referer");
				result = "redirect:" + referer;
			}
			
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}
	
	@Override
	public String hideCancelReivew(@RequestParam(value = "rid") String rid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			boolean hide_cancel_result = reviewDAO.hideCancelReivew(rid);
			
			if(hide_cancel_result) {
				rttr.addFlashAttribute("msg3", true);
				result = "redirect:/admin/review/list";
			} else {
				rttr.addFlashAttribute("msg4", true); 
				String referer = request.getHeader("Referer");
				result = "redirect:" + referer;
			}
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}

}
