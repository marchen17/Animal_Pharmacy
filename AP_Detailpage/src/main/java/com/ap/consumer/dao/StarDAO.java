package com.ap.consumer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ap.consumer.vo.Criteria;
import com.ap.consumer.vo.StarVO;

@Mapper
public interface StarDAO {
	
	public List<StarVO> getAllInfo(Criteria cri);
	public List<StarVO> getAllInfo2(Criteria cri);
	public int starupdate(String rv_score, String rv_comment, String REFINE_ROADNM_ADDR);
	public int starupdate2(String rv_score, String rv_comment, String BIZPLC_NM, String ROADNM_ZIP_CD, String SIGUN_NM);
	public int getTotalCount(String REFINE_ROADNM_ADDR);
	public int getTotalCount2(String BIZPLC_NM, String ROADNM_ZIP_CD);
	public int avg(String REFINE_ROADNM_ADDR);
	public int avg2(String BIZPLC_NM, String ROADNM_ZIP_CD);

}
