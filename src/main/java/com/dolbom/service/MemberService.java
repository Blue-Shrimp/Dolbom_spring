package com.dolbom.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dolbom.vo.MemberVO;
import com.dolbom.vo.SessionVO;

public interface MemberService {
	ArrayList<MemberVO> getList() throws ClassNotFoundException, SQLException; // 예시
	boolean insertMember(MemberVO vo)  throws ClassNotFoundException, SQLException;
	SessionVO getLogin(MemberVO vo)  throws ClassNotFoundException, SQLException;
	MemberVO getMemberContent(String did)  throws ClassNotFoundException, SQLException;
	boolean updateMember(MemberVO vo)  throws ClassNotFoundException, SQLException;
	
}
