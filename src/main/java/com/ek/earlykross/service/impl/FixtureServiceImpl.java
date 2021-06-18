package com.ek.earlykross.service.impl;

import com.ek.earlykross.entity.Fixture;
import com.ek.earlykross.repository.FixtureRepository;
import com.ek.earlykross.service.FixtureService;
import com.ek.earlykross.vo.FixtureDTO;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class FixtureServiceImpl implements FixtureService {

  private final FixtureRepository fixtureRepository;

  @Override
  public List<FixtureDTO> getAllFixture() {
    List<Fixture> result = fixtureRepository.findAll();

    Function<Fixture, FixtureDTO> fn = (entity -> entityToDto(entity));
    List<FixtureDTO> FixtureDTOList = result.stream().map(fn).collect(Collectors.toList());
    return FixtureDTOList;
  }

  //Fixture entity to Dto
  FixtureDTO entityToDto(Fixture entity){
    FixtureDTO dto = FixtureDTO.builder()
        .fId(entity.getFId())
        .home(entity.getHome())
        .away(entity.getAway())
        .fDate(entity.getFDate())
        .stadium(entity.getStadium())
        .build();
    return dto;
  }
}
