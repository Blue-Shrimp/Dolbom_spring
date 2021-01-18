package com.dolbom.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolbom.service.ApplyMemberService;
import com.dolbom.vo.ApplyMemberVO;

@Service
public class ApplyMemberDAO implements ApplyMemberService {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	/* 각 시설의 신청한 사람의 수 */
	public int getApplyPeople(String fid) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		int cnt = 0;
		
		rs.close();
		st.close();
		con.close();
		
		return cnt;
	}
	
	@Override
	/* 돌봄 신청 등록 */
	public boolean insertApply(ApplyMemberVO vo) throws ClassNotFoundException, SQLException {
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
	/* 돌봄 신청 내역 */
	public ArrayList<ApplyMemberVO> getMyApplyList(String did) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<ApplyMemberVO> list_apply = new ArrayList<ApplyMemberVO>();
		
		rs.close();
		st.close();
		con.close();
		
		return list_apply;
	}
	
	@Override
	/* 돌봄 신청 아동 목록 */
	public ArrayList<ApplyMemberVO> getApplyList() throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<ApplyMemberVO> list_apply = new ArrayList<ApplyMemberVO>();
		
		rs.close();
		st.close();
		con.close();
		
		return list_apply;
	}
	
	@Override
	/* 돌봄 신청 아동 승인 */
	public boolean approvalApply(String aid) throws ClassNotFoundException, SQLException {
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
	/* 돌봄 신청 아동 미승인 */
	public boolean rejectApply(String aid) throws ClassNotFoundException, SQLException {
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
	/* 돌봄 신청 상세 정보 */
	public ApplyMemberVO getApplyContent(String aid) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ApplyMemberVO vo = new ApplyMemberVO();
		
		rs.close();
		st.close();
		con.close();
		
		return vo;
	}
	
	@Override
	/* 수혜자 아동 목록 */
	public ArrayList<ApplyMemberVO> getBenefitList() throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<ApplyMemberVO> list_apply = new ArrayList<ApplyMemberVO>();
		
		rs.close();
		st.close();
		con.close();
		
		return list_apply;
	}
	
	@Override
	/* 수혜자 아동 퇴소 */
	public boolean endBenefit(String aid) throws ClassNotFoundException, SQLException {
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
	/* 수혜자 아동 상세 정보 */
	public ApplyMemberVO getBenefitContent(String aid) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ApplyMemberVO vo = new ApplyMemberVO();
		
		rs.close();
		st.close();
		con.close();
		
		return vo;
	}

}
