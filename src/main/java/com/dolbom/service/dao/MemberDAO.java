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
		String sql = "insert into dmember values(?,?,?,?,?,?,?,sysdate)";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getDid());
		st.setString(2, vo.getDpass());
		st.setString(3, vo.getDname());
		st.setString(4, vo.getDphone());
		st.setString(5, vo.getDemail());
		st.setString(6, vo.getDarea());
		st.setString(7, vo.getDchildren());
		
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
	/*아이디 중복 체크 */
	public int getIdCheck(String did) throws ClassNotFoundException, SQLException {
		int result = 0;
		String sql ="select count(*) from dmember where did=?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, did);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			result = rs.getInt(1);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return result;
	}
	
	@Override
	/*아이디 찾기 */
	public String getFindId(MemberVO vo) throws ClassNotFoundException, SQLException {
		String id = "";
		String sql ="select did from dmember where dname=? and dphone=?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getDname());
		st.setString(2, vo.getDphone());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			id = rs.getString(1);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return id;
	}
	
	@Override
	/*비밀번호 찾기 */
	public String getFindPass(MemberVO vo) throws ClassNotFoundException, SQLException {
		String id = "";
		String sql ="select dpass from dmember where did=? and dname=? and dphone=?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getDid());
		st.setString(2, vo.getDname());
		st.setString(3, vo.getDphone());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			id = rs.getString(1);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return id;
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
