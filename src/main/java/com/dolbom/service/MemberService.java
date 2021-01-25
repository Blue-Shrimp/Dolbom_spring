package com.dolbom.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dolbom.vo.MemberVO;
import com.dolbom.vo.SessionVO;

public interface MemberService {
	boolean insertMember(MemberVO vo)  throws ClassNotFoundException, SQLException;
	SessionVO getLogin(MemberVO vo)  throws ClassNotFoundException, SQLException;
	int getIdCheck(String did) throws ClassNotFoundException, SQLException;
	String getFindId(MemberVO vo) throws ClassNotFoundException, SQLException;
	String getFindPass(MemberVO vo) throws ClassNotFoundException, SQLException;
	MemberVO getMemberContent(String did)  throws ClassNotFoundException, SQLException;
	boolean updateMember(MemberVO vo)  throws ClassNotFoundException, SQLException;
	
}
