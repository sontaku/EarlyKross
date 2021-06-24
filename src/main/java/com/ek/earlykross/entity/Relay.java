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

// 중계방(경기내용)

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "relay") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
public class Relay implements Serializable {

    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rId;

    @Column(columnDefinition = "bigint(20)")
    private Long fId; // 경기번호
    
    @Column(columnDefinition = "varchar(30)")
    private String rDate; // 시간

    @Column(columnDefinition = "text")
    private String rText; // 내용
}
