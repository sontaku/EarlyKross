package com.ek.earlykross.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 회원

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
public class Map{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성번호
    private Long mId;
    private Double xLoc;
    private Double yLoc;
    private String content;
    private String date;
    private int team;

    @ManyToOne
    @JoinColumn(name = "host", nullable = false)
    private Member host;

    private int mCount;

    public void changeMCount(int mCount){
        this.mCount = mCount;
    }

}