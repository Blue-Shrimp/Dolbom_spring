package com.dolbom.service.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolbom.utils.PagingVO;
import com.dolbom.vo.ApplyMemberVO;

@Service
public class ApplyMemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession; 
	
	private static String namespace = "mapper.applyMember";
	
	/* 각 시설의 신청한 사람의 수 */
	public int getApplyPeople(String fid) throws ClassNotFoundException, SQLException {
		return sqlSession.selectOne(namespace +".applyPeople",fid);
	}
	
	/* 신청할 때 동일한 정보 확인 */
	public int getCheckApply(ApplyMemberVO vo) throws ClassNotFoundException, SQLException {
		return sqlSession.selectOne(namespace +".checkApply",vo);
	}
	
	/* 돌봄 신청 등록 */
	public boolean insertApply(ApplyMemberVO vo) throws ClassNotFoundException, SQLException {
		boolean result = false;
		int value = sqlSession.insert(namespace+".insertApply", vo);
		if(value != 0) result = true;
		return result;
	}
	
	/* 돌봄 신청 내역 */
	public ArrayList<ApplyMemberVO> getMyApplyList(String did) throws ClassNotFoundException, SQLException {
		List<ApplyMemberVO> list = sqlSession.selectList(namespace+".myApplyList", did);
		return (ArrayList<ApplyMemberVO>)list;
	}
	
	/* 돌봄 신청 상세 정보 */
	public ApplyMemberVO getApplyContent(String aid) throws ClassNotFoundException, SQLException {
		return sqlSession.selectOne(namespace +".applyContent",aid);
	}
	
	/* 돌봄 신청 삭제 */
	public boolean deleteApply(String aid) throws ClassNotFoundException, SQLException {
		boolean result = false;
		int value = sqlSession.delete(namespace+".delete", aid);
		if(value != 0) result = true;
		return result;
	}
	
	/* 돌봄 신청 아동 수(검색) */
	public int getApplyCountSearch(String status, String keyword) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("status", status);
		param.put("keyword", keyword);
		
		return sqlSession.selectOne(namespace +".cntSearch",param);
	}
	
	/* 돌봄 신청 아동 목록 (페이징 + 검색)*/
	public ArrayList<ApplyMemberVO> getApplyList(String status, String keyword, PagingVO pvo) throws ClassNotFoundException, SQLException {
		Map<String,String> param = new HashMap<String,String>();
		param.put("status", status);
		param.put("keyword", keyword);
		param.put("start", String.valueOf(pvo.getStart()));
		param.put("end", String.valueOf(pvo.getEnd()));
		
		List<ApplyMemberVO> list = sqlSession.selectList(namespace+".listSearch", param);
		return (ArrayList<ApplyMemberVO>)list;
	}
	
	/* 돌봄 신청 상세 정보(관리자) */
	public ApplyMemberVO getApplyContentAdmin(String aid) throws ClassNotFoundException, SQLException {
		return sqlSession.selectOne(namespace +".applyContentAdmin",aid);
	}
	
	/* 돌봄 신청 아동 상태 처리 */
	public boolean updateApply(ApplyMemberVO vo) throws ClassNotFoundException, SQLException {
		boolean result = false;
		int value = sqlSession.update(namespace+".update", vo);
		if(value != 0) result = true;
		return result;
	}
	
	/* 수혜자 아동 수 */
	public int getBenefitCount(String status, String facility, String name) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("status", status);
		param.put("facility", facility);
		param.put("name", name);
		
		return sqlSession.selectOne(namespace +".benefitCnt",param);
	}
	
	/* 수혜자 아동 목록 */
	public ArrayList<ApplyMemberVO> getBenefitList(String status, String facility, String name, PagingVO pvo) throws ClassNotFoundException, SQLException {
		Map<String,String> param = new HashMap<String,String>();
		param.put("status", status);
		param.put("facility", facility);
		param.put("name", name);
		param.put("start", String.valueOf(pvo.getStart()));
		param.put("end", String.valueOf(pvo.getEnd()));
		
		List<ApplyMemberVO> list = sqlSession.selectList(namespace+".listBenefit", param);
		return (ArrayList<ApplyMemberVO>)list;
	}
	
	/* 수혜자 아동 상세 정보 */
	public ApplyMemberVO getBenefitContent(String aid) throws ClassNotFoundException, SQLException {
		return sqlSession.selectOne(namespace +".benefitContent",aid);
	}

	/* 수혜자 아동 상태 변경 */
	public boolean updateBenefit(ApplyMemberVO vo) throws ClassNotFoundException, SQLException {
		boolean result = false;
		int value = sqlSession.update(namespace+".updateBenefit", vo);
		if(value != 0) result = true;
		return result;
	}
	

}
