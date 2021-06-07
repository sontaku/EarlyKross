package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Memo;
import com.ek.earlykross.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

// QuerydslPredicateExecutor 검색 목적
public interface BestRepository extends JpaRepository<Player, Integer>, QuerydslPredicateExecutor<Player> { // <테이블 명, PK의 자료형)
    @Query("select p from Player p where p.name = :name order by p.pId desc")
    List<Player> getList(String name);
}
