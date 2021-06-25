package com.ek.earlykross.controller;

import com.ek.earlykross.repository.ClubNewsRepository;
import com.ek.earlykross.service.ClubNewsService;
import com.ek.earlykross.vo.PageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("news")
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
public class NewsController {

  private final ClubNewsService service;

  @GetMapping("/")
  public String index() {
    System.out.println("리다이렉트");
    return "redirect:/news/soccer_news.do";
  }

  @Autowired
  ClubNewsRepository clubNewsRepository;

  @GetMapping({"/soccer_news.do"})
  public void list(PageRequestDTO pageRequestDTO, Model model) {
    pageRequestDTO.setSize(30);
    log.info("list........news");
    model.addAttribute("result", service.getList(pageRequestDTO));
  }
}