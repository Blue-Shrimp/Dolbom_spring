package com.dolbom.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.dao.ApplyMemberDAO;
import com.dolbom.service.dao.FacilityDAO;
import com.dolbom.service.dao.MemberDAO;
import com.dolbom.service.dao.ReviewDAO;
import com.dolbom.vo.ApplyMemberVO;
import com.dolbom.vo.FacilityVO;
import com.dolbom.vo.MemberVO;
import com.dolbom.vo.ReviewVO;
import com.dolbom.vo.SessionVO;

@Service
public class ApplyMemberServiceImpl implements ApplyMemberService {
	
	@Autowired
	private FacilityDAO facilityDAO;
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired
	private ApplyMemberDAO applyMemberDAO;
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public String getApplyPage(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			FacilityVO vo = facilityDAO.getFacilityContent(fid);
			int acnt = applyMemberDAO.getApplyPeople(fid);
			MemberVO mvo = memberDAO.getMemberContent(svo.getId());
			
			if(vo.getFpeople() == acnt) {
				rttr.addFlashAttribute("msg1", true);
				String referer = request.getHeader("Referer");
				
				result = "redirect:" + referer;
			} else {
				model.addAttribute("member", mvo);
				model.addAttribute("facility", vo);
				model.addAttribute("fid", fid);
				model.addAttribute("did", svo.getId());
				result = "customer/facility/application";
				
			}
			
		}
		
		return result;
	}

	@Override
	public String insertApply(ApplyMemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			boolean apply_result = applyMemberDAO.insertApply(vo);
			
			if(apply_result) {
				rttr.addFlashAttribute("msg1", true);
				result = "redirect:/customer/myapply/list";				
			} else { 
				rttr.addFlashAttribute("msg1", true); 
				String referer = request.getHeader("Referer");
				result = "redirect:" + referer; 
			}
				 
		}
		
		return result;
	}

	@Override
	public String getMyApplyList(Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			ArrayList<ApplyMemberVO> apply_list = applyMemberDAO.getMyApplyList(svo.getId());
			ArrayList<ReviewVO> review_list = reviewDAO.getMyReviewList(svo.getId());
			
			model.addAttribute("review_list", review_list);
			model.addAttribute("did",svo.getId());
			model.addAttribute("list", apply_list);
			result = "customer/myapply/list";
		}
		
		return result;
	}
	
	@Override
	public String getApplyContent(@RequestParam(value = "aid") String aid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			ApplyMemberVO vo = applyMemberDAO.getApplyContent(aid);
			
			model.addAttribute("vo", vo);
			model.addAttribute("aid", aid);
			model.addAttribute("did", svo.getId());
			result = "customer/myapply/detail";
		}
		
		return result;
	}

	@Override
	public String deleteApply(@RequestParam(value = "aid") String aid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			boolean delete_result = applyMemberDAO.deleteApply(aid);
			
			if(delete_result) {
				rttr.addFlashAttribute("msg8", true);
				result = "redirect:/customer/myapply/list";				
			} else { 
				rttr.addFlashAttribute("msg9", true); 
				String referer = request.getHeader("Referer");
				result = "redirect:" + referer; 
			}
				 
		}
		
		return result;
	}

	@Override
	public ArrayList<ApplyMemberVO> getApplyList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approvalApply(String aid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectApply(String aid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ApplyMemberVO> getBenefitList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean endBenefit(String aid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ApplyMemberVO getBenefitContent(String aid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
