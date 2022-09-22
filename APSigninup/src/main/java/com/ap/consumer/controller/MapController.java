package com.ap.consumer.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ap.consumer.vo.RowVO;
import com.ap.consumer.service.FeignMapRemoteService;
import com.ap.consumer.service.MapRemoteService;

@Controller
@RequestMapping("/map")
public class MapController {
	
	private final FeignMapRemoteService feignMapRemoteService;
	private final MapRemoteService mapRemoteService;

	public MapController(FeignMapRemoteService feignMapRemoteService, MapRemoteService mapRemoteService) {
		super();
		this.feignMapRemoteService = feignMapRemoteService;
		this.mapRemoteService = mapRemoteService;
	}

	@GetMapping("/")
	public ModelAndView start(@RequestParam(defaultValue = "1") int page){
		ModelAndView mView = new ModelAndView();
        mView.setViewName("index.html");
		
		return mView;
	}
	
	@GetMapping("/getBoardList")
	public List<RowVO> boardList(@RequestParam(defaultValue = "1") int page){
		return getBoradList(page);
	}
	
	private List<RowVO> getBoradList(int page) {
		//return mapRemoteService.getBoradList(page);
		return feignMapRemoteService.getBoradList(page);
	}
}
