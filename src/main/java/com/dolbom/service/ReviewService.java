package com.dolbom.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.vo.ReviewVO;

public interface ReviewService {
	String insertReview(ReviewVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	ArrayList<ReviewVO> getMyReviewList(String did) throws ClassNotFoundException, SQLException;
	String updateReview(ReviewVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String deleteReview(@RequestParam(value = "rid") String rid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	ReviewVO getReviewContent(String rid) throws ClassNotFoundException, SQLException;
	boolean hideReivew(String rid) throws ClassNotFoundException, SQLException;
	
}
