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
	/* 각 시설의 리뷰 개수 */
	public int getReviewCnt(String fid) throws ClassNotFoundException, SQLException {
		String sql = "select count(*) cnt"
				+ " from review"
				+ " where fid=?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, fid);
		ResultSet rs = st.executeQuery();
		
		int score = 0;
		while(rs.next()) {
			score = rs.getInt(1);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return score;
	}
	
	@Override
	/* 각 시설의 리뷰 평균 */
	public double getReviewScore(String fid) throws ClassNotFoundException, SQLException {
		String sql = "select round(avg(rservice),1) rservice"
				+ " from review"
				+ " where fid=?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, fid);
		ResultSet rs = st.executeQuery();
		
		double score = 0.0;
		while(rs.next()) {
			score = rs.getDouble(1);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return score;
	}
	
	@Override
	/* 시설 리뷰 전체 목록 */
	public ArrayList<ReviewVO> getReviewList(String fid) throws ClassNotFoundException, SQLException {
		String sql = "select dname, r.did, rservice, rcontent, to_char(rdate, 'yyyy.mm.dd')"
				+ " from review r, dmember d"
				+ " where d.did = r.did and rstatus=1 and fid=?"
				+ " order by rdate desc";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, fid);
		ResultSet rs = st.executeQuery();
		
		ArrayList<ReviewVO> list_review = new ArrayList<ReviewVO>();
		while(rs.next()) {
			ReviewVO vo = new ReviewVO();
			
			vo.setDname(rs.getString(1));
			vo.setDid(rs.getString(2));
			vo.setRservice(rs.getInt(3));
			vo.setRcontent(rs.getString(4));
			vo.setRdate(rs.getString(5));
			
			list_review.add(vo);
		}
		
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
		String sql = "insert into review"
				+ " values('R_'|| seq_review.nextval,?,?,?,?,1,sysdate)";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getFid());
		st.setString(2, vo.getDid());
		st.setInt(3, vo.getRservice());
		st.setString(4, vo.getRcontent());
		
		boolean result = false;
		
		int val = st.executeUpdate();
		if(val != 0) {
			result = true;
		}
		
		st.close();
		con.close();
		
		return result;
	}
	
	@Override
	/* 내가 쓴 리뷰 */
	public ArrayList<ReviewVO> getMyReviewList(String did) throws ClassNotFoundException, SQLException {
		String sql = "select rid, fid, dname, r.did, rservice, rcontent, to_char(rdate, 'yyyy.mm.dd') rdate"
				+ " from review r, dmember d"
				+ " where d.did = r.did and r.did=?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, did);
		ResultSet rs = st.executeQuery();
		
		ArrayList<ReviewVO> list_review =  new ArrayList<ReviewVO>();
		while(rs.next()) {
			ReviewVO vo = new ReviewVO();
			
			vo.setRid(rs.getString(1));
			vo.setFid(rs.getString(2));
			vo.setDname(rs.getString(3));
			vo.setDid(rs.getString(4));
			vo.setRservice(rs.getInt(5));
			vo.setRcontent(rs.getString(6));
			vo.setRdate(rs.getString(7));
			
			list_review.add(vo);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list_review;
	}
	
	@Override
	/* 리뷰 수정 */
	public boolean updateReview(ReviewVO vo) throws ClassNotFoundException, SQLException {
		String sql = "update review"
				+ " set rservice=?, rcontent=?"
				+ " where rid=?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, vo.getRservice());
		st.setString(2, vo.getRcontent());
		st.setString(3, vo.getRid());
		
		boolean result = false;
		
		int val = st.executeUpdate();
		if(val != 0) {
			result = true;
		}
		
		st.close();
		con.close();
		
		return result;
	}
	
	@Override
	/* 리뷰 삭제하기 */
	public boolean deleteReview(String rid) throws ClassNotFoundException, SQLException {
		String sql = "delete from review where rid=?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, rid);
		
		boolean result = false;
		
		int val = st.executeUpdate();
		if(val != 0) {
			result = true;
		}
		
		st.close();
		con.close();
		
		return result;
	}

}
