package com.ap.consumer.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ap.consumer.vo.RowVO;

@Service
public class MapRemoteServceImpl implements MapRemoteService {
	
	private static final String url = "http://ap-user-detail/mypage/";
	private static final String MAP_URL = "http://ap-maps-service/maps";
	private final RestTemplate restTemplate;

	public MapRemoteServceImpl(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public String mypage() {
		// TODO Auto-generated method stub
		return this.restTemplate.getForObject(url, String.class);
	}

	@Override
	public List<RowVO> getBoradList(int page) {
		// TODO Auto-generated method stub
		
		RowVO[] boradVos = this.restTemplate.getForObject(MAP_URL+"/boardList", RowVO[].class);
		List<RowVO> list = Arrays.asList(boradVos);
		
		ResponseEntity<List<RowVO>> response = 
				restTemplate.exchange(MAP_URL+"/boardList",HttpMethod.GET, null, 
						new ParameterizedTypeReference<List<RowVO>>() {});
		List<RowVO> list2 = response.getBody();
		return list2;
		
	}
	
	

}
