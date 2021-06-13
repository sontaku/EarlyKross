package com.ek.earlykross.service;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.League;
import com.ek.earlykross.entity.PlayerRecord;
import com.ek.earlykross.vo.ClubDTO;
import com.ek.earlykross.vo.LeagueDTO;
import com.ek.earlykross.vo.PlayerRecordDTO;
import java.util.List;

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

  // club entity
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

  // player_record goal entity
  // entity 를 dto 로 변환
  default PlayerRecordDTO entityToDto(PlayerRecord entity) {
    PlayerRecordDTO dto = PlayerRecordDTO.builder()
        .pId(entity.getPId())
        .season(entity.getSeason())
        .played(entity.getPlayed())
        .playedIn(entity.getPlayedIn())
        .playedOut(entity.getPlayedOut())
        .inoutTotal(entity.getInoutTotal())
        .fhGoal(entity.getFhGoal())
        .shGoal(entity.getShGoal())
        .otGoal(entity.getOtGoal())
        .totalGoal(entity.getTotalGoal())
        .assist(entity.getAssist())
        .gk(entity.getGk())
        .ck(entity.getCk())
        .fc(entity.getFc())
        .fs(entity.getFs())
        .os(entity.getOs())
        .st(entity.getSt())
        .sot(entity.getSot())
        .pkGoal(entity.getPkGoal())
        .pkFail(entity.getPkFail())
        .pkPer(entity.getPkPer())
        .yellow(entity.getYellow())
        .red(entity.getRed())
        .ga(entity.getGa())
        .og(entity.getOg())
        .rating(entity.getRating())
        .build();
    return dto;
  }

  // cId로 구단 탐색
  ClubDTO getClubBycId(int cId);

  // 리그 최다 골 순위
  List<PlayerRecordDTO> getLeagueTopGoal();
  // 리그 최다 도움 순위
  List<PlayerRecordDTO> getLeagueTopAssist();
  // 리그 최다 공격포인트 순위
  List<PlayerRecordDTO> getLeagueTopAp();

  // 시즌 선수 기록
  List<PlayerRecordDTO> getPlayerSeasonRecord();
}
