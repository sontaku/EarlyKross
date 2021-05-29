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

// 팀별 게시판

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "clubBoard") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
public class ClubBoard {

    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성번호
    private int cbId; // 클럽번호

    @ManyToOne
    @JoinColumn(name = "cId")
    private Club cId;

    @ManyToOne
    @JoinColumn(name = "mId")
    private Member mId;

    @Column(columnDefinition = "varchar(30)")
    private String title; // 제목

    @Column(columnDefinition = "varchar(30)")
    private String cbDate; // 작성일

    @Column
    private int view; // 조회수


}