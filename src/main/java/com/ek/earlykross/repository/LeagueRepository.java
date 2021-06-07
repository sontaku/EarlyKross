package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Long> { // <테이블 명, PK의 자료형)

}
