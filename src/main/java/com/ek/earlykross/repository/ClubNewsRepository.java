package com.ek.earlykross.repository;

import com.ek.earlykross.entity.ClubNews;
import com.querydsl.core.BooleanBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ClubNewsRepository extends JpaRepository<ClubNews, Long>,
    QuerydslPredicateExecutor<ClubNews> {

  // 뉴스 검색 ( c_name, title )
  List<ClubNews> findBycNameContainingIgnoreCaseOrTitleContainingIgnoreCase(String keyword1, String keyword2);
}
