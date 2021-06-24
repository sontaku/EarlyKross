package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Map;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// QuerydslPredicateExecutor 검색 목적
public interface MapRepository extends JpaRepository<Map, Long>{ // <테이블 명, PK의 자료형)

  //Team 개수를 데이터 시각화함
  @Query(value = "SELECT team, COUNT(*) FROM map GROUP BY team",nativeQuery = true)
  List<List> countTeam();
}
