package com.ek.earlykross.controller;

import com.ek.earlykross.repository.KakaoRepository;
import com.ek.earlykross.service.KakaoService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("member")
//@RequestMapping("")
public class UserController {

//  @Autowired
//  KakaoRepository kakaoRepository;


//  @RequestMapping("/loginForm")
//  public void joinForm(){
//  }

  @PostMapping("/backend_url")
  @ResponseBody
  public String KakaoSave(String user, boolean withCredentials){
    System.out.println(user);

    return "내가 뷰로 보내는 데이터";
  }
}
