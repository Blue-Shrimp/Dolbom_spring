package com.dolbom.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.dao.ReviewDAO;
import com.dolbom.vo.ReviewVO;

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
	public ArrayList<ReviewVO> getMyReviewList(String did) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
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
	public ReviewVO getReviewContent(String rid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hideReivew(String rid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
