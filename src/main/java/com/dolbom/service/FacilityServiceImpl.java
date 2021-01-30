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

import com.dolbom.service.dao.FacilityDAO;
import com.dolbom.service.dao.ReviewDAO;
import com.dolbom.utils.PagingVO;
import com.dolbom.vo.FacilityVO;
import com.dolbom.vo.ReviewVO;
import com.dolbom.vo.SessionVO;

@Service
public class FacilityServiceImpl implements FacilityService {
	
	@Autowired
	private FacilityDAO facilityDAO;
	
	@Autowired
	private ReviewDAO reviewDAO;

	@Override
	public String getFacilityList(PagingVO pvo, Model model, 
			@RequestParam(defaultValue = "")String sido,
			@RequestParam(defaultValue = "")String gugun,
			@RequestParam(defaultValue = "")String keyword,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			HttpServletRequest request, RedirectAttributes rttr)
			throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			int total = facilityDAO.getCountFacility(sido, gugun, keyword);
			if (nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "10";
			} else if (nowPage == null) {
				nowPage = "1";
			} else if (cntPerPage == null) { 
				cntPerPage = "10";
			}
			
			pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			ArrayList<FacilityVO> facility_list = facilityDAO.getFacilityList(sido, gugun, keyword, pvo);
			model.addAttribute("sido", sido);
			model.addAttribute("gugun", gugun);
			model.addAttribute("keyword", keyword);
			model.addAttribute("paging", pvo);
			model.addAttribute("list",facility_list);
			result = "customer/facility/list";
		}
		
		return result;
	}

	@Override
	public String getFacilityContent(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			FacilityVO vo = facilityDAO.getFacilityContent(fid);
			ArrayList<ReviewVO> review_list = reviewDAO.getReviewList(fid);
			int review_cnt = reviewDAO.getReviewCnt(fid);
			double review_score = reviewDAO.getReviewScore(fid);
			
			model.addAttribute("cnt", review_cnt);
			model.addAttribute("score", review_score);
			model.addAttribute("list", review_list);
			model.addAttribute("detail", vo);
			model.addAttribute("fid", fid);
			model.addAttribute("did", svo.getId());
			result = "customer/facility/detail";
		}
		
		return result;
	}

	@Override
	public boolean insertFacility(FacilityVO vo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFacility(FacilityVO vo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFacility(String fid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
