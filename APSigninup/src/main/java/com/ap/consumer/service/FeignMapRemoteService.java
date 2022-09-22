package com.ap.consumer.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ap.consumer.vo.RowVO;

@FeignClient(name="ap-maps-detail", url = "http://localhost:8182")
public interface FeignMapRemoteService {
	
	@RequestMapping(method = RequestMethod.GET, value= "/maps/boardList")
	List<RowVO> getBoradList(@RequestParam int page);
}
