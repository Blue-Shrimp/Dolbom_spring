package com.dolbom.controller.notice;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

@Controller
@RequestMapping("/customer/notice/")
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
		
		return noticeService.getNoticeList(pvo, model, keyword, nowPage, cntPerPage, request, rttr);
	}
	
	@RequestMapping(value="detail", method= RequestMethod.GET)
	public String detail(@RequestParam(value = "bid") String bid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return noticeService.getNoticeContent(bid, model, request, rttr);
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

	
	/* 파일 업로드 할때 이용 */
	@RequestMapping(value="file_upload", method= RequestMethod.GET)
	public String file_upload(NoticeVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		return "customer/notice/file_upload";
	}
	
	@RequestMapping(value="upload", method= RequestMethod.POST)
	public String upload(Model model, NoticeVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		if(vo.getFile1().getSize() != 0) {
			UUID uuid = UUID.randomUUID();
			vo.setBfile(vo.getFile1().getOriginalFilename());
			vo.setBsfile(uuid+"_"+vo.getFile1().getOriginalFilename());
		}
		
		String path1 = request.getSession().getServletContext().getRealPath("/");
		String path2 = "/static/images/";
		
		vo.setSavepath(path1+path2);
		
		File file = new File(vo.getSavepath()+vo.getBsfile());
		try {
			vo.getFile1().transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("path",vo.getSavepath());
		model.addAttribute("file",vo.getBsfile());
		return "customer/notice/file_upload";
	}
	
}
