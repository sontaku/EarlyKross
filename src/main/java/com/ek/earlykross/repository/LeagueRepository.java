package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.League;
import com.ek.earlykross.vo.LeagueDTO;
import com.ek.earlykross.vo.LeagueRankDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LeagueRepository extends JpaRepository<League, Long> { // <테이블 명, PK의 자료형)

  // 리그 순위
  //
  // k리그 순위 규정
  // 1. 승점
  // 2. 다득점
  // 3. 득실차
  // 4. 다승
  // 5. 승자승
  // 6. 실경기시간(ATP)순
  // 7. 추첨
//  @Query("SELECT * FROM league"
//      + " WHERE league = 'kleague'"
//      + " ORDER BY points DESC, gf DESC, gd DESC")
//  List<League> getList();

  // 리그 순위 - 규정이 적용된 테이블 크롤링시
  List<League> findAllByLeagueEqualsOrderByRankAsc(String leagueName);
}
