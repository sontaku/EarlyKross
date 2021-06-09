package com.ek.earlykross.service.impl;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.League;
import com.ek.earlykross.repository.ClubRepository;
import com.ek.earlykross.repository.LeagueRepository;
import com.ek.earlykross.service.DataCenterService;
import com.ek.earlykross.vo.ClubDTO;
import com.ek.earlykross.vo.LeagueDTO;
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
    Club clubEntity =  clubRepository.findBycId(cId);

    // entity to dto
//    Function<Club, ClubDTO> fn = (entity -> entityToDto(entity));
    ClubDTO clubResult = entityToDto(clubEntity);
    return clubResult;
  }

  // 클럽 목록
//  @Override
//  public List<ClubDTO> getClubList() {
//    // JPA 로 DB 탐색
//    List<Club> clubList = clubRepository.getClubList();
//
//    // Entity To DTO
//    Function<Club, ClubDTO> fn = (entity -> entityToDto(entity));
//    List<ClubDTO> clubDTO = clubList.stream().map(fn).collect(Collectors.toList());
//    return clubDTO;
//  }

}
