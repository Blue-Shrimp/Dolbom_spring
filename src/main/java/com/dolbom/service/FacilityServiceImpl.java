package com.dolbom.service;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

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
	public String getFacilityListAdmin(PagingVO pvo, Model model, 
			@RequestParam(defaultValue = "")String sido,
			@RequestParam(defaultValue = "")String gugun,
			@RequestParam(defaultValue = "")String keyword,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			HttpServletRequest request, RedirectAttributes rttr)
			throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if (svo.getName().equals("관리자")) {
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
			result = "admin/facility/list";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
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
	public String getFacilityContentAdmin(@RequestParam(value = "fid") String fid, Model model, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if (svo.getName().equals("관리자")) {
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
			result = "admin/facility/detail";
		} else {
			rttr.addFlashAttribute("msg2", true);
			result = "redirect:/index";
		}
		
		return result;
	}

	@Override
	public String insertFacility(FacilityVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		
		SessionVO svo2 = new SessionVO();
		svo2.setId("admin");
		svo2.setName("관리자");
		session.setAttribute("svo", svo2);
		
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			if(vo.getFile1().getSize() != 0 && vo.getFile2().getSize() == 0 && vo.getFile3().getSize() == 0 && vo.getFile4().getSize() == 0) {
				UUID uuid = UUID.randomUUID();
				
				vo.setFimg(vo.getFile1().getOriginalFilename());
				vo.setFsimg(uuid+"_"+vo.getFile1().getOriginalFilename());
				
				File file = new File(vo.getSavepath()+vo.getFsimg());
				try {
					vo.getFile1().transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (vo.getFile1().getSize() != 0 && vo.getFile2().getSize() != 0 && vo.getFile3().getSize() == 0 && vo.getFile4().getSize() == 0) {
				UUID uuid = UUID.randomUUID();
				UUID uuid2 = UUID.randomUUID();
				
				vo.setFimg(vo.getFile1().getOriginalFilename()+","+vo.getFile2().getOriginalFilename());
				vo.setFsimg(uuid+"_"+vo.getFile1().getOriginalFilename()+","+uuid2+"_"+vo.getFile2().getOriginalFilename());
				
				File file = new File(vo.getSavepath()+uuid+"_"+vo.getFile1().getOriginalFilename());
				File file2 = new File(vo.getSavepath()+uuid2+"_"+vo.getFile2().getOriginalFilename());
				try {
					vo.getFile1().transferTo(file);
					vo.getFile2().transferTo(file2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (vo.getFile1().getSize() != 0 && vo.getFile2().getSize() != 0 && vo.getFile3().getSize() != 0 && vo.getFile4().getSize() == 0) {
				UUID uuid = UUID.randomUUID();
				UUID uuid2 = UUID.randomUUID();
				UUID uuid3 = UUID.randomUUID();
				
				vo.setFimg(vo.getFile1().getOriginalFilename()+","+vo.getFile2().getOriginalFilename()+","+vo.getFile3().getOriginalFilename());
				vo.setFsimg(uuid+"_"+vo.getFile1().getOriginalFilename()+","+uuid2+"_"+vo.getFile2().getOriginalFilename()+","+uuid3+"_"+vo.getFile3().getOriginalFilename());
				
				File file = new File(vo.getSavepath()+uuid+"_"+vo.getFile1().getOriginalFilename());
				File file2 = new File(vo.getSavepath()+uuid2+"_"+vo.getFile2().getOriginalFilename());
				File file3 = new File(vo.getSavepath()+uuid3+"_"+vo.getFile3().getOriginalFilename());
				try {
					vo.getFile1().transferTo(file);
					vo.getFile2().transferTo(file2);
					vo.getFile3().transferTo(file3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (vo.getFile1().getSize() != 0 && vo.getFile2().getSize() != 0 && vo.getFile3().getSize() != 0 && vo.getFile4().getSize() != 0) {
				UUID uuid = UUID.randomUUID();
				UUID uuid2 = UUID.randomUUID();
				UUID uuid3 = UUID.randomUUID();
				UUID uuid4 = UUID.randomUUID();
				
				vo.setFimg(vo.getFile1().getOriginalFilename()+","+vo.getFile2().getOriginalFilename()+","+vo.getFile3().getOriginalFilename()+","+vo.getFile4().getOriginalFilename());
				vo.setFsimg(uuid+"_"+vo.getFile1().getOriginalFilename()+","+uuid2+"_"+vo.getFile2().getOriginalFilename()+","+uuid3+"_"+vo.getFile3().getOriginalFilename()+","+uuid4+"_"+vo.getFile4().getOriginalFilename());
				
				File file = new File(vo.getSavepath()+uuid+"_"+vo.getFile1().getOriginalFilename());
				File file2 = new File(vo.getSavepath()+uuid2+"_"+vo.getFile2().getOriginalFilename());
				File file3 = new File(vo.getSavepath()+uuid3+"_"+vo.getFile3().getOriginalFilename());
				File file4 = new File(vo.getSavepath()+uuid4+"_"+vo.getFile4().getOriginalFilename());
				try {
					vo.getFile1().transferTo(file);
					vo.getFile2().transferTo(file2);
					vo.getFile3().transferTo(file3);
					vo.getFile4().transferTo(file4);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			boolean insert_result = facilityDAO.insertFacility(vo);
			
			if(insert_result) {
				rttr.addFlashAttribute("msg1", true);
				result = "redirect:/admin/facility/list";
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
	public String updateFacility(FacilityVO vo, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			/*if(vo.getFile1().getSize() != 0 && vo.getFile2().getSize() == 0 && vo.getFile3().getSize() == 0 && vo.getFile4().getSize() == 0) {
				UUID uuid = UUID.randomUUID();
				
				vo.setFimg(vo.getFile1().getOriginalFilename());
				vo.setFsimg(uuid+"_"+vo.getFile1().getOriginalFilename());
				
				File file = new File(vo.getSavepath()+vo.getFsimg());
				try {
					vo.getFile1().transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (vo.getFile1().getSize() != 0 && vo.getFile2().getSize() != 0 && vo.getFile3().getSize() == 0 && vo.getFile4().getSize() == 0) {
				UUID uuid = UUID.randomUUID();
				UUID uuid2 = UUID.randomUUID();
				
				vo.setFimg(vo.getFile1().getOriginalFilename()+","+vo.getFile2().getOriginalFilename());
				vo.setFsimg(uuid+"_"+vo.getFile1().getOriginalFilename()+","+uuid2+"_"+vo.getFile2().getOriginalFilename());
				
				File file = new File(vo.getSavepath()+uuid+"_"+vo.getFile1().getOriginalFilename());
				File file2 = new File(vo.getSavepath()+uuid2+"_"+vo.getFile2().getOriginalFilename());
				try {
					vo.getFile1().transferTo(file);
					vo.getFile2().transferTo(file2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (vo.getFile1().getSize() != 0 && vo.getFile2().getSize() != 0 && vo.getFile3().getSize() != 0 && vo.getFile4().getSize() == 0) {
				UUID uuid = UUID.randomUUID();
				UUID uuid2 = UUID.randomUUID();
				UUID uuid3 = UUID.randomUUID();
				
				vo.setFimg(vo.getFile1().getOriginalFilename()+","+vo.getFile2().getOriginalFilename()+","+vo.getFile3().getOriginalFilename());
				vo.setFsimg(uuid+"_"+vo.getFile1().getOriginalFilename()+","+uuid2+"_"+vo.getFile2().getOriginalFilename()+","+uuid3+"_"+vo.getFile3().getOriginalFilename());
				
				File file = new File(vo.getSavepath()+uuid+"_"+vo.getFile1().getOriginalFilename());
				File file2 = new File(vo.getSavepath()+uuid2+"_"+vo.getFile2().getOriginalFilename());
				File file3 = new File(vo.getSavepath()+uuid3+"_"+vo.getFile3().getOriginalFilename());
				try {
					vo.getFile1().transferTo(file);
					vo.getFile2().transferTo(file2);
					vo.getFile3().transferTo(file3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (vo.getFile1().getSize() != 0 && vo.getFile2().getSize() != 0 && vo.getFile3().getSize() != 0 && vo.getFile4().getSize() != 0) {
				UUID uuid = UUID.randomUUID();
				UUID uuid2 = UUID.randomUUID();
				UUID uuid3 = UUID.randomUUID();
				UUID uuid4 = UUID.randomUUID();
				
				vo.setFimg(vo.getFile1().getOriginalFilename()+","+vo.getFile2().getOriginalFilename()+","+vo.getFile3().getOriginalFilename()+","+vo.getFile4().getOriginalFilename());
				vo.setFsimg(uuid+"_"+vo.getFile1().getOriginalFilename()+","+uuid2+"_"+vo.getFile2().getOriginalFilename()+","+uuid3+"_"+vo.getFile3().getOriginalFilename()+","+uuid4+"_"+vo.getFile4().getOriginalFilename());
				
				File file = new File(vo.getSavepath()+uuid+"_"+vo.getFile1().getOriginalFilename());
				File file2 = new File(vo.getSavepath()+uuid2+"_"+vo.getFile2().getOriginalFilename());
				File file3 = new File(vo.getSavepath()+uuid3+"_"+vo.getFile3().getOriginalFilename());
				File file4 = new File(vo.getSavepath()+uuid4+"_"+vo.getFile4().getOriginalFilename());
				try {
					vo.getFile1().transferTo(file);
					vo.getFile2().transferTo(file2);
					vo.getFile3().transferTo(file3);
					vo.getFile4().transferTo(file4);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
			
			boolean update_result = facilityDAO.updateFacility(vo);
			
			if(update_result) {
				rttr.addFlashAttribute("msg2", true);
				result = "redirect:/admin/facility/list";
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
	public String deleteFacility(@RequestParam(value = "fid") String fid, HttpServletRequest request, RedirectAttributes rttr) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("svo");
		SessionVO svo = (SessionVO) obj;
		
		String result = "";
		
		if (obj == null) {
			rttr.addFlashAttribute("msg3", true);
			result = "redirect:/login";
		} else if(svo.getName().equals("관리자")) {
			boolean delete_result = facilityDAO.deleteFacility(fid);
			
			if(delete_result) {
				rttr.addFlashAttribute("msg3", true);
				result = "redirect:/admin/facility/list";
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
