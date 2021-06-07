package com.ek.earlykross.entity;

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

// 경기일정

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "fixture") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
public class Fixture {

    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성번호
    private String fId; // 경기번호
    
    @ManyToOne
    @JoinColumn(name = "home", nullable = false)
    private Club home; // 홈

    @ManyToOne
    @JoinColumn(name = "away", nullable = false)
    private Club away; // 어웨이
    
    @Column(columnDefinition = "varchar(30)")
    private String fDate; // 일시

    @Column(columnDefinition = "varchar(50)")
    private String stadium; // 경기장
}
