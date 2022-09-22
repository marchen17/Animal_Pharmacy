package com.ap.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ap.consumer.vo.Criteria;
import com.ap.consumer.vo.PageDTO;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/star")
@Log4j2
public class StarController {
	
	@GetMapping("/{REFINE_ROADNM_ADDR}*")
	public String getAllStarInfo(@PathVariable String REFINE_ROADNM_ADDR) {
		
		String allinfo = getallinfo();
		
		return "Star";
	}
	
	private String getallinfo() {
		return "";
	}
}
