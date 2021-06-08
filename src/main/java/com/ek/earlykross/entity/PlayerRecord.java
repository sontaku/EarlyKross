package com.ek.earlykross.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 선수기록

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "playerRecord") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PlayerRecordPK.class)
public class PlayerRecord implements Serializable {

    @Id // PK 지정
    @ManyToOne
    @JoinColumn(name = "pId", nullable = false)
    private Player pId; // 선수번호

    @Id
    @ManyToOne
    @JoinColumn(name = "cId", nullable = false)
    private Club cId; // 클럽번호

    @Id
    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String season; // 시즌

    @Column
    private int played; // 출장경기수
    @Column
    private int playedIn; // 교체출장
    @Column
    private int playedOut; // 교체아웃
    @Column
    private int inoutTotal; // 교체합계
    @Column
    private int fhGoal; // 전반 골
    @Column
    private int shGoal; // 후반 골
    @Column
    private int otGoal; // 연장 골
    @Column
    private int totalGoal; // 합계 골
    @Column
    private int assist; // 도움
    @Column
    private int gk; // 골킥
    @Column
    private int ck; // 코너킥
    @Column
    private int fc; // 파울횟수
    @Column
    private int fs; // 파울 당한 횟수
    @Column
    private int os; // 오프사이드
    @Column
    private int st; // 슈팅
    @Column
    private int sot; // 유효슈팅
    @Column
    private int pkGoal; // pk득점
    @Column
    private int pkFail; // pk 실축
    @Column
    private float pkPer; // pk 성공률
    @Column
    private int yellow; // 경고
    @Column
    private int red; // 퇴장
    @Column
    private int ga; // 실점
    @Column
    private int og; // 자책골
    @Column
    private float rating; // 평점
}
