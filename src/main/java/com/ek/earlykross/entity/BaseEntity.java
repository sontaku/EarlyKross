package com.ek.earlykross.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// 이 엔티티는 테이블 생성 안함, JPA 는 엔티티를 관리하는 메모리 공간이 별도로 존재
@MappedSuperclass
//JPA 내부에서 엔티티 객체 생성 및 변경을 감지
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
abstract public class BaseEntity {

    // 엔티티 생성 시간 처리
    @CreatedDate
    // 해당 엔티티 객체를 DB 반영할 때 이 컬럼값은 업데이트 X
    @Column(name = "regDate", updatable = false)
    private LocalDateTime regDate;

    //최종 수정 시간 자동 처리
    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;

}
