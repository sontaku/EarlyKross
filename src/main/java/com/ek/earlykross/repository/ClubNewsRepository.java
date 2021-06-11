package com.ek.earlykross.repository;

import com.ek.earlykross.entity.ClubNews;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ClubNewsRepository extends JpaRepository<ClubNews, Long>,
    QuerydslPredicateExecutor<ClubNews> {

}
