package com.ek.earlykross.vo;

import com.ek.earlykross.entity.Club;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 게터 세터 투스티링 이퀄 해시코드 자동생성
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MemberDTO {

    private Long mId;
    private String email;
    private String name;
    private Long point;
    private String password;
    private Boolean social;
    private boolean blacklist;
}
