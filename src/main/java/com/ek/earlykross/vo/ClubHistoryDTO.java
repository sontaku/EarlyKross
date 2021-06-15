package com.ek.earlykross.vo;

import com.ek.earlykross.entity.Club;
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
public class ClubHistoryDTO {
    private Club cId; // 클럽번호
    private String pMp; // 최다출장선수
    private String pMg; // 최다득점선수
    private String pMa; // 최다도움선수
    private String pMap; // 최다공포선수
    private int mostPlayed; // 최다출장수
    private int mostGoal; // 최다득점수
    private int mostAs; // 최다도움수
    private int mostAp; // 최다공격포인트수
}
