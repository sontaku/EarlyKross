package com.ek.earlykross.entity;

import lombok.*;

import javax.persistence.*;


@Entity // 이 클래스는 엔티티 위한 클래스이다. Bean 느낌. JPA 에서 반드시 추가. 옵션 따라 테이블 자동 구성
@Table(name = "club_board")// 이 클래스를 어떤 테이블로 생성할지. 테이블 명 뿐만 아니라 인덱스도 설정 가능
@ToString
@Getter // 게터 메소드 생성
@Setter
@Builder // 객체 생성
@AllArgsConstructor // 빌드 컴파일 에러 방지
@NoArgsConstructor // 빌드 컴파일 에러 방지
public class ClubBoard {

    @Id // 이 필드는 PK 이다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값을 사용자가 초기화하지 않으면 자동 번호 생성, (auto increment)
    private Long inc;

    @Column(length = 30, nullable = false)
    private String cate;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 5000, nullable = false)
    private String content;

    @Column(length = 30, nullable = false)
    private String user;

    @Column(length = 50, nullable = false)
    private String date;

    @Column(nullable = true)
    private boolean cPublic;

    @Column(length = 30, nullable = false)
    private String cRead;

}
