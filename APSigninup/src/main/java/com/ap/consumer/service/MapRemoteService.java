package com.ap.consumer.service;

import java.util.List;

import com.ap.consumer.vo.RowVO;

public interface MapRemoteService {
	String mypage();
	
	List<RowVO> getBoradList(int page);
}
