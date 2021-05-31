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

// 선수기록

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "playerRecord") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRecord implements Serializable {

    @Id // PK 지정
    @ManyToOne
    @JoinColumn(name = "pId")
    private Player pId; // 선수번호

    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String season; // 시즌

    @Column
    private int played; // 출장경기수
    @Column
    private int played_in; // 교체출장
    @Column
    private int played_out; // 교체아웃
    @Column
    private int inout_total; // 교체합계
    @Column
    private int fh_goal; // 전반 골
    @Column
    private int sh_goal; // 후반 골
    @Column
    private int ot_goal; // 연장 골
    @Column
    private int total_goal; // 합계 골
    @Column
    private int assist; // 도움
    @Column
    private int gk; // 골킥
    @Column
    private int ck; // 코너킥
    @Column
    private int fo; // 파울
    @Column
    private int os; // 오프사이드
    @Column
    private int st; // 슈팅
    @Column
    private int yellow; // 경고
    @Column
    private int red; // 퇴장
}
