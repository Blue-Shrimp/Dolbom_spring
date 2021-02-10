package com.dolbom.controller.admin;

import java.sql.SQLException;

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
import com.dolbom.service.dao.FacilityDAO;
import com.dolbom.utils.PagingVO;
import com.dolbom.vo.FacilityVO;
import com.dolbom.vo.SessionVO;

@Controller("adminFacilityController")
@RequestMapping("/admin/facility/")
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private FacilityDAO facilityDAO;
	
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(PagingVO pvo, Model model, 
			@RequestParam(defaultValue = "")String sido,
			@RequestParam(defaultValue = "")String gugun,
			@RequestParam(defaultValue = "")String keyword,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		
		return facilityService.getFacilityListAdmin(pvo, model, sido, gugun, keyword, nowPage, cntPerPage, request, rttr);
	}
	
	@RequestMapping(value="detail", method= RequestMethod.GET)
	public String detail(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return facilityService.getFacilityContentAdmin(fid, model, request, rttr);
	}
	
	@RequestMapping(value="write", method= RequestMethod.GET)
	public String write(Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			result = "admin/facility/write";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}
	
	@RequestMapping(value="insertProc.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String insertProc(FacilityVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		String path1 = request.getSession().getServletContext().getRealPath("/");
		String path2 = "/static/images/";
		
		vo.setSavepath(path1+path2);
		
		return facilityService.insertFacility(vo, request, rttr);
	}
	
	@RequestMapping(value="update", method= RequestMethod.GET)
	public String update(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			FacilityVO vo = facilityDAO.getFacilityContent(fid);
			
			model.addAttribute("vo", vo);
			result = "admin/facility/update";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}
	
	@RequestMapping(value="updateProc.do", method= RequestMethod.POST)
	public String updateProc(FacilityVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		
		return facilityService.updateFacility(vo, request, rttr);
	}
	
	@RequestMapping(value="deleteProc.do", method= RequestMethod.GET)
	public String deleteProc(@RequestParam(value = "fid") String fid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		
		return facilityService.deleteFacility(fid, request, rttr);
	}

}
