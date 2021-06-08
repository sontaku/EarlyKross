package com.ek.earlykross.vo;

import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.Player;
import javax.persistence.Column;
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
public class BestElevenDTO {
  private String season; // 시즌
  private int round; // 라운드 String 날짜형 sysdate 같은 주
  private Member mId; // 회원번호
  private Player p1; // 선수1
  private Player p2; // 선수2
  private Player p3; // 선수3
  private Player p4; // 선수4
  private Player p5; // 선수5
  private Player p6; // 선수6
  private Player p7; // 선수7
  private Player p8; // 선수8
  private Player p9; // 선수9
  private Player p10; // 선수10
  private Player p11; // 선수 : 골키퍼
  private String formation; // 포메이션
  private String formationText;
}
