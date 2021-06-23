package com.ek.earlykross.controller;

import com.ek.earlykross.repository.LeagueRepository;
import com.ek.earlykross.service.DataCenterService;
import com.ek.earlykross.vo.PlayerDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
public class CommonController {

  private final DataCenterService service;

  @GetMapping("/{step}")
  public void index(Model model) {
    model.addAttribute("clubList", service.getLeagueTable());
  }
}