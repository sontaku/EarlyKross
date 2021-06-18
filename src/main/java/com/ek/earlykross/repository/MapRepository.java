package com.ek.earlykross.repository;

import com.ek.earlykross.entity.BestEleven;
import com.ek.earlykross.entity.BestElevenPK;
import com.ek.earlykross.entity.Map;
import com.ek.earlykross.entity.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

// QuerydslPredicateExecutor 검색 목적
public interface MapRepository extends JpaRepository<Map, Long>{ // <테이블 명, PK의 자료형)

}
