package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixtureRepository extends JpaRepository<Fixture, Long> {

}