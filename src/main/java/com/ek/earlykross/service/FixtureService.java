package com.ek.earlykross.service;

import com.ek.earlykross.entity.Fixture;
import com.ek.earlykross.vo.FixtureDTO;

public interface FixtureService {

  // 예정된 최신 리그
//  FixtureDTO getList();
  public FixtureDTO getOne();
  // entity 를 dto 로 변환
  default FixtureDTO entityToDto (Fixture entity){
    FixtureDTO dto = FixtureDTO.builder()
        .fId(entity.getFId())
        .home(entity.getHome())
        .away(entity.getAway())
        .fDate(entity.getFDate())
        .stadium(entity.getStadium())
        .build();
    return dto;
  }

  // dto 를 entity 로 변환
  default Fixture dtoToEntity(FixtureDTO dto){
    Fixture entity = Fixture.builder()
        .fId(dto.getFId())
        .home(dto.getHome())
        .away(dto.getAway())
        .fDate(dto.getFDate())
        .stadium(dto.getStadium())
        .build();
    return entity;
  }
}
