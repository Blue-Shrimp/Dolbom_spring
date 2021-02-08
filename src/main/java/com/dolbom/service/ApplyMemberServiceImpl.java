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
import com.dolbom.utils.PagingVO;
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
			int check_apply = applyMemberDAO.getCheckApply(vo);
			
			if(check_apply == 0) {
				boolean apply_result = applyMemberDAO.insertApply(vo);
				
				if(apply_result) {
					rttr.addFlashAttribute("msg1", true);
					result = "redirect:/customer/myapply/list";				
				} else { 
					rttr.addFlashAttribute("msg1", true); 
					String referer = request.getHeader("Referer");
					result = "redirect:" + referer; 
				}
				
			} else {
				rttr.addFlashAttribute("msg2", true);
				result = "redirect:/customer/facility/list";
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
	public String getApplyContentAdmin(@RequestParam(value = "aid") String aid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			ApplyMemberVO vo = applyMemberDAO.getApplyContentAdmin(aid);
			
			model.addAttribute("detail", vo);
			model.addAttribute("aid",aid);
			result = "admin/applicationMember/detail";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}
	
	@Override
	public String getApplyList(PagingVO pvo, Model model, 
			@RequestParam(defaultValue = "")String status,
			@RequestParam(defaultValue = "")String keyword,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			int total = applyMemberDAO.getApplyCountSearch(status, keyword);
			if (nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "10";
			} else if (nowPage == null) {
				nowPage = "1";
			} else if (cntPerPage == null) { 
				cntPerPage = "10";
			}
			
			pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			ArrayList<ApplyMemberVO> apply_list = applyMemberDAO.getApplyList(status, keyword, pvo);
			model.addAttribute("status", status);
			model.addAttribute("keyword", keyword);
			model.addAttribute("paging", pvo);
			model.addAttribute("list",apply_list);
			result = "admin/applicationMember/list";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}

	@Override
	public String updateApply(ApplyMemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			boolean update_result = applyMemberDAO.updateApply(vo);
			
			if(update_result) {
				rttr.addFlashAttribute("msg1", true);
				result = "redirect:/admin/applicationMember/list";	
			} else {
				rttr.addFlashAttribute("msg1", true); 
				String referer = request.getHeader("Referer");
				result = "redirect:" + referer;
			}
			
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}

	@Override
	public String getBenefitList(PagingVO pvo, Model model, 
			@RequestParam(defaultValue = "")String status,
			@RequestParam(defaultValue = "")String facility,
			@RequestParam(defaultValue = "")String name,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			int total = applyMemberDAO.getBenefitCount(status, facility, name);
			if (nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "10";
			} else if (nowPage == null) {
				nowPage = "1";
			} else if (cntPerPage == null) { 
				cntPerPage = "10";
			}
			
			pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			ArrayList<ApplyMemberVO> benefit_list = applyMemberDAO.getBenefitList(status, facility, name, pvo);
			model.addAttribute("status", status);
			model.addAttribute("facility", facility);
			model.addAttribute("name", name);
			model.addAttribute("paging", pvo);
			model.addAttribute("list",benefit_list);
			
			result = "admin/benefitMember/list";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}

	@Override
	public String getBenefitContent(@RequestParam(value = "aid") String aid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			ApplyMemberVO vo = applyMemberDAO.getBenefitContent(aid);
			
			model.addAttribute("detail", vo);
			model.addAttribute("aid",aid);
			result = "admin/benefitMember/detail";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}

	@Override
	public String updateBenefit(ApplyMemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			boolean update_result = applyMemberDAO.updateBenefit(vo);
			
			if(update_result) {
				rttr.addFlashAttribute("msg1", true);
				result = "redirect:/admin/benefitMember/list";	
			} else {
				rttr.addFlashAttribute("msg1", true); 
				String referer = request.getHeader("Referer");
				result = "redirect:" + referer;
			}
			
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}


}
