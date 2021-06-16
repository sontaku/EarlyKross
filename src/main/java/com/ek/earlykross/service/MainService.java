package com.ek.earlykross.service;

import com.ek.earlykross.entity.ClubNews;
import com.ek.earlykross.entity.League;
import com.ek.earlykross.vo.ClubNewsVO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.LeagueDTO;

public interface MainService {


  // 뉴스 한 개 읽기
  ClubNewsVO read(Long nId);

  // 뉴스 전체 읽기
//  List<ClubNewsVO> getList();

  // 뉴스 페이지 단위로 읽기
  PageResultDTO<ClubNewsVO, ClubNews> getList(PageRequestDTO requestDTO);

  default ClubNews dtoToEntity(ClubNewsVO dto) {
    ClubNews entity = ClubNews.builder()
        .nId(dto.getNId())
        .title(dto.getTitle())
        .updateTime(dto.getUpdateTime())
        .imageurl(dto.getImageurl())
        .source(dto.getSource())
        .cName(dto.getCName())
        .build();
    return entity;
  }

  // entity 를 dto 로 변환
  default ClubNewsVO entityToDto(ClubNews entity) {
    ClubNewsVO dto = ClubNewsVO.builder()
        .nId(entity.getNId())
        .title(entity.getTitle())
        .updateTime(entity.getUpdateTime())
        .imageurl(entity.getImageurl())
        .source(entity.getSource())
        .cName(entity.getCName())
        .build();
    return dto;
  }

  default League dtoToEntity(LeagueDTO dto) {
    League entity = League.builder()
        .cId(dto.getCId())
        .season(dto.getSeason())
        .played(dto.getPlayed())
        .points(dto.getPoints())
        .won(dto.getWon())
        .drawn(dto.getDrawn())
        .lost(dto.getLost())
        .gf(dto.getGf())
        .ga(dto.getGa())
        .gd(dto.getGd())
        .assist(dto.getAssist())
        .fo(dto.getFo())
        .rank(dto.getRank())
        .league(dto.getLeague())
        .build();
    return entity;
  }

  // entity 를 dto 로 변환
  default LeagueDTO entityToDto(League entity) {
    LeagueDTO dto = LeagueDTO.builder()
        .cId(entity.getCId())
        .season(entity.getSeason())
        .played(entity.getPlayed())
        .points(entity.getPoints())
        .won(entity.getWon())
        .drawn(entity.getDrawn())
        .lost(entity.getLost())
        .gf(entity.getGf())
        .ga(entity.getGa())
        .gd(entity.getGd())
        .assist(entity.getAssist())
        .fo(entity.getFo())
        .rank(entity.getRank())
        .league(entity.getLeague())
        .build();
    return dto;
  }


}
