package com.ek.earlykross.vo;

import com.ek.earlykross.entity.Club;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 게터 세터 투스티링 이퀄 해시코드 자동생성
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class LeagueDTO {

    private Club cId; // 클럽번호
    private String season; // 시즌
    private int played; // 경기수
    private int points; // 승점
    private int won; // 승
    private int drawn; // 무
    private int lost; // 패
    private int gf; // 득점
    private int ga; // 실점
    private int gd; // 득실차
    private int assist; // 도움
    private int fo; // 파울
}
