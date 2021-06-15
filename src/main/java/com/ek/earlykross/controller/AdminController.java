package com.ek.earlykross.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

  //이번엔 .do를 사용한다고 했다.
  //회원 페이지 이동
  @GetMapping("/admin.do")
  public void AdminPage(){

  }

  //회원 전체 조회하기
  @GetMapping("/userInquiry.do")
  public void userInquiry(){

  }

  //회원 블랙 리스트 조회하기
  @GetMapping("/userBlacklist.do")
  public void userBlacklist(){

  }

  //회원 Best_11 맞춘 회원 조회
  @GetMapping("/userBesteleven.do")
  public void userBesteleven(){

  }

  //회원 포인트 조회
  @GetMapping("/userPoint.do")
  public void userPoint(){

  }

  //이용자 수 페이지
  @GetMapping("/userNumber.do")
  public void userNumber(){

  }
}
