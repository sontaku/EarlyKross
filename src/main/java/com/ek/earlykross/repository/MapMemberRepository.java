package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Map;
import com.ek.earlykross.entity.MapMember;
import org.springframework.data.jpa.repository.JpaRepository;

// QuerydslPredicateExecutor 검색 목적
public interface MapMemberRepository extends JpaRepository<MapMember, Long>{ // <테이블 명, PK의 자료형)


}
