package com.ek.earlykross.vo;

import com.ek.earlykross.entity.Club;
import lombok.Builder;
import lombok.Data;

@Data // 게터 세터 투스티링 이퀄 해시코드 자동생성
@Builder(toBuilder = true)
public class FixtureDTO {

  private Long fId; // 경기번호
  private Club home; // 홈
  private Club away; // 어웨이
  private String fDate; // 일시
  private String stadium; // 경기장
}
