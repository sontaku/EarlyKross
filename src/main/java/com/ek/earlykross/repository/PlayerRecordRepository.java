package com.ek.earlykross.repository;

import com.ek.earlykross.entity.League;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.entity.PlayerRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PlayerRecordRepository extends JpaRepository<PlayerRecord, Long>, QuerydslPredicateExecutor<PlayerRecord> {
  // 리그 최다 골 순위
  @Query("SELECT pr"
      + " FROM PlayerRecord pr"
      + " LEFT JOIN Club c ON c.cId = pr.cId "
      + " LEFT JOIN League l ON l.cId = c.cId"
      + " WHERE l.league = 'kleague'"
      + " ORDER BY pr.totalGoal DESC, pr.played")
  List<PlayerRecord> findByTotalGoalIsNotNull();

  // 리그 최다 도움 순위
  @Query("SELECT pr"
      + " FROM PlayerRecord pr"
      + " LEFT JOIN Club c ON c.cId = pr.cId "
      + " LEFT JOIN League l ON l.cId = c.cId"
      + " WHERE l.league = 'kleague'"
      + " ORDER BY pr.assist DESC, pr.played")
  List<PlayerRecord> findByAssistIsNotNull();

  // 리그 최다 공격포인트 순위
  @Query("SELECT pr, pr.totalGoal + pr.assist AS ap"
      + " FROM PlayerRecord pr"
      + " LEFT JOIN Club c ON c.cId = pr.cId "
      + " LEFT JOIN League l ON l.cId = c.cId"
      + " WHERE l.league = 'kleague'"
      + " ORDER BY ap DESC, pr.played")
  List<PlayerRecord> findByPlayedIsNotNull();
}
