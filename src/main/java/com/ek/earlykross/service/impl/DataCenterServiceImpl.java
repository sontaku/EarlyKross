package com.ek.earlykross.service.impl;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.League;
import com.ek.earlykross.entity.PlayerRecord;
import com.ek.earlykross.repository.ClubRepository;
import com.ek.earlykross.repository.LeagueRepository;
import com.ek.earlykross.repository.PlayerRecordRepository;
import com.ek.earlykross.service.DataCenterService;
import com.ek.earlykross.vo.ClubDTO;
import com.ek.earlykross.vo.LeagueDTO;
import com.ek.earlykross.vo.PRGoalDTO;
import com.ek.earlykross.vo.PlayerRecordDTO;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

// Bean 처리
@Service
@Log4j2
// 의존성 자동 주입
@RequiredArgsConstructor
public class DataCenterServiceImpl implements DataCenterService {

  private final LeagueRepository leagueRepository;
  private final ClubRepository clubRepository;
  private final PlayerRecordRepository playerRecordRepository;

  // 리그 순위
  @Override
  public List<LeagueDTO> getLeagueTable() {
    // JPA 로 DB 탐색
    List<League> leagueTable = leagueRepository.findAllByLeagueEqualsOrderByRankAsc("kleague");

//        // Entity To DTO
    Function<League, LeagueDTO> fn = (entity -> entityToDto(entity));

    List<LeagueDTO> leagueDTO = leagueTable.stream().map(fn).collect(Collectors.toList());

    return leagueDTO;
  }

  // cId로 구단 탐색
  @Override
  public ClubDTO getClubBycId(int cId) {
    // Entity로 리턴 받음
    Club clubEntity = clubRepository.findBycId(cId);

    // entity to dto
//    Function<Club, ClubDTO> fn = (entity -> entityToDto(entity));
    ClubDTO clubResult = entityToDto(clubEntity);
    return clubResult;
  }

  // 리그 최다 골 순위
  @Override
  public List<PlayerRecordDTO> getLeagueTopGoal() {
    // entity 탐색
    List<PlayerRecord> prGoal = playerRecordRepository.findByTotalGoalIsNotNull();

    // entity to dto
    Function<PlayerRecord, PlayerRecordDTO> fn = (entity -> entityToDto(entity));
    List<PlayerRecordDTO> prGoalDTO = prGoal.stream().map(fn).collect(Collectors.toList());
    return prGoalDTO;
  }

  // 리그 최다 도움 순위
  @Override
  public List<PlayerRecordDTO> getLeagueTopAssist() {
    // entity 탐색
    List<PlayerRecord> prAssist = playerRecordRepository.findByAssistIsNotNull();

    // entity to dto
    Function<PlayerRecord, PlayerRecordDTO> fn = (entity -> entityToDto(entity));
    List<PlayerRecordDTO> prAssistDTO = prAssist.stream().map(fn).collect(Collectors.toList());
    return prAssistDTO;
  }

  // 리그 최다 공격포인트 순위
  @Override
  public List<PlayerRecordDTO> getLeagueTopAp() {
    // entity 탐색
    List<PlayerRecord> prAp = playerRecordRepository.findByPlayedIsNotNull();

    // entity to dto
    Function<PlayerRecord, PlayerRecordDTO> fn = (entity -> entityToDto(entity));
    List<PlayerRecordDTO> prApDTO = prAp.stream().map(fn).collect(Collectors.toList());
    return prApDTO;
  }
}
