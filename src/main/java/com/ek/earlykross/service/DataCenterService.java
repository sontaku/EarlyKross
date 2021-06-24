package com.ek.earlykross.service;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.ClubHistory;
import com.ek.earlykross.entity.ClubNews;
import com.ek.earlykross.entity.League;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.entity.PlayerRecord;
import com.ek.earlykross.vo.ClubDTO;
import com.ek.earlykross.vo.ClubHistoryDTO;
import com.ek.earlykross.vo.ClubNewsVO;
import com.ek.earlykross.vo.LeagueDTO;
import com.ek.earlykross.vo.PlayerDTO;
import com.ek.earlykross.vo.PlayerRecordDTO;
import java.util.List;

public interface DataCenterService {

  // 리그 순위 테이블
  List<LeagueDTO> getLeagueTable();

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

  // 클럽 - 포지션별 선수
  List<List<PlayerDTO>> getPlayerByPosition(int cId);

  // 시즌 게임당 골, 유효슈팅, 슈팅, 공격포인트
  String getTeamStat(int cId);

  // 클럽 통산 선수 기록
  ClubHistoryDTO getClubHistoryBycId(int cId);

  // 클럽별 선수 조회
  List<PlayerDTO> getPlayerBycId(String cId);

  // 선수 조회(pId)
  PlayerDTO getPlayerBypId(String pId);

  // 선수 시즌 기록(pId)
  PlayerRecordDTO getPlayerRecordBypId(String pId);

  // 클럽 검색 결과
  List<ClubDTO> getClubByName(String keyword);

  // 선수 검색 결과
  List<PlayerDTO> getPlayerByName(String keyword);

  // 뉴스 검색 결과
  List<ClubNewsVO> getNewsByCnameAndTitle(String keyword);

  // == entity to dto ===================================================
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

  // player entity
  // entity 를 dto 로 변환
  default PlayerDTO entityToDto(Player entity) {
    PlayerDTO dto = PlayerDTO.builder()
        .pId(entity.getPId())
        .cId(entity.getCId())
        .name(entity.getName())
        .ename(entity.getEname())
        .position(entity.getPosition())
        .backNo(entity.getBackNo())
        .nationality(entity.getNationality())
        .height(entity.getHeight())
        .weight(entity.getWeight())
        .birthday(entity.getBirthday())
        .build();
    return dto;
  }

  // club_history entity
  // entity 를 dto 로 변환
  default ClubHistoryDTO entityToDto(ClubHistory entity) {
    ClubHistoryDTO dto = ClubHistoryDTO.builder()
        .cId(entity.getCId())
        .pMp(entity.getPMp())
        .pMg(entity.getPMg())
        .pMa(entity.getPMa())
        .pMap(entity.getPMap())
        .mostPlayed(entity.getMostPlayed())
        .mostGoal(entity.getMostGoal())
        .mostAs(entity.getMostAs())
        .mostAp(entity.getMostAp())
        .build();
    return dto;
  }

  // club_news entity
  // dto 를 entity 로 변환
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

}
