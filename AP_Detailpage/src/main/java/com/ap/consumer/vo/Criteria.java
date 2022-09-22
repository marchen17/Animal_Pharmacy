package com.ap.consumer.vo;

import lombok.Data;

@Data
public class Criteria {
	
    private int pageNum;   //페이지 번호
    private int amount; 
    private String REFINE_ROADNM_ADDR;//페이지 출력개수
    private String BIZPLC_NM;
	private String ROADNM_ZIP_CD;
	private String SIGUN_NM;
    
    public  Criteria() {
        this(1,10);
    }
 
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

}
