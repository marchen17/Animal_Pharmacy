package com.ap.consumer.vo;

import lombok.Data;

@Data
public class StarVO {
	
	private String num;
	private String mb_id;
	private String rv_comment;
	private String rv_score;
	private String REFINE_ROADNM_ADDR; //우편번호로 변경
	private String BIZPLC_NM;
	private String ROADNM_ZIP_CD;
	private String SIGUN_NM;

}
