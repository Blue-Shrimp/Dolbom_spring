package com.dolbom.service.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolbom.vo.NoticeVO;

@Service
public class NoticeDAO {

	@Autowired
	private SqlSessionTemplate sqlSession; 
	
	private static String namespace = "mapper.notice";
	
	/* 공지사항 목록 */
	public ArrayList<NoticeVO> getNoticeList() throws ClassNotFoundException, SQLException {
		ArrayList<NoticeVO> list_board = new ArrayList<NoticeVO>();
		
		return list_board;
	}
	
	/* 공지사항 상세 내용 */
	public NoticeVO getNoticeContent(String bid) throws ClassNotFoundException, SQLException {
		NoticeVO vo = new NoticeVO();
		
		return vo;
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
