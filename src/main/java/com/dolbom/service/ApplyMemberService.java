package com.dolbom.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.utils.PagingVO;
import com.dolbom.vo.ApplyMemberVO;

public interface ApplyMemberService {
	String getApplyPage(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String insertApply(ApplyMemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getMyApplyList(Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getApplyContent(@RequestParam(value = "aid") String aid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String deleteApply(@RequestParam(value = "aid") String aid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getApplyList(PagingVO pvo, Model model, 
			@RequestParam(defaultValue = "")String status,
			@RequestParam(defaultValue = "")String keyword,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getApplyContentAdmin(@RequestParam(value = "aid") String aid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String updateApply(ApplyMemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getBenefitList(PagingVO pvo, Model model, 
			@RequestParam(defaultValue = "")String status,
			@RequestParam(defaultValue = "")String facility,
			@RequestParam(defaultValue = "")String name,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getBenefitContent(@RequestParam(value = "aid") String aid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String updateBenefit(ApplyMemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	
}
