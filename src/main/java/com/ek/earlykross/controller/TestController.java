package com.ek.earlykross.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 별도의 화면없이 데이터 전송
@RestController
public class TestController {

  // 브라우저의 주소창에서 호출 가능
  @GetMapping("/hello")
  public String[] hello() {
    return new String[]{"Hello", "World"};
  }
}
