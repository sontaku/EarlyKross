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

// 클럽(구단)

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "club") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
public class Club {

    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성번호
    private int cId; // 클럽번호

    @Column(columnDefinition = "varchar(30)")
    private String name; // 이름

    @Column(columnDefinition = "varchar(30)")
    private String ename; // 영문명

    @Column(columnDefinition = "varchar(30)")
    private String founded; // 창단연도

    @Column(columnDefinition = "varchar(50)")
    private String hometown; // 홈 경기장

    @Column(columnDefinition = "varchar(30)")
    private String manager; // 감독

    @Column(columnDefinition = "varchar(100)")
    private String website; // 웹사이트

    @Column(columnDefinition = "varchar(10)")
    private String teamColor; // 상징색

    @Column(columnDefinition = "varchar(30)")
    private String emblem; // 엠블럼
}