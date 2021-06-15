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

// 채팅 정보

@Entity // 엔티티를 위한 클래스(클래스 내 인스턴스를 JPA로 관리)
@Table(name = "chat") // name으로 지정한 이름으로 테이블 생성
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
public class Chat {

  @Id // PK 지정
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cId; // 채팅번호

  @Column(nullable = false)
  private String rId; // 방번호

  @ManyToOne
  @JoinColumn(name = "mId", nullable = false)
  private Member mId; // 멤버 ID

  @Column(nullable = false)
  private String cMsg; // 채팅 내용

  @Column(nullable = false)
  private String cDate; // 채팅 날짜

}
