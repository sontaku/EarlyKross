package com.ek.earlykross.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 클럽기록

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "clubResults") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
public class ClubResults implements Serializable {

    @Id // PK 지정
    @ManyToOne
    @JoinColumn(name = "cId")
    private Club cId; // 클럽번호

    @ManyToOne
    @JoinColumn(name = "pMp")
    private Player pMp; // 최다출장선수

    @ManyToOne
    @JoinColumn(name = "pMg")
    private Player pMg; // 최다득점선수

    @ManyToOne
    @JoinColumn(name = "pMa")
    private Player pMa; // 최다도움선수

    @ManyToOne
    @JoinColumn(name = "pMap")
    private Player pMap; // 최다공포선수

    @Column
    private int mostPlayed; // 최다출장수

    @Column
    private int mostGoal; // 최다득점수

    @Column
    private int mostAs; // 최다도움수

    @Column
    private int mostAp; // 최다공격포인트수
}