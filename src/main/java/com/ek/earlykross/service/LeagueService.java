package com.ek.earlykross.service;

import com.ek.earlykross.entity.League;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.vo.LeagueDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.PlayerDTO;
import java.util.List;

public interface LeagueService {
  // 리그 순위 테이블
  List<LeagueDTO> getList();
}
