package com.ek.earlykross.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 베스트일레븐

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "besteleven") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
@IdClass(BestElevenPK.class) // 다중복합키 불러옴
public class BestEleven implements Serializable {

    @Id // PK 지정
    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String season; // 시즌

    @Id // PK 지정
    @Column(nullable = false)
    private int round; // 라운드

    @ManyToOne
    @JoinColumn(name = "mId")
    private Member mId; // 회원번호

    @ManyToOne
    @JoinColumn(name = "p1", nullable = false)
    private Player p1; // 선수1

    @ManyToOne
    @JoinColumn(name = "p2", nullable = false)
    private Player p2; // 선수2

    @ManyToOne
    @JoinColumn(name = "p3", nullable = false)
    private Player p3; // 선수3

    @ManyToOne
    @JoinColumn(name = "p4", nullable = false)
    private Player p4; // 선수4

    @ManyToOne
    @JoinColumn(name = "p5", nullable = false)
    private Player p5; // 선수5
    
    @ManyToOne
    @JoinColumn(name = "p6", nullable = false)
    private Player p6; // 선수6

    @ManyToOne
    @JoinColumn(name = "p7", nullable = false)
    private Player p7; // 선수7

    @ManyToOne
    @JoinColumn(name = "p8", nullable = false)
    private Player p8; // 선수8

    @ManyToOne
    @JoinColumn(name = "p9", nullable = false)
    private Player p9; // 선수9

    @ManyToOne
    @JoinColumn(name = "p10", nullable = false)
    private Player p10; // 선수10

    @ManyToOne
    @JoinColumn(name = "gk", nullable = false)
    private Player gk; // 선수 : 골키퍼

    @Column(columnDefinition = "varchar(10)")
    private String formation; // 포메이션
}