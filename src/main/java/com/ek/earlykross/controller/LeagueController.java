package com.ek.earlykross.controller;

import com.ek.earlykross.service.LeagueService;
import com.ek.earlykross.vo.LeagueDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("league")
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
public class LeagueController {

  private final LeagueService service;
  //
//  @Autowired
//  LeagueRepository leagueRepository;




  @GetMapping({"/rank.do"})
  public List<LeagueDTO> rank(Model model) {
    log.info("ClubController.rank호출");
    return service.getList();

//    return "/datacenter/league_overview.do";
  }
}
