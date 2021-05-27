package com.ek.earlykross.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.GenerationType;


@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "tbl_memo") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성번호
    private Long mno;

    @Column(length = 200, nullable = false) // 테이블 내 컬럼. 반대는 @Transient
    private String memoText;

    @Column(columnDefinition = "varchar(255) default 'SYSDATE'")
    private String writeDate;
}
