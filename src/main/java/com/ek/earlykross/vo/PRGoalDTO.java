package com.ek.earlykross.vo;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // 게터 세터 투스티링 이퀄 해시코드 자동생성
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PRGoalDTO {

  private int pId; // 선수번호
  private int totalGoal; // 합계 골
  private String pname; // 선수이름
  private String cname; // 클럽 명
}