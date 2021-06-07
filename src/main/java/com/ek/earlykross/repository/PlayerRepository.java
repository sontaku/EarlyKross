package com.ek.earlykross.repository;

import com.ek.earlykross.entity.League;
import com.ek.earlykross.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> { // <테이블 명, PK의 자료형)

}
