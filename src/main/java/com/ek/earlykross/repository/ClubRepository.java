package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> { // <테이블 명, PK의 자료형)

}
