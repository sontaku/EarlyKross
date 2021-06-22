package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.Player;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PlayerRepository extends JpaRepository<Player, Long>, QuerydslPredicateExecutor<Player> {

  Player findPlayerByNameEqualsAndPositionEquals(String name, String position);

  // 클럽 별 선수
  List<Player> findPlayerBycId(Club cId);

  // 클럽 - 포지션별 선수
  List<Player> findBycIdAndPositionEquals(Club cId, String position);

  // 선수 조회(pId)
  Player findPlayerBypId(int pId);

  // 포지션 별 전체 선수 수 가져오기 ( 포지션과 , 포지션별 수 )
  @Query("select * position, count(*) from Player"
      + " group by position")
  List<List> countGroupByPos();

  Long countByPosition(String position);
}
