package com.dolbom.service.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	/* 돌봄 신청 아동 목록 */
	public ArrayList<ApplyMemberVO> getApplyList() throws ClassNotFoundException, SQLException {
		ArrayList<ApplyMemberVO> list_apply = new ArrayList<ApplyMemberVO>();
		
		return list_apply;
	}
	
	/* 돌봄 신청 아동 승인 */
	public boolean approvalApply(String aid) throws ClassNotFoundException, SQLException {
		boolean result = false;
		
		return result;
	}
	
	/* 돌봄 신청 아동 미승인 */
	public boolean rejectApply(String aid) throws ClassNotFoundException, SQLException {
		boolean result = false;
		
		return result;
	}
	
	/* 수혜자 아동 목록 */
	public ArrayList<ApplyMemberVO> getBenefitList() throws ClassNotFoundException, SQLException {
		ArrayList<ApplyMemberVO> list_apply = new ArrayList<ApplyMemberVO>();
		
		return list_apply;
	}
	
	/* 수혜자 아동 퇴소 */
	public boolean endBenefit(String aid) throws ClassNotFoundException, SQLException {
		boolean result = false;
		
		return result;
	}
	
	/* 수혜자 아동 상세 정보 */
	public ApplyMemberVO getBenefitContent(String aid) throws ClassNotFoundException, SQLException {
		ApplyMemberVO vo = new ApplyMemberVO();
		
		return vo;
	}

}
