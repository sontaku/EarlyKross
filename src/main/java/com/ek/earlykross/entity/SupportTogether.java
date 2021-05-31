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

// 같이응원

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "supportTogether") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
public class SupportTogether {

    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성번호
    private int stId; // 응원번호

    @ManyToOne
    @JoinColumn(name = "cId", nullable = false)
    private Club cId; // 응원팀

    @ManyToOne
    @JoinColumn(name = "hostId", nullable = false)
    private Member hostId; // 주최자

    @ManyToOne
    @JoinColumn(name = "guestId")
    private Member guestId; // 참가자

    @Column(columnDefinition = "varchar(50)")
    private String location; // 장소

    @Column(columnDefinition = "varchar(30)")
    private String stDate; // 일시
}