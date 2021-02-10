package com.dolbom.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.vo.MemberVO;
import com.dolbom.vo.SessionVO;

public interface MemberService {
	String insertMember(RedirectAttributes rttr, MemberVO vo)  throws ClassNotFoundException, SQLException;
	SessionVO getLogin(MemberVO vo)  throws ClassNotFoundException, SQLException;
	String getIdCheck(String did) throws ClassNotFoundException, SQLException;
	String getFindId(MemberVO vo, Model model, RedirectAttributes rttr, HttpSession session) throws ClassNotFoundException, SQLException;
	String getFindPass(MemberVO vo, Model model, RedirectAttributes rttr, HttpSession session) throws ClassNotFoundException, SQLException;
	String getMemberContent(Model model, HttpServletRequest request, RedirectAttributes rttr)  throws ClassNotFoundException, SQLException;
	String getMemberUpdateContent(Model model, HttpServletRequest request, RedirectAttributes rttr)  throws ClassNotFoundException, SQLException;
	String updateMember(MemberVO vo, HttpServletRequest request, RedirectAttributes rttr)  throws ClassNotFoundException, SQLException;
	String deleteMember(Model model,HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	String passEdit(MemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException;
	
}
