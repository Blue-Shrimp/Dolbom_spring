package com.dolbom.controller.admin;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolbom.service.NoticeService;
import com.dolbom.service.dao.NoticeDAO;
import com.dolbom.utils.PagingVO;
import com.dolbom.vo.NoticeVO;
import com.dolbom.vo.SessionVO;

@Controller("adminNoticeController")
@RequestMapping("/admin/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@RequestMapping(value="list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(PagingVO pvo, Model model,
			@RequestParam(defaultValue = "")String keyword,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage,
			HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		
		return noticeService.getNoticeListAdmin(pvo, model, keyword, nowPage, cntPerPage, request, rttr);
	}
	
	@RequestMapping(value="detail", method= RequestMethod.GET)
	public String detail(@RequestParam(value = "bid") String bid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return noticeService.getNoticeContentAdmin(bid, model, request, rttr);
	}
	
	@RequestMapping(value="fileDown", method= {RequestMethod.POST,RequestMethod.GET})
	public void fileDown(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		String filenameReal = request.getParameter("FILE_NAME");
        
        String path1 = request.getSession().getServletContext().getRealPath("/");
		String path2 = "/static/images/";
        
        byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File(path1+path2+filenameReal));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(filenameReal, "UTF-8")+"\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
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
			result = "admin/notice/write";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}
	
	@RequestMapping(value="writeProc.do", method= RequestMethod.POST)
	public String writeProc(NoticeVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		
		String path1 = request.getSession().getServletContext().getRealPath("/");
		String path2 = "/static/images/";
		
		vo.setSavepath(path1+path2);
		
		return noticeService.insertNotice(vo, request, rttr);
	}
	
	@RequestMapping(value="update", method= RequestMethod.GET)
	public String update(@RequestParam(value = "bid") String bid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			NoticeVO vo = noticeDAO.getNoticeContent(bid);
			
			model.addAttribute("vo", vo);
			result = "admin/notice/update";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}
	
	@RequestMapping(value="updateProc.do", method= RequestMethod.POST)
	public String updateProc(NoticeVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		String path1 = request.getSession().getServletContext().getRealPath("/");
		String path2 = "/static/images/";
		
		vo.setSavepath(path1+path2);
		
		return noticeService.updateNotice(vo, request, rttr);
	}
	
	@RequestMapping(value="deleteProc.do", method= RequestMethod.GET)
	public String deleteProc(@RequestParam(value = "bid") String bid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return noticeService.deleteNotice(bid, request, rttr);
	}

}
