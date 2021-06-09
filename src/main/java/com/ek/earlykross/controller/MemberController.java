package com.ek.earlykross.controller;

import com.ek.earlykross.security.dto.AuthMemberDTO;
import com.ek.earlykross.security.service.MemberDetailService;
import com.ek.earlykross.vo.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
public class MemberController {

  private final MemberDetailService service;

  @PostMapping("signup")
  public String signup(MemberDTO memberDTO) {
    service.signup(memberDTO);

    return "/member/loginForm";
  }

  @PostMapping("/check")
  @ResponseBody
  public String check(String email){
    System.out.println(email);

    Boolean b = service.check(email);

    return b ?"사용가능합니다":"중복입니다";
  }

}
