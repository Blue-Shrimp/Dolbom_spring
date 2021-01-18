package com.dolbom.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dolbom.vo.ApplyMemberVO;

public interface ApplyMemberService {
	int getApplyPeople(String fid) throws ClassNotFoundException, SQLException;
	boolean insertApply(ApplyMemberVO vo) throws ClassNotFoundException, SQLException;
	ArrayList<ApplyMemberVO> getMyApplyList(String did) throws ClassNotFoundException, SQLException;
	ArrayList<ApplyMemberVO> getApplyList() throws ClassNotFoundException, SQLException;
	boolean approvalApply(String aid) throws ClassNotFoundException, SQLException;
	boolean rejectApply(String aid) throws ClassNotFoundException, SQLException;
	ApplyMemberVO getApplyContent(String aid) throws ClassNotFoundException, SQLException;
	ArrayList<ApplyMemberVO> getBenefitList() throws ClassNotFoundException, SQLException;
	boolean endBenefit(String aid) throws ClassNotFoundException, SQLException;
	ApplyMemberVO getBenefitContent(String aid) throws ClassNotFoundException, SQLException;
	
}
