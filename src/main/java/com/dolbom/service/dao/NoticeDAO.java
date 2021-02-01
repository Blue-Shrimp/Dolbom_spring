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
import com.dolbom.vo.NoticeVO;

@Service
public class NoticeDAO {

	@Autowired
	private SqlSessionTemplate sqlSession; 
	
	private static String namespace = "mapper.notice";
	
	/* 공지사항 목록(페이징 + 검색) */
	public ArrayList<NoticeVO> getNoticeList(String keyword, PagingVO pvo) throws ClassNotFoundException, SQLException {
		Map<String,String> param = new HashMap<String,String>();
		param.put("keyword", keyword);
		param.put("start", String.valueOf(pvo.getStart()));
		param.put("end", String.valueOf(pvo.getEnd()));
		
		List<NoticeVO> list = sqlSession.selectList(namespace+".list", param);
		return (ArrayList<NoticeVO>)list;
	}
	
	/* 공지사항 개수(검색) */
	public int getCountNotice(String keyword) throws ClassNotFoundException, SQLException {
		return sqlSession.selectOne(namespace +".count",keyword);
	}
	
	/* 공지사항 상세 내용 */
	public NoticeVO getNoticeContent(String bid) throws ClassNotFoundException, SQLException {
		return sqlSession.selectOne(namespace +".content",bid);
	}
	
	/* 공지사항 등록 */
	public boolean insertNotice(NoticeVO vo) throws ClassNotFoundException, SQLException {
		boolean result = false;
		
		return result;
	}
	
	/* 공지사항 수정 */
	public boolean updateNotice(NoticeVO vo) throws ClassNotFoundException, SQLException {
		boolean result = false;
		
		return result;
	}
	
	/* 공지사항 삭제 */
	public boolean deleteNotice(String bid) throws ClassNotFoundException, SQLException {
		boolean result = false;
		
		return result;
	}

}
