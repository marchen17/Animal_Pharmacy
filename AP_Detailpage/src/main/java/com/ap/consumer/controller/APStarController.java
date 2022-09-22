package com.ap.consumer.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.ap.consumer.dao.StarDAO;
import com.ap.consumer.dao.nameDAO;
import com.ap.consumer.vo.Criteria;
import com.ap.consumer.vo.PageDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/star")
public class APStarController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	StarDAO sDAO;
	
	@Autowired
	nameDAO nDAO;
	
	private static final String MAP_URL = "http://localhost:8182/maps/";
	
	/* 약국이름과 주소 찾기 */
	@RequestMapping("/{REFINE_ROADNM_ADDR}*")
	public String getallinfo(@PathVariable String REFINE_ROADNM_ADDR, Criteria cri,Model model1) {
		//log.info("[CONTROLLER]get getAllInfo..." + cri);
		model1.addAttribute("page1",REFINE_ROADNM_ADDR);
		model1.addAttribute("getname2",nDAO.getname2(REFINE_ROADNM_ADDR));
		model1.addAttribute("getallinfo",sDAO.getAllInfo(cri));
		model1.addAttribute("pageMaker", new PageDTO(cri, sDAO.getTotalCount(REFINE_ROADNM_ADDR),REFINE_ROADNM_ADDR));
		model1.addAttribute("avg",sDAO.avg(REFINE_ROADNM_ADDR));
		
		return "Star";
	}
	
	@RequestMapping("/{BIZPLC_NM}/{ROADNM_ZIP_CD}")
	public String getinfo(@PathVariable String BIZPLC_NM,@PathVariable String ROADNM_ZIP_CD,
							Criteria cri,Model model1) {
		//log.info("[CONTROLLER]get getAllInfo..." + cri);
		model1.addAttribute("page1",BIZPLC_NM);
		model1.addAttribute("getname2",nDAO.getname(BIZPLC_NM,ROADNM_ZIP_CD));
		model1.addAttribute("getallinfo",sDAO.getAllInfo2(cri));
		model1.addAttribute("pageMaker", new PageDTO(cri, sDAO.getTotalCount2(BIZPLC_NM,ROADNM_ZIP_CD),BIZPLC_NM,ROADNM_ZIP_CD));
		model1.addAttribute("avg",sDAO.avg2(BIZPLC_NM,ROADNM_ZIP_CD));
		
		return "Star";
	}

	/* Pagination */
    @RequestMapping("/starupdate")
    public String updateinfo(HttpServletRequest req1,Model model1) throws UnsupportedEncodingException {
    	String rv_score = req1.getParameter("rating");
    	String rv_comment = req1.getParameter("text");
    	String REFINE_ROADNM_ADDR = req1.getParameter("NM1");
    	String BIZPLC_NM = req1.getParameter("BIZPLC_NM");
    	String ROADNM_ZIP_CD = req1.getParameter("ROADNM_ZIP_CD");
    	String SIGUN_NM = req1.getParameter("SIGUN_NM");
    	
    	HttpSession session = req1.getSession();
    	String testid = (String) session.getAttribute("mb_id");
    	System.out.println("testid >> "+testid);
    	
    	//sDAO.starupdate(rv_score,rv_comment,REFINE_ROADNM_ADDR);
    	sDAO.starupdate2(rv_score,rv_comment,BIZPLC_NM,ROADNM_ZIP_CD,SIGUN_NM);
    	String encodedParam = URLEncoder.encode(REFINE_ROADNM_ADDR, "UTF-8");
    	encodedParam = encodedParam.replaceAll("\\+", "%20");
    	String encodedNM = URLEncoder.encode(BIZPLC_NM, "UTF-8");

          
       // return "redirect:/star/" + encodedParam;
    	return "redirect:/star/" + encodedNM +"/" + ROADNM_ZIP_CD;
    }
    
	/* 헤더 버튼 클릭시 홈/지도메인으로 이동(미완) */
	@GetMapping("/maps")
	public String home() {
		return "redirect:"+MAP_URL;
	}

 
}