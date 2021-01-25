package com.dolbom.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dolbom.utils.PagingVO;
import com.dolbom.vo.FacilityVO;

public interface FacilityService {
	ArrayList<FacilityVO> getFacilityList() throws ClassNotFoundException, SQLException;
	ArrayList<FacilityVO> getFacilityList(PagingVO vo) throws ClassNotFoundException, SQLException;
	ArrayList<FacilityVO> getFacilityList(String sido, String gugun, String keyword, PagingVO vo) throws ClassNotFoundException, SQLException;
	int getCountFacility() throws ClassNotFoundException, SQLException;
	int getCountFacility(String sido, String gugun, String keyword) throws ClassNotFoundException, SQLException;
	FacilityVO getFacilityContent(String fid) throws ClassNotFoundException, SQLException;
	boolean insertFacility(FacilityVO vo) throws ClassNotFoundException, SQLException;
	boolean updateFacility(FacilityVO vo) throws ClassNotFoundException, SQLException;
	boolean deleteFacility(String fid) throws ClassNotFoundException, SQLException;
}
