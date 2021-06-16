package com.ek.earlykross.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성번호
    private Long mId;

    private String email; // 이메일

    private String password; // 비밀번호

    private String name; // 닉네임

    @Column(columnDefinition = "BigInt default 0")
    private Long point; // 회원포인트 기본값:0

    private boolean fromSocial; // 소셜 가입여부

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    public void addMemberRole(MemberRole memberRole){
        roleSet.add(memberRole);
    }

    @Column(columnDefinition = "boolean default 0")
    private boolean blacklist; // 블랙리스트 0:기본, 1:블랙리스트


}