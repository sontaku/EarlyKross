package com.ek.earlykross.controller;

import com.ek.earlykross.security.service.MemberDetailService;
import com.ek.earlykross.service.impl.AdminServiceImpl;
import com.ek.earlykross.service.impl.ClubNewsServiceImpl;
import com.ek.earlykross.service.impl.FixtureServiceImpl;
import com.ek.earlykross.service.impl.LeagueServiceImpl;
import com.ek.earlykross.service.impl.MapServiceImpl;
import com.ek.earlykross.service.impl.PlayerServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
@RequestMapping("admin")
public class AdminController {

  private final MemberDetailService mdService;
  private final PlayerServiceImpl plService;
  private final ClubNewsServiceImpl newsList;
  private final LeagueServiceImpl LeagueList;
  private final FixtureServiceImpl FixList;
  private final AdminServiceImpl adminService;
  private final MapServiceImpl mapServiceImpl;

  //이번엔 .do를 사용한다고 했다.
  //회원 페이지 이동
  @GetMapping("/admin.do")
  public void AdminPage() {

  }

  //회원 전체 조회하기
  // 관리자 페이지 회원조회
  @GetMapping("/userInquiry.do")
  public void userInquiry(Model model) {
    model.addAttribute("mList", mdService.getMemberList());
  }

  //이용자 수 페이지
  @GetMapping("/userNumber.do")
  public void userNumber() {

  }

  //문자 중계 조회
  @GetMapping("/adminTextrelay.do")
  public void adminTextrelay() {

  }

  @PostMapping("GetCountPosition.do")
  @ResponseBody
  public List<Integer> getCountPosition(){
//    List<Integer> position = new ArrayList<>();
//    position.add(plService.countPosition("FW"));
//    position.add(plService.countPosition("MF"));
//    position.add(plService.countPosition("DF"));
//    position.add(plService.countPosition("GK"));
//    return position;
    return null;
  }


  //통합 차트
  @GetMapping("/adminAllChart.do")
  public void adminAllChart(Model model) {
    //model.addAttribute("cntByPos",plService.countGroupByPos());
    model.addAttribute("cntByPos",plService.countGroupByPos());
    model.addAttribute("cntSocialMember",adminService.countSocialMember());
    model.addAttribute("cntTeam",mapServiceImpl.countTeam());
  }

  //News 조회
  @GetMapping("/adminNews.do")
  public void adminNews(Model model) {
    model.addAttribute("nList", newsList.getAllNews());
  }

  //모든 선수 정보
  @GetMapping("/adminPlayer.do")
  public void adminPlayer(Model model) {
    model.addAttribute("pList", plService.getAllPlayer());
  }

  //모든 리그 관리
  @GetMapping("/adminAllLeague.do")
  public void AllLeague(Model model){
    model.addAttribute("LegList",LeagueList.getAllLeague());

  }

  //모든 경기 일정 관리
  @GetMapping("/adminMatch.do")
  public void adminMatch(Model model){

//    model.addAttribute("fixList",FixList.getAllFixture());
    //이제 화면에 가서 가져오면된다.
  }

  //회원 Best_11 맞춘 회원 조회
  @GetMapping("/userBesteleven.do")
  public void userBesteleven() {

  }
}
