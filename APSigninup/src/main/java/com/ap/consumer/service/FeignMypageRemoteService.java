package com.ap.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="ap-user-detail", url = "http://localhost:8183")
public interface FeignMypageRemoteService {

	@RequestMapping(value = "/mypage/")
	String mypage();
}
