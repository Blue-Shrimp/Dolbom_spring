package com.dolbom.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.dao.MemberDAO;
import com.dolbom.vo.MemberVO;
import com.dolbom.vo.SessionVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public String insertMember(RedirectAttributes rttr, MemberVO vo) throws ClassNotFoundException, SQLException {
		boolean join_result = memberDAO.insertMember(vo);
		String result = "";
		
		if(join_result) {
			rttr.addFlashAttribute("msg1", true);
			result = "redirect:/login";
		} else {
			rttr.addFlashAttribute("msg", true);
			result = "redirect:/join/join";
		}
		
		return result;
	}

	@Override
	public SessionVO getLogin(MemberVO vo) throws ClassNotFoundException, SQLException {
		SessionVO svo = new SessionVO();
		
		String sql = "select count(*), dname, did from dmember where did=? and dpass=? group by dname, did";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getDid());
		st.setString(2, vo.getDpass());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			svo.setResult(rs.getInt(1));
			svo.setName(rs.getString(2));
			svo.setId(rs.getString(3));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return svo;
	}

	@Override
	public String getIdCheck(String did) throws ClassNotFoundException, SQLException {
		int result = memberDAO.getIdCheck(did);
		
		return String.valueOf(result);
	}

	@Override
	public String getFindId(MemberVO vo, Model model, RedirectAttributes rttr, HttpSession session) throws ClassNotFoundException, SQLException {
		String id = memberDAO.getFindId(vo);
		String result = "";
		
		if(id == null) {
			rttr.addFlashAttribute("msg", true);
			result = "redirect:/login/findId";				
		}else {
			model.addAttribute("id", id);
			result = "login/findId_success";
		}
		
		return result;
	}

	@Override
	public String getFindPass(MemberVO vo, Model model, RedirectAttributes rttr, HttpSession session) throws ClassNotFoundException, SQLException {
		String pass = memberDAO.getFindPass(vo);
		String result = "";
		
		if(pass == null) {
			rttr.addFlashAttribute("msg", true);
			result = "redirect:/login/findPass";				
		}else {
			model.addAttribute("pass", pass);
			result = "login/findPass_success";
		}
		
		return result;
	}

	@Override
	public String getMemberContent(Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO)obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			MemberVO vo = memberDAO.getMemberContent(svo.getId());
			
			model.addAttribute("vo", vo);
			model.addAttribute("did",svo.getId());
			result = "customer/mypage/detail";
		}
		
		return result;
	}
	
	@Override
	public String getMemberUpdateContent(Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO)obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			MemberVO vo = memberDAO.getMemberContent(svo.getId());
			
			model.addAttribute("vo", vo);
			model.addAttribute("did",svo.getId());
			result = "customer/mypage/update";
		}
		
		return result;
	}

	@Override
	public String updateMember(MemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO)obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			boolean update_result = memberDAO.updateMember(vo);
			
			if(update_result) {
				rttr.addFlashAttribute("msg2", true);
				result = "redirect:/customer/mypage/detail";				
			} else { 
				rttr.addFlashAttribute("msg1", true); 
				String referer = request.getHeader("Referer");
				result = "redirect:" + referer; 
			}
		}
		
		return result;
	}

	@Override
	public String deleteMember(Model model,HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO)obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			boolean delete_result = memberDAO.deleteMember(svo.getId());
			
			if(delete_result) {
				rttr.addFlashAttribute("msg5", true);
				result = "redirect:/login";				
			} else { 
				rttr.addFlashAttribute("msg1", true); 
				String referer = request.getHeader("Referer");
				result = "redirect:" + referer; 
			}
		}
		
		return result;
	}

	@Override
	public String passEdit(MemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO)obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			boolean update_result = memberDAO.passEdit(vo);
			
			if(update_result) {
				rttr.addFlashAttribute("msg1", true);
				result = "redirect:/customer/mypage/detail";				
			} else { 
				rttr.addFlashAttribute("msg1", true); 
				String referer = request.getHeader("Referer");
				result = "redirect:" + referer; 
			}
		}
		
		return result;
	}

}
