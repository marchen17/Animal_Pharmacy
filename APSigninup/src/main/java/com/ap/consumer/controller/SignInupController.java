package com.ap.consumer.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.ap.consumer.service.FeignMapRemoteService;
import com.ap.consumer.service.FeignMypageRemoteService;
import com.ap.consumer.service.MapRemoteService;
import com.ap.consumer.service.MemberService;
import com.ap.consumer.vo.Member;

@Controller
@RequestMapping(path="/users")
public class SignInupController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MemberService mService;
	
	private final MapRemoteService mapRemoteService;
	private final FeignMypageRemoteService feignMypageRemoteService;
	
	private static final String MAP_URL = "http://localhost:8182/maps/";
	private static final String STAR_URL = "http://localhost:8183/star";
	
	public SignInupController(MapRemoteService mapRemoteService, FeignMypageRemoteService feignMypageRemoteService) {
		super();
		this.mapRemoteService = mapRemoteService;
		this.feignMypageRemoteService = feignMypageRemoteService;
	}

	@GetMapping("/")
	public String index() {
		return "login";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "login";
	}
	
	@GetMapping("/signupForm")
	public String signupForm(Model model) {
		
		Member member = new Member(null, null, null, null, null);
		model.addAttribute("member", member);
		
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid@ModelAttribute Member member,BindingResult bResult, Model model) {

		System.out.println(member.toString());
		
		Member existMember = mService.findByMbid(member.getMb_id());
		
		if(existMember != null) {
			bResult.rejectValue("mb_id", null, "이미 존재하는 아이디 입니다");
		}
		
		if(bResult.hasErrors()) {
			return "signup";
		} else {
			model.addAttribute("member", member);
			mService.insertNewAccount(member);
			
			return "redirect:loginForm";
		}
	}
	
	@GetMapping("/success")
	public String success(HttpSession session) {
		
		//System.out.println("mb_id >> "+session.getAttribute("mb_id"));
		
		//String mypageString = mypage();
		//System.out.println("mypageString >> " + mypageString);
		
		//return "success";
		
		return "redirect:"+MAP_URL;
	}
	
	/*
	 * private String mypage() { System.out.println("it's mypage() ");
	 * 
	 * return feignMypageRemoteService.mypage(); //return mapRemoteService.mypage();
	 * }
	 */
	
}