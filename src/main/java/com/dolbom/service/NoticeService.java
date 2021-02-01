package com.dolbom.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.utils.PagingVO;
import com.dolbom.vo.NoticeVO;

public interface NoticeService {
	String getNoticeList(PagingVO pvo, Model model,
			@RequestParam(defaultValue = "")String keyword,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage,
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getNoticeContent(@RequestParam(value = "bid") String bid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	boolean insertNotice(NoticeVO vo) throws ClassNotFoundException, SQLException;
	boolean updateNotice(NoticeVO vo) throws ClassNotFoundException, SQLException;
	boolean deleteNotice(String bid) throws ClassNotFoundException, SQLException;
	
}
