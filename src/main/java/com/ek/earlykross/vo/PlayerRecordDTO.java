package com.ek.earlykross.vo;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.Player;
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
public class PlayerRecordDTO {

  private Player pId; // 선수번호
  private Club cId; // 클럽번호
  private String season; // 시즌
  private int played; // 출장경기수
  private int playedIn; // 교체출장
  private int playedOut; // 교체아웃
  private int inoutTotal; // 교체합계
  private int fhGoal; // 전반 골
  private int shGoal; // 후반 골
  private int otGoal; // 연장 골
  private int totalGoal; // 합계 골
  private int assist; // 도움
  private int gk; // 골킥
  private int ck; // 코너킥
  private int fc; // 파울횟수
  private int fs; // 파울 당한 횟수
  private int os; // 오프사이드
  private int st; // 슈팅
  private int sot; // 유효슈팅
  private int pkGoal; // pk득점
  private int pkFail; // pk 실축
  private float pkPer; // pk 성공률
  private int yellow; // 경고
  private int red; // 퇴장
  private int ga; // 실점
  private int og; // 자책골
  private float rating; // 평점
}