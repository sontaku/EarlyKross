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
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 리그

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "league") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
@IdClass(LeaguePK.class)
public class League implements Serializable {

    @Id // PK 지정
    @ManyToOne
    @JoinColumn(name = "cId")
    private Club cId; // 클럽번호

    @Id
    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String season; // 시즌

    @Column
    private int played; // 경기수

    @Column
    private int points; // 승점

    @Column
    private int won; // 승

    @Column
    private int drawn; // 무

    @Column
    private int lost; // 패

    @Column
    private int gf; // 득점

    @Column
    private int ga; // 실점

    @Column
    private int gd; // 득실차

    @Column
    private int assist; // 도움

    @Column
    private int fo; // 파울

    @Column
    private int rank; // 순위

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String league; // 리그 구분
}
