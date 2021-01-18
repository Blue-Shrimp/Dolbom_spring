package com.dolbom.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolbom.service.NoticeService;
import com.dolbom.vo.NoticeVO;

@Service
public class NoticeDAO implements NoticeService {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	/* 공지사항 목록 */
	public ArrayList<NoticeVO> getNoticeList() throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<NoticeVO> list_board = new ArrayList<NoticeVO>();
		
		rs.close();
		st.close();
		con.close();
		
		return list_board;
	}
	
	@Override
	/* 공지사항 상세 내용 */
	public NoticeVO getNoticeContent(String bid) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		NoticeVO vo = new NoticeVO();
		
		rs.close();
		st.close();
		con.close();
		
		return vo;
	}
	
	@Override
	/* 공지사항 등록 */
	public boolean insertNotice(NoticeVO vo) throws ClassNotFoundException, SQLException {
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
	/* 공지사항 수정 */
	public boolean updateNotice(NoticeVO vo) throws ClassNotFoundException, SQLException {
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
	/* 공지사항 삭제 */
	public boolean deleteNotice(String bid) throws ClassNotFoundException, SQLException {
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
