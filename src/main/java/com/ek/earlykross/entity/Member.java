package com.ek.earlykross.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 회원

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "member") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성번호
    private int mId; // 회원번호

    @Column(columnDefinition = "varchar(30)")
    private String email; // 이메일

    @Column(columnDefinition = "varchar(30)")
    private String pw; // 비밀번호

    @Column(columnDefinition = "varchar(30)")
    private String nickname; // 닉네임

    @Column
    private int point; // 포인트

    @Column(nullable = false)
    private int auth; // 회원등급

    @Column
    private int blacklist; // 블랙리스트 0:기본, 1:블랙리스트
}