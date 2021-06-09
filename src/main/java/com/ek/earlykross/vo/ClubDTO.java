package com.ek.earlykross.vo;

import com.ek.earlykross.entity.Club;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 클럽(구단) - 1부리그

@Data // 게터 세터 투스티링 이퀄 해시코드 자동생성
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ClubDTO {

    private int cId; // 클럽번호
    private String name; // 이름
    private String ename; // 영문명
    private String founded; // 창단연도
    private String hometown; // 연고지
    private String stadium; // 홈경기장
    private String manager; // 감독
    private String website; // 웹사이트
    private String teamColor; // 상징색
    private String emblem; // 엠블럼
    private String shortName; // 숏네임
}