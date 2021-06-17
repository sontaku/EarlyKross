package com.ek.earlykross.repository;

import com.ek.earlykross.entity.BestEleven;
import com.ek.earlykross.entity.BestElevenPK;
import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.Memo;
import com.ek.earlykross.entity.Player;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

// QuerydslPredicateExecutor 검색 목적
public interface BestRepository extends JpaRepository<BestEleven, BestElevenPK>{ // <테이블 명, PK의 자료형)
//    @Query("select p from Player p where p.name = :name order by p.pId desc")
//    List<Player> getList(String name);



    Optional<BestEleven> findBestElevenBymIdAndRoundAndSeason(Member mId, int round, String season);

    List<BestEleven> findAllBymId(Member MId);
    BestEleven findBestElevenBymIdAndRound(Member mId, int round);
}
