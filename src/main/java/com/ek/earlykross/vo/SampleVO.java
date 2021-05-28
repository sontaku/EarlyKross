package com.ek.earlykross.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data // 게터 세터 투스티링 이퀄 해시코드 자동생성
@Builder(toBuilder = true)
public class SampleVO {

    private Long sno;
    private String first;
    private String last;
    private LocalDateTime regTime;

}
