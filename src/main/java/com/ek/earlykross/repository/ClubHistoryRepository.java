package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.ClubHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubHistoryRepository extends JpaRepository<ClubHistory, Club> { // <테이블 명, PK의 자료형)
  ClubHistory findClubHistoryBycId(Club cId);
}
