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

// 클럽 뉴스

@Table(name = "clubNews") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "club_news") // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
public class ClubNews {

  @Id // PK 지정
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성번호
  private int nId; // 뉴스번호


  @Column(columnDefinition = "varchar(30)")
  private String cName; // 클럽이름

  @Column(columnDefinition = "varchar(300)")
  private String title; // 제목

  @Column(columnDefinition = "varchar(50)")
  private String updateTime; // 업데이트일

  @Column(columnDefinition = "varchar(500)")
  private String imageurl; // 이미지

  @Column(columnDefinition = "varchar(500)")
  private String source; // 원본

}