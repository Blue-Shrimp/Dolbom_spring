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
import com.dolbom.utils.PagingVO;
import com.dolbom.vo.FacilityVO;
import com.dolbom.vo.MemberVO;

@Service
public class FacilityDAO implements FacilityService {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	/* 시설 목록 */
	public ArrayList<FacilityVO> getFacilityList() throws ClassNotFoundException, SQLException {
		String sql = "select rownum rno, fid, fpname, flocation, fpeople, cnt, rservice "
				+ " from facility_list "
				+ " order by rno desc";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<FacilityVO> list_facility = new ArrayList<FacilityVO>();
		
		while(rs.next()) {
			FacilityVO vo = new FacilityVO();
			
			vo.setRno(rs.getInt(1));
			vo.setFid(rs.getString(2));
			vo.setFpname(rs.getString(3));
			vo.setFlocation(rs.getString(4));
			vo.setFpeople(rs.getInt(5));
			vo.setFcnt(rs.getInt(6));
			vo.setFservice(rs.getFloat(7));
			
			list_facility.add(vo);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list_facility;
	}
	
	/* 시설 목록(페이징) */
	@Override
	public ArrayList<FacilityVO> getFacilityList(PagingVO pvo) throws ClassNotFoundException, SQLException {
		String sql = "select * "
				+ " from (select rownum rno, fid, fpname, flocation, fpeople, cnt, rservice"
					  + " from facility_list)"
				+ " where rno between ? and ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, pvo.getStart());
		st.setInt(2, pvo.getEnd());
		ResultSet rs = st.executeQuery();
		
		ArrayList<FacilityVO> list_facility = new ArrayList<FacilityVO>();
		
		while(rs.next()) {
			FacilityVO vo = new FacilityVO();
			
			vo.setRno(rs.getInt(1));
			vo.setFid(rs.getString(2));
			vo.setFpname(rs.getString(3));
			vo.setFlocation(rs.getString(4));
			vo.setFpeople(rs.getInt(5));
			vo.setFcnt(rs.getInt(6));
			vo.setFservice(rs.getFloat(7));
			
			list_facility.add(vo);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list_facility;
	}
	
	/* 시설 목록(페이징 + 검색) */
	@Override
	public ArrayList<FacilityVO> getFacilityList(String sido, String gugun, String keyword, PagingVO pvo) throws ClassNotFoundException, SQLException {
		String sql = "select * "
				  + " from (select rownum rno, fid, fpname, flocation, fpeople, cnt, rservice, fsido, fgugun"
				  		+ " from facility_list"
				  		+ " where fsido like '%" + sido + "%' and fgugun like '%" + gugun + "%' and fpname like '%" + keyword + "%')"
				  + " where rno between ? and ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, pvo.getStart());
		st.setInt(2, pvo.getEnd());
		ResultSet rs = st.executeQuery();
		
		ArrayList<FacilityVO> list_facility = new ArrayList<FacilityVO>();
		
		while(rs.next()) {
			FacilityVO vo = new FacilityVO();
			
			vo.setRno(rs.getInt(1));
			vo.setFid(rs.getString(2));
			vo.setFpname(rs.getString(3));
			vo.setFlocation(rs.getString(4));
			vo.setFpeople(rs.getInt(5));
			vo.setFcnt(rs.getInt(6));
			vo.setFservice(rs.getFloat(7));
			
			list_facility.add(vo);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list_facility;
	}
	
	/* 시설 개수 */
	@Override
	public int getCountFacility() throws ClassNotFoundException, SQLException {
		String sql = "select count(*) from facility_list";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		int cnt = 0;
		
		while(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return cnt;
		
	}
	
	/* 시설 개수(검색) */
	@Override
	public int getCountFacility(String sido, String gugun, String keyword) throws ClassNotFoundException, SQLException {
		String sql = "select count(*)"
				+ " from facility_list"
				+ " where fsido like '%" + sido + "%' and fgugun like '%" + gugun + "%' and fpname like '%" + keyword + "%'";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		int cnt = 0;
		
		while(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return cnt;
		
	}
	
	@Override
	/* 시설 상세 정보 */
	public FacilityVO getFacilityContent(String fid) throws ClassNotFoundException, SQLException  {
		String sql = "select fpname, rservice, fname, flocation, fphone, fstime, fetime, fweek, fprogram, fimg, fsimg, fpeople"
				+ " from facility f, (select fid, round(avg(rservice),1) rservice from review group by fid) r"
				+ " where f.fid=r.fid(+) and f.fid=?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, fid);
		ResultSet rs = st.executeQuery();

		FacilityVO vo = new FacilityVO();

		while(rs.next()) {
			vo.setFpname(rs.getString(1));
			vo.setFservice(rs.getInt(2));
			vo.setFname(rs.getString(3));
			vo.setFlocation(rs.getString(4));
			vo.setFphone(rs.getString(5));
			vo.setFstime(rs.getString(6));
			vo.setFetime(rs.getString(7));
			vo.setFweek(rs.getString(8));
			vo.setFprogram(rs.getString(9));
			vo.setFimg(rs.getString(10));
			vo.setFsimg(rs.getString(11));
			vo.setFpeople(rs.getInt(12));
		}
		
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
