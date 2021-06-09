package com.ek.earlykross.vo;

import lombok.Builder;
import lombok.Data;

@Data // 게터 세터 투스티링 이퀄 해시코드 자동생성
@Builder(toBuilder = true)
public class ClubNewsVO {

  private int nId;
  private String title;
  private String updateTime;
  private String imageurl;
  private String source;
  private String cName;
}
