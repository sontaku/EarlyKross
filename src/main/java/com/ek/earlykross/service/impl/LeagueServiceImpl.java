package com.ek.earlykross.service.impl;

import com.ek.earlykross.entity.League;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.repository.LeagueRepository;
import com.ek.earlykross.service.LeagueService;
import com.ek.earlykross.vo.LeagueDTO;
import com.ek.earlykross.vo.PlayerDTO;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class LeagueServiceImpl implements LeagueService {


  private final LeagueRepository leagueRepository;

  //모든 리그 관리
  @Override
  public List<LeagueDTO> getAllLeague() {
    List<League> result = leagueRepository.findAll();

    Function<League, LeagueDTO> fn = (entity -> entityToDto(entity));
    List<LeagueDTO> LeagueDTOList = result.stream().map(fn).collect(Collectors.toList());
    return LeagueDTOList;
  }

  //League entity to DTO
  LeagueDTO entityToDto(League entity){
    LeagueDTO dto = LeagueDTO.builder()
        .cId(entity.getCId())
        .season(entity.getSeason())
        .played(entity.getPlayed())
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
