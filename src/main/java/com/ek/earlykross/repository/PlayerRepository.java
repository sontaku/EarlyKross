package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.League;
import com.ek.earlykross.entity.Memo;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.vo.PlayerDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PlayerRepository extends JpaRepository<Player, Long>, QuerydslPredicateExecutor<Player> {

  Player findPlayerByNameEqualsAndPositionEquals(String name, String position);

  // 클럽 - 포지션별 선수
  List<Player> findBycIdAndPositionEquals(Club cId, String position);

//  List<Player> findAll();
}
