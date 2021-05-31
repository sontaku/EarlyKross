package com.ek.earlykross.repository;

import com.ek.earlykross.entity.ClubBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubBoardRepository extends JpaRepository<ClubBoard, Long> { // <테이블 명, PK의 자료형)

}
