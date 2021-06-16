package com.ek.earlykross.controller;

import com.ek.earlykross.security.service.MemberDetailService;
import com.ek.earlykross.service.BestService;
import com.ek.earlykross.service.impl.PlayerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
@RequestMapping("admin")
public class AdminController {

  private final MemberDetailService mdService;
  private final PlayerServiceImpl plService;

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

  //회원 Best_11 맞춘 회원 조회
  @GetMapping("/userBesteleven.do")
  public void userBesteleven() {

  }

  //이용자 수 페이지
  @GetMapping("/userNumber.do")
  public void userNumber() {

  }

  //News 조회
  @GetMapping("/adminNews.do")
  public void adminNews() {

  }

  //문자 중계 조회
  @GetMapping("/adminTextrelay.do")
  public void adminTextrelay() {

  }

  //통합 차트
  @GetMapping("/adminAllChart.do")
  public void adminAllChart() {

  }

  //모든 선수 정보
  @GetMapping("/adminPlayer.do")
  public void adminPlayer(Model model) {
    model.addAttribute("pList", plService.getAllPlayer());
  }
}
