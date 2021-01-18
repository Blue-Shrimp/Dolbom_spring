package com.dolbom.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolbom.service.MemberService;
import com.dolbom.vo.MemberVO;
import com.dolbom.vo.SessionVO;

@Service
public class MemberDAO implements MemberService {

	@Autowired
	private DataSource dataSource;
	
	@Override // 예시 지우기
	public ArrayList<MemberVO> getList() throws ClassNotFoundException, SQLException {
		String sql = "select * from dmember";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		while(rs.next()) {
			MemberVO index = new MemberVO();
			
			index.setDid(rs.getString(1));
			index.setDname(rs.getString(2));
			
			list.add(index);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	@Override
	/* 회원가입 */
	public boolean insertMember(MemberVO vo) throws ClassNotFoundException, SQLException  {
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
	/* 로그인 */
	public SessionVO getLogin(MemberVO vo) throws ClassNotFoundException, SQLException  {
		SessionVO svo = new SessionVO();
		
		String sql = "select count(*), dname from dmember where did=? and dpass=? group by dname";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getDid());
		st.setString(2, vo.getDpass());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			svo.setResult(rs.getInt(1));
			svo.setName(rs.getString(2));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return svo;
	}
	
	@Override
	/* 회원 상세 정보 */
	public MemberVO getMemberContent(String did) throws ClassNotFoundException, SQLException  {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		MemberVO vo = new MemberVO();
		
		rs.close();
		st.close();
		con.close();
		
		return vo;
	}
	
	@Override
	/* 회원 정보 수정 */
	public boolean updateMember(MemberVO vo) throws ClassNotFoundException, SQLException  {
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
