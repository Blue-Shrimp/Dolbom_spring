package com.dolbom.controller.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.dao.FacilityDAO;
import com.dolbom.vo.FacilityVO;
import com.dolbom.vo.SessionVO;

@Controller("adminStatisticsController")
@RequestMapping("/admin/statistics/")
public class StatisticsController {
	@Autowired
	private FacilityDAO facilityDAO;
	
	@RequestMapping(value="facility", method=RequestMethod.GET)
	public String facility(Model model, HttpServletRequest request, RedirectAttributes rttr) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			ArrayList<FacilityVO> list = facilityDAO.getFacilityCount();
			
			JSONArray jsonArray = new JSONArray();
			JSONArray colArray = new JSONArray();
			colArray.put(0, "시설명");
			colArray.put(1, "시설개수");
			jsonArray.put(colArray);
			for(FacilityVO vo : list) {
				JSONArray rowArray = new JSONArray();
				rowArray.put(0, vo.getFsido());
				rowArray.put(1, vo.getFcnt());
				
				jsonArray.put(rowArray);
			}
			
			model.addAttribute("result", jsonArray);
			result = "admin/statistics/facility";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
		
	}

}
