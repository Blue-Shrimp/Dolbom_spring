package com.dolbom.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.vo.ApplyMemberVO;

public interface ApplyMemberService {
	String getApplyPage(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String insertApply(ApplyMemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getMyApplyList(Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String getApplyContent(@RequestParam(value = "aid") String aid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String deleteApply(@RequestParam(value = "aid") String aid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	ArrayList<ApplyMemberVO> getApplyList() throws ClassNotFoundException, SQLException;
	boolean approvalApply(String aid) throws ClassNotFoundException, SQLException;
	boolean rejectApply(String aid) throws ClassNotFoundException, SQLException;
	ArrayList<ApplyMemberVO> getBenefitList() throws ClassNotFoundException, SQLException;
	boolean endBenefit(String aid) throws ClassNotFoundException, SQLException;
	ApplyMemberVO getBenefitContent(String aid) throws ClassNotFoundException, SQLException;
	
}
