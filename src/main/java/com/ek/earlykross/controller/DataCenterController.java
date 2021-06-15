package com.ek.earlykross.controller;

import com.ek.earlykross.repository.LeagueRepository;
import com.ek.earlykross.service.DataCenterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("datacenter")
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
public class DataCenterController {

  //    private final DataCenterService service;
  private final DataCenterService service;

  @GetMapping("/")
  public String index() {
    System.out.println("리다이렉트");
    return "redirect:/datacenter/league_overview.do";
  }

  @Autowired
  LeagueRepository leagueRepository;




  // == 리그 =====================================================
  // 리그 정보 페이지
  @GetMapping({"/league.do"})
  public void leagueOverview(Model model) {
    log.info("DataCenterController.leagueOverview 호출");

    // 리그순위
    model.addAttribute("leagueRankList", service.getLeagueTable());

    // 선수 개인 시즌 기록
    // 시즌 선수 기록
  }




  // =============================================================

  // == 클럽 =====================================================
  // 클럽 목록
  @GetMapping({"/club.do"})
  public void clubOverview(Model model, String cId) {
    log.info("DataCenterController.ClubOverview 호출");


    // 클럽 목록
//    model.addAttribute("clubList", service.getClubList());
    model.addAttribute("clubList", service.getLeagueTable());

    // 특정 클럽
    if(cId == null) {
      cId = "1";
    }
    log.info("구단 페이지 :: 구단번호 : " + cId);
    
    // cId로 구단 탐색
    model.addAttribute("oneClub", service.getClubBycId(Integer.parseInt(cId)));
    

    // 구단 로고(클럽 목록 받음)
//    model.addAttribute("cId", cId);

    // repository


//        return "redirect:/club/overview.do";
  }
  // 클럽 로고 목록(a태그 경로)
  // 얼크위키
  // 팀내 최다 득점자
  // 스쿼드(라인업)
  // 경기 일정
  // 승점 변화(그래프) or 순위 변화 - 타클럽과 비교

  // =============================================================

  // == 선수 =====================================================

  // =============================================================
}