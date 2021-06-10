package com.ek.earlykross.service;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.League;
import com.ek.earlykross.vo.ClubDTO;
import com.ek.earlykross.vo.LeagueDTO;
import java.util.List;
import java.util.Optional;

public interface DataCenterService {

  // 리그 순위 테이블
  List<LeagueDTO> getLeagueTable();

  // league entity
  // entity 를 dto 로 변환
  default LeagueDTO entityToDto(League entity) {
    LeagueDTO dto = LeagueDTO.builder()
        .assist(entity.getAssist())
        .cId(entity.getCId())
        .drawn(entity.getDrawn())
        .fo(entity.getFo())
        .ga(entity.getGa())
        .gd(entity.getGd())
        .gf(entity.getGf())
        .lost(entity.getLost())
        .played(entity.getPlayed())
        .points(entity.getPoints())
        .season(entity.getSeason())
        .won(entity.getWon())
        .build();
    return dto;
  }

  // 클럽 목록
//  List<ClubDTO> getClubList();

  // league entity
  // entity 를 dto 로 변환
  default ClubDTO entityToDto(Club entity) {
    ClubDTO dto = ClubDTO.builder()
        .cId(entity.getCId())
        .name(entity.getName())
        .ename(entity.getEname())
        .founded(entity.getFounded())
        .hometown(entity.getHometown())
        .manager(entity.getManager())
        .website(entity.getWebsite())
        .teamColor(entity.getTeamColor())
        .emblem(entity.getEmblem())
        .shortName(entity.getShortName())
        .stadium(entity.getStadium())
        .build();
    return dto;
  }

  // cId로 구단 탐색
  ClubDTO getClubBycId(int cId);
}
