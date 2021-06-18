package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Fixture;
import com.ek.earlykross.entity.Member;
import com.ek.earlykross.vo.FixtureDTO;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FixtureRepository extends JpaRepository<Fixture, Long> {

//  @Query(value="SELECT * FROM fixture f WHERE DATEDIFF(f.f_date,SYSDATE())=(SELECT MIN(DATEDIFF(g.f_date,SYSDATE())) FROM fixture g WHERE DATEDIFF(f_date,SYSDATE()) > 0)", nativeQuery = true)
//  String findFixtureByFDateIsNotNull();

  @Query(value = "SELECT * FROM fixture f WHERE DATEDIFF(f.f_date,SYSDATE())=(SELECT MIN(DATEDIFF(g.f_date,SYSDATE())) FROM fixture g WHERE DATEDIFF(f_date,SYSDATE()) > 0)", nativeQuery = true)
  String findFixtureByFDateIsNotNull();

}