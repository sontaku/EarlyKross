package com.ek.earlykross.vo;

import com.ek.earlykross.entity.Map;
import com.ek.earlykross.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 게터 세터 투스티링 이퀄 해시코드 자동생성
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MapMemberDTO {

    private Long uId;
    private Map mId;
    private Member user;
}
