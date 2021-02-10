package com.dolbom.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.utils.PagingVO;
import com.dolbom.vo.ReviewVO;

public interface ReviewService {
	String insertReview(ReviewVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String updateReview(ReviewVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String deleteReview(@RequestParam(value = "rid") String rid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getReviewList(PagingVO pvo, Model model,
			@RequestParam(defaultValue = "")String keyword,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage,
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getReviewContent(@RequestParam(value = "rid") String rid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String hideReivew(@RequestParam(value = "rid") String rid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String hideCancelReivew(@RequestParam(value = "rid") String rid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	
}
