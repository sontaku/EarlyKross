package com.ek.earlykross.service;

import com.ek.earlykross.entity.League;
import com.ek.earlykross.entity.LeaguePK;
import com.ek.earlykross.entity.Memo;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.vo.LeagueDTO;
import com.ek.earlykross.vo.MemoDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.PlayerDTO;
import java.util.List;

public interface LeagueService {
  // 리그 순위 테이블
  List<LeagueDTO> getList();

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
}
