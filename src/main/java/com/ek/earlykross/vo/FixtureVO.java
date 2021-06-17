package com.ek.earlykross.vo;

import lombok.Builder;
import lombok.Data;

@Data // 게터 세터 투스티링 이퀄 해시코드 자동생성
@Builder(toBuilder = true)
public class FixtureVO {

    private Long fId;
    private String fDate;
    private String stadium;
    private int away;
    private int home;
    private int round;

}
