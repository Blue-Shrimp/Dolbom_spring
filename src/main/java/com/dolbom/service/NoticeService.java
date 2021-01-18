package com.dolbom.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dolbom.vo.NoticeVO;

public interface NoticeService {
	ArrayList<NoticeVO> getNoticeList() throws ClassNotFoundException, SQLException;
	NoticeVO getNoticeContent(String bid) throws ClassNotFoundException, SQLException;
	boolean insertNotice(NoticeVO vo) throws ClassNotFoundException, SQLException;
	boolean updateNotice(NoticeVO vo) throws ClassNotFoundException, SQLException;
	boolean deleteNotice(String bid) throws ClassNotFoundException, SQLException;
	
}
