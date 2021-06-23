package com.ek.earlykross.controller;

import com.ek.earlykross.entity.Club;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.repository.LeagueRepository;
import com.ek.earlykross.service.DataCenterService;
import com.ek.earlykross.vo.PlayerDTO;
import com.ek.earlykross.vo.PlayerRecordDTO;
import java.util.List;
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


//    @GetMapping("{step}.do")
//    public String viewPage(@PathVariable String step) {
//        System.out.println("main에서 자신 반환하는 모든 동작 : " + step);
//        return "sample/" + step;
//    }


  // == 리그 =====================================================
  // 리그 정보 페이지
  @GetMapping({"/league.do"})
  public void leagueOverview(Model model) {
    log.info("DataCenterController.leagueOverview 호출");

    // 리그순위
    model.addAttribute("leagueRankList", service.getLeagueTable());

    // 선수 개인 시즌 기록
    model.addAttribute("leagueTopGoal", service.getLeagueTopGoal()); // 골
    model.addAttribute("leagueTopAssist", service.getLeagueTopAssist()); // 어시
    model.addAttribute("leagueTopAp", service.getLeagueTopAp()); // 공포

    // 시즌 선수 기록
    model.addAttribute("playerSeasonRecord", service.getPlayerSeasonRecord()); // 공포
  }

  // =============================================================

  // == 클럽 =====================================================
  // 클럽 목록
  @GetMapping({"/club.do"})
  public void clubOverview(Model model, String cId) {
    log.info("DataCenterController.ClubOverview 호출");

    // 클럽 목록
    model.addAttribute("clubList", service.getLeagueTable());

    // 특정 클럽
    if (cId == null) {
      cId = "1";
    }
    log.info("구단 페이지 :: 구단번호 : " + cId);

    // cId로 구단 탐색
    model.addAttribute("oneClub", service.getClubBycId(Integer.parseInt(cId)));

    // 스쿼드(라인업)
    List<List<PlayerDTO>> dtoList = service.getPlayerByPosition(Integer.parseInt(cId));
    // 0 : FW
    // 1 : MF
    // 2 : DF
    // 3 : GK
    int tmpInt = 0;
    for(List<PlayerDTO> dto: dtoList) {
      model.addAttribute("lineup" + (tmpInt + ""), dto);
      tmpInt++;
    }
    
    // 팀 스탯
    // 시즌 게임당 골, 유효슈팅, 슈팅, 공격포인트
    String dbResult = service.getTeamStat(Integer.parseInt(cId));
//    System.out.println("결과 : " + dbResult);
    String[] tsResult = dbResult.split(",");

    model.addAttribute("gpg", tsResult[0]); // 경기당 골
    model.addAttribute("tspg", tsResult[1]); // 경기당 슈팅 수
    model.addAttribute("sopg", tsResult[2]); // 경기당 유효슈팅 수
    model.addAttribute("appg", tsResult[3]); // 경기당 공격포인트

    // 클럽 레전드 기록
    // 구단 통산 기록
//    model.addAttribute("clubHistory", service.getClubHistoryBycId(Integer.parseInt(cId)));
  }



  // 경기 일정
  // 승점 변화(그래프) or 순위 변화 - 타클럽과 비교

  // =============================================================

  // == 선수 =====================================================
  // 선수 목록
  @GetMapping({"/playerlist.do"})
  public void playerList(Model model, String cId) {
    log.info("DataCenterController.playerList 호출");

    // 특정 클럽
    if (cId == null) {
      cId = "1";
    }
    log.info("구단 페이지 :: 구단번호 : " + cId);

    // 클럽별 선수 조회
    model.addAttribute("pList", service.getPlayerBycId(cId));

    // 클럽 목록
    model.addAttribute("clubList", service.getLeagueTable());
  }

  // 선수 detail view
  @GetMapping({"/playerdetail.do"})
  public void playerDetail(Model model, String pId) {
    log.info("DataCenterController.playerDetail 호출");

    // 선수 조회(pId)
    model.addAttribute("p", service.getPlayerBypId(pId));

    // 선수 시즌 기록(pId)
    model.addAttribute("pRecord", service.getPlayerRecordBypId(pId));
  }

  // =============================================================
  // 검색
  @GetMapping({"/search.do"})
  public void search(Model model, String keyword) {
    log.info("DataCenterController.playerDetail 호출");
    log.info("검색값 : " + keyword);
    // 해당 페이지 검색창 입력값 적용
    model.addAttribute("keyword", keyword);

    log.info("클럽 검색 결과" + service.getClubByName(keyword).isEmpty());
    log.info("선수 검색 결과" + service.getPlayerByName(keyword).isEmpty());
    log.info("뉴스 검색 결과" + service.getNewsByCnameAndTitle(keyword).isEmpty());

    // 클럽 검색 결과
    model.addAttribute("clubResult", service.getClubByName(keyword));

    // 선수 검색 결과
    model.addAttribute("playerResult", service.getPlayerByName(keyword));

    // 뉴스 검색 결과
    model.addAttribute("newsResult", service.getNewsByCnameAndTitle(keyword));
  }
}