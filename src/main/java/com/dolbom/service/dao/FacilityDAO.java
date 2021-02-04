package com.dolbom.service.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolbom.utils.PagingVO;
import com.dolbom.vo.FacilityVO;

@Service
public class FacilityDAO {
	@Autowired
	private SqlSessionTemplate sqlSession; 
	
	private static String namespace = "mapper.facility";
	
	/* 시설 목록(페이징 + 검색) */
	public ArrayList<FacilityVO> getFacilityList(String sido, String gugun, String keyword, PagingVO pvo) throws ClassNotFoundException, SQLException {
		Map<String,String> param = new HashMap<String,String>();
		param.put("sido", sido);
		param.put("gugun", gugun);
		param.put("keyword", keyword);
		param.put("start", String.valueOf(pvo.getStart()));
		param.put("end", String.valueOf(pvo.getEnd()));
		
		List<FacilityVO> list = sqlSession.selectList(namespace+".list", param);
		return (ArrayList<FacilityVO>)list;
	}
	
	/* 시설 개수(검색) */
	public int getCountFacility(String sido, String gugun, String keyword) throws ClassNotFoundException, SQLException {
		Map<String,String> param = new HashMap<String,String>();
		param.put("sido", sido);
		param.put("gugun", gugun);
		param.put("keyword", keyword);
		
		return sqlSession.selectOne(namespace +".count",param);
		
	}
	
	/* 시설 상세 정보 */
	public FacilityVO getFacilityContent(String fid) throws ClassNotFoundException, SQLException  {
		return sqlSession.selectOne(namespace +".content",fid);
	}
	
	/* 시설 평점순 상위 5개(인덱스) */
	public ArrayList<FacilityVO> getIndexFacility(){
		List<FacilityVO> list = sqlSession.selectList(namespace+".listIndex");
		return (ArrayList<FacilityVO>)list;
	}
	
	/* 시설 등록 */
	public boolean insertFacility(FacilityVO vo) throws ClassNotFoundException, SQLException  {
		boolean result = false;
		int value = sqlSession.insert(namespace+".write", vo);
		if(value != 0) result = true;
		return result; 
	}
	
	/* 시설 수정 */
	public boolean updateFacility(FacilityVO vo) throws ClassNotFoundException, SQLException  {
		boolean result = false;
		int value = sqlSession.update(namespace+".update", vo);
		if(value != 0) result = true;
		return result;
	}
	
	/* 시설 삭제 */
	public boolean deleteFacility(String fid) throws ClassNotFoundException, SQLException  {
		boolean result = false;
		int value = sqlSession.delete(namespace+".delete", fid);
		if(value != 0) result = true;
		return result;
	}

}
