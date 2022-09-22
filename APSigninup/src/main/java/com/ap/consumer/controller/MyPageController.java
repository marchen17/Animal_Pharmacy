package com.ap.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ap.consumer.service.FeignMapRemoteService;
import com.ap.consumer.service.FeignMypageRemoteService;

@RestController
@RequestMapping("/mypage")
public class MyPageController {
	
	private final FeignMypageRemoteService feignMypageRemoteService;
	
	public MyPageController(FeignMypageRemoteService feignMypageRemoteService) {
		super();
		this.feignMypageRemoteService = feignMypageRemoteService;
	}

	@GetMapping("/")
	public String getMypage() {
		return mypage();
	}
	
	private String mypage() {
		return feignMypageRemoteService.mypage();
	}
}
