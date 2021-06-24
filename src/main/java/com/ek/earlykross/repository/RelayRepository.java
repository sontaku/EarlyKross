package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Relay;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelayRepository extends JpaRepository<Relay, Long> {
// select * from relay where f_id=20210606170990 order by r_id desc;

  List<Relay> findByfId(Long fId);

}
