package com.ek.earlykross.controller;

import com.ek.earlykross.repository.ClubRepository;
import com.ek.earlykross.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("league")
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
public class LeagueController {

  @Autowired
  LeagueRepository leagueRepository;

  @GetMapping({"/overview.do"})
  public String teamOverview(Model model) {
    log.info("ClubController.team_overview 호출");
    return "/datacenter/league_overview.do";
  }
}
