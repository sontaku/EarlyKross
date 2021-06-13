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
import lombok.Setter;
import lombok.ToString;

// 선수

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "player") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Setter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성번호
    private int pId; // 선수번호

    @ManyToOne
    @JoinColumn(name = "cId")
    private Club cId; // 클럽번호 - 선수는 소속클럽이 없을 수 있음

    @Column(columnDefinition = "varchar(100)")
    private String name; // 이름

    @Column(columnDefinition = "varchar(100)")
    private String ename; // 영문명

    @Column(columnDefinition = "varchar(30)")
    private String position; // 포지션

    @Column
    private int backNo; // 등번호

    @Column(columnDefinition = "varchar(100)")
    private String nationality; // 국적

    @Column
    private int height; // 키

    @Column
    private int weight; // 몸무게

    @Column(columnDefinition = "varchar(30)")
    private String birthday; // 생년월일
}
