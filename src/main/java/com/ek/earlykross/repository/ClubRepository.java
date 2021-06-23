package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.League;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClubRepository extends JpaRepository<Club, Long> { // <테이블 명, PK의 자료형)

  // 클럽목록 - 1부리그
//  @Query("SELECT c"
//      + " FROM League l, Club c"
//      + " WHERE l.league = 'kleague'"
//      + " AND l.cId = c.cId ")
//  List<Club> getClub();

  // cId로 구단 탐색
  Club findBycId(int cId);

  // name으로 구단 탐색
  List<Club> findByNameContainingIgnoreCaseOrEnameContainingIgnoreCaseOrShortNameContainingIgnoreCase(String keyword1, String keyword2, String keyword3);
}
