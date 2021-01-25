package com.dolbom.controller.facility;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.FacilityService;
import com.dolbom.utils.PagingVO;
import com.dolbom.vo.FacilityVO;
import com.dolbom.vo.SessionVO;

@Controller
@RequestMapping("/customer/facility/")
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(PagingVO pvo, Model model, 
				@RequestParam(defaultValue = "")String sido,
				@RequestParam(defaultValue = "")String gugun,
				@RequestParam(defaultValue = "")String keyword,
				@RequestParam(value="nowPage", required=false)String nowPage,
				@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
				HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			int total = facilityService.getCountFacility(sido, gugun, keyword);
			if (nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "10";
			} else if (nowPage == null) {
				nowPage = "1";
			} else if (cntPerPage == null) { 
				cntPerPage = "10";
			}
			
			pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			ArrayList<FacilityVO> facility_list = facilityService.getFacilityList(sido, gugun, keyword, pvo);
			model.addAttribute("sido", sido);
			model.addAttribute("gugun", gugun);
			model.addAttribute("keyword", keyword);
			model.addAttribute("paging", pvo);
			model.addAttribute("list",facility_list);
			result = "customer/facility/list";
		}
		
		return result;
	}
	
	@RequestMapping(value="detail", method= RequestMethod.GET)
	public String detail(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else {
			FacilityVO vo = facilityService.getFacilityContent(fid);
			model.addAttribute("detail", vo);
			model.addAttribute("fid", fid);
			model.addAttribute("did", svo.getId());
			result = "customer/facility/detail";
		}
		
		return result;
	}

}
