package com.ek.earlykross.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("member")
public class UserController {

  @GetMapping("/loginForm")
  public String joinForm(){

    return null;
  }

  @RequestMapping("/backend_url")
  @ResponseBody
  public String saveUser(String user, boolean withCredentials){
    System.out.println("로그인 요청");
    // 유저 데이터를 DB 저장


    return "내가 뷰로 보내는 데이터";
  }
}
