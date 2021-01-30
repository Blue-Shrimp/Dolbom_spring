package com.dolbom.service.dao;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolbom.vo.MemberVO;
import com.dolbom.vo.SessionVO;

@Service
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession; 
	
	private static String namespace = "mapper.member";
	
	/* 회원가입 */
	public boolean insertMember(MemberVO vo) throws ClassNotFoundException, SQLException  {
		boolean result = false;
		int value = sqlSession.insert(namespace+".join", vo);
		if(value != 0) result = true;
		return result; 
	}
	
	/*로그인*/
	public SessionVO getLogin(MemberVO vo) {		
	     return sqlSession.selectOne(namespace +".login",vo);
	}
	
	
	/*아이디 중복 체크 */
	public int getIdCheck(String did) throws ClassNotFoundException, SQLException {
		return sqlSession.selectOne(namespace +".idCheck",did);
	}
	
	/*아이디 찾기 */
	public String getFindId(MemberVO vo) throws ClassNotFoundException, SQLException {
		return sqlSession.selectOne(namespace +".findId",vo);
	}
	
	/*비밀번호 찾기 */
	public String getFindPass(MemberVO vo) throws ClassNotFoundException, SQLException {
		return sqlSession.selectOne(namespace +".findPass",vo);
	}
	
	/* 회원 상세 정보 */
	public MemberVO getMemberContent(String did) throws ClassNotFoundException, SQLException  {
		return sqlSession.selectOne(namespace +".content",did);
	}
	
	/* 회원 정보 수정 */
	public boolean updateMember(MemberVO vo) throws ClassNotFoundException, SQLException  {
		boolean result = false;
		int value = sqlSession.update(namespace+".update", vo);
		if(value != 0) result = true;
		return result; 
	}
	
	/* 회원 탈퇴 */
	public boolean deleteMember(String did) throws ClassNotFoundException, SQLException  {
		boolean result = false;
		int value = sqlSession.delete(namespace+".delete", did);
		if(value != 0) result = true;
		return result;
	}
	
	/* 비밀번호 변경 */
	public boolean passEdit(MemberVO vo) throws ClassNotFoundException, SQLException  {
		boolean result = false;
		int value = sqlSession.update(namespace+".passEdit", vo);
		if(value != 0) result = true;
		return result;
	}

}
