package com.dolbom.service.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolbom.vo.ReviewVO;

@Service
public class ReviewDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession; 
	
	private static String namespace = "mapper.review";
	
	/* 각 시설의 리뷰 개수 */
	public int getReviewCnt(String fid) throws ClassNotFoundException, SQLException {
		return sqlSession.selectOne(namespace +".count",fid);
	}
	
	/* 각 시설의 리뷰 평균 */
	public double getReviewScore(String fid) throws ClassNotFoundException, SQLException {
		double result = 0.0;
		
		if(sqlSession.selectOne(namespace +".score",fid) == null) {
			result = 0.0;
		} else {
			result = sqlSession.selectOne(namespace +".score",fid);
		}
		
		return result;
	}
	
	/* 시설 리뷰 전체 목록 */
	public ArrayList<ReviewVO> getReviewList(String fid) throws ClassNotFoundException, SQLException {
		List<ReviewVO> list = sqlSession.selectList(namespace+".list", fid);
		return (ArrayList<ReviewVO>)list;
	}
	
	/* 리뷰 등록 */
	public boolean insertReview(ReviewVO vo) throws ClassNotFoundException, SQLException {
		boolean result = false;
		int value = sqlSession.insert(namespace+".insertReview", vo);
		if(value != 0) result = true;
		return result;
	}
	
	/* 내가 쓴 리뷰 */
	public ArrayList<ReviewVO> getMyReviewList(String did) throws ClassNotFoundException, SQLException {
		List<ReviewVO> list = sqlSession.selectList(namespace+".myReviewList", did);
		return (ArrayList<ReviewVO>)list;
	}
	
	/* 리뷰 수정 */
	public boolean updateReview(ReviewVO vo) throws ClassNotFoundException, SQLException {
		boolean result = false;
		int value = sqlSession.update(namespace+".update", vo);
		if(value != 0) result = true;
		return result; 
	}
	
	/* 리뷰 삭제하기 */
	public boolean deleteReview(String rid) throws ClassNotFoundException, SQLException {
		boolean result = false;
		int value = sqlSession.delete(namespace+".delete", rid);
		if(value != 0) result = true;
		return result;
	}
	
	/* 리뷰 상세 정보 */
	public ReviewVO getReviewContent(String rid) throws ClassNotFoundException, SQLException {
		ReviewVO vo = new ReviewVO();
		
		return vo;
	}
	
	/* 리뷰 숨기기 */
	public boolean hideReivew(String rid) throws ClassNotFoundException, SQLException {
		boolean result = false;
		
		return result;
	}

}
