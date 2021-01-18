package com.dolbom.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolbom.service.FacilityService;
import com.dolbom.vo.FacilityVO;

@Service
public class FacilityDAO implements FacilityService {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	/* 시설 목록 */
	public ArrayList<FacilityVO> getFacilityList() throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<FacilityVO> list_facility = new ArrayList<FacilityVO>();
		
		rs.close();
		st.close();
		con.close();
		
		return list_facility;
	}
	
	@Override
	/* 시설 상세 정보 */
	public FacilityVO getFacilityContent(String fid) throws ClassNotFoundException, SQLException  {
		String sql = "";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		FacilityVO vo = new FacilityVO();
		
		rs.close();
		st.close();
		con.close();
		
		
		return vo;
	}
	
	@Override
	/* 시설 등록 */
	public boolean insertFacility(FacilityVO vo) throws ClassNotFoundException, SQLException  {
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
	/* 시설 수정 */
	public boolean updateFacility(FacilityVO vo) throws ClassNotFoundException, SQLException  {
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
	/* 시설 삭제 */
	public boolean deleteFacility(String fid) throws ClassNotFoundException, SQLException  {
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
