package com.ek.earlykross.vo;

import lombok.Builder;
import lombok.Data;

@Data // 게터 세터 투스티링 이퀄 해시코드 자동생성
@Builder(toBuilder = true)
public class ClubBoardVO {

    private int inc;
    private String cate;
    private String title;
    private String content;
    private String user;
    private String date;
    private boolean cPublic;
    private int cRead;

}
