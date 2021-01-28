package com.dolbom.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dolbom.vo.ReviewVO;

public interface ReviewService {
	int getReviewCnt(String fid) throws ClassNotFoundException, SQLException;
	double getReviewScore(String fid) throws ClassNotFoundException, SQLException;
	ArrayList<ReviewVO> getReviewList(String fid) throws ClassNotFoundException, SQLException;
	ReviewVO getReviewContent(String rid) throws ClassNotFoundException, SQLException;
	boolean hideReivew(String rid) throws ClassNotFoundException, SQLException;
	boolean insertReview(ReviewVO vo) throws ClassNotFoundException, SQLException;
	ArrayList<ReviewVO> getMyReviewList(String did) throws ClassNotFoundException, SQLException;
	boolean updateReview(ReviewVO vo) throws ClassNotFoundException, SQLException;
	boolean deleteReview(String rid) throws ClassNotFoundException, SQLException;
	
}
