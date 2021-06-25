package com.ek.earlykross.service.impl;

import com.ek.earlykross.entity.Fixture;
import com.ek.earlykross.repository.FixtureRepository;
import com.ek.earlykross.service.FixtureService;
import com.ek.earlykross.vo.FixtureDTO;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

// Bean 처리
@Service
@Log4j2
// 의존성 자동 주입
@RequiredArgsConstructor
public class FixtureServiceImpl implements FixtureService {

    private final FixtureRepository fixtureRepository;

//  @Override
//  public FixtureDTO getList() {
//    // JPA 로 DB 탐색
//    String fixturesTable = fixtureRepository.findFixtureByFDateIsNotNull();
//
////    FixtureDTO fixtureDTO = entityToDto(fixturesTable);
//
//
//    return fixtureDTO;
//  }

    public FixtureDTO getOne() {
        System.out.println(fixtureRepository.findFixtureByFDateIsNotNull());
        return entityToDto(fixtureRepository.findFixtureByFDateIsNotNull());
    }


}
