package com.dolbom.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolbom.service.ReviewService;
import com.dolbom.vo.FacilityVO;
import com.dolbom.vo.ReviewVO;

@Service
public class ReviewDAO implements ReviewService {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	/* 각 시설의 리뷰 평균 */
	public double getReviewScore(String fid) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		double score = 0.0;
		
		rs.close();
		st.close();
		con.close();
		
		return score;
	}
	
	@Override
	/* 리뷰 전체 목록 */
	public ArrayList<ReviewVO> getReviewList() throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<ReviewVO> list_review =  new ArrayList<ReviewVO>();
		
		rs.close();
		st.close();
		con.close();
		
		return list_review;
	}
	
	@Override
	/* 리뷰 상세 정보 */
	public ReviewVO getReviewContent(String rid) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ReviewVO vo = new ReviewVO();
		
		rs.close();
		st.close();
		con.close();
		
		return vo;
	}
	
	@Override
	/* 리뷰 숨기기 */
	public boolean hideReivew(String rid) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		boolean result = false;
		
		rs.close();
		st.close();
		con.close();
		
		return result;
	}
	
	@Override
	/* 리뷰 등록 */
	public boolean insertReview(ReviewVO vo) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		boolean result = false;
		
		rs.close();
		st.close();
		con.close();
		
		return result;
	}
	
	@Override
	/* 내가 쓴 리뷰 */
	public ArrayList<ReviewVO> getMyReviewList(String did) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<ReviewVO> list_review =  new ArrayList<ReviewVO>();
		
		rs.close();
		st.close();
		con.close();
		
		return list_review;
	}
	
	@Override
	/* 리뷰 수정 */
	public boolean updateReview(String rcontent, String rid) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		boolean result = false;
		
		rs.close();
		st.close();
		con.close();
		
		return result;
	}
	
	@Override
	/* 리뷰 삭제하기 */
	public boolean deleteReview(String rid) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		boolean result = false;
		
		rs.close();
		st.close();
		con.close();
		
		return result;
	}

}
