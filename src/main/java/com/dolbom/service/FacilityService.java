package com.dolbom.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.utils.PagingVO;
import com.dolbom.vo.FacilityVO;

public interface FacilityService {
	String getFacilityList(PagingVO pvo, Model model, 
			@RequestParam(defaultValue = "")String sido,
			@RequestParam(defaultValue = "")String gugun,
			@RequestParam(defaultValue = "")String keyword,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getFacilityListAdmin(PagingVO pvo, Model model, 
			@RequestParam(defaultValue = "")String sido,
			@RequestParam(defaultValue = "")String gugun,
			@RequestParam(defaultValue = "")String keyword,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getFacilityContent(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getFacilityContentAdmin(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String insertFacility(FacilityVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String updateFacility(FacilityVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String deleteFacility(@RequestParam(value = "fid") String fid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
}
