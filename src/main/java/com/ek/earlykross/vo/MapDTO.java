package com.ek.earlykross.vo;

import com.ek.earlykross.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 게터 세터 투스티링 이퀄 해시코드 자동생성
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MapDTO {

    private Long mId;
    private Double xLoc;
    private Double yLoc;
    private String content;
    private String date;
    private int team;
    private Member host;
}
