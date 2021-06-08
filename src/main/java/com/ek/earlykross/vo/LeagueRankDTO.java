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
public class LeagueRankDTO {

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

    private int pId; // 선수번호
    private String name; // 이름
    private String ename; // 영문명
    private String position; // 포지션
    private int backNo; // 등번호
    private String nationality; // 국적
    private int height; // 키
    private int weight; // 몸무게
    private String birthday; // 생년월일
}
