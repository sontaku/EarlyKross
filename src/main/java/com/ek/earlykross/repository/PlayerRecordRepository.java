package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.League;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.entity.PlayerRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

public interface PlayerRecordRepository extends JpaRepository<PlayerRecord, Long>, QuerydslPredicateExecutor<PlayerRecord> {
  // 선수별 시즌기록(pId)
  PlayerRecord findPlayerRecordBypId(Player pId);

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

  // 시즌 선수 기록 (골 순위-임시)
  @Query("SELECT pr"
      + " FROM PlayerRecord pr , League l"
      + " WHERE pr.cId = l.cId"
      + " AND l.league = 'kleague'"
      + " ORDER BY pr.totalGoal DESC")
  List<PlayerRecord> findTop20ByPlayedIsNotNull();


  // 시즌 게임당 골, 유효슈팅, 슈팅, 공격포인트
  @Query(value = "SELECT "
      + " ROUND(SUM(pr.total_goal)/l.played, 1) AS GPG, "
      + " ROUND(SUM(pr.st)/l.played, 1) AS TSPG, "
      + " ROUND(SUM(pr.sot)/l.played, 1) AS SOPG, "
      + " ROUND((sum(pr.total_goal) + SUM(pr.assist))/l.played, 1) AS APPG"
      + " FROM league l, player_record pr"
      + " WHERE l.c_id = pr.c_id"
      + " AND pr.c_id =:cId" , nativeQuery = true)
  String getStatistic(@Param("cId") Club cId);
//  List<PlayerRecord> findPlayerRecordBycId(Club cId);
}
