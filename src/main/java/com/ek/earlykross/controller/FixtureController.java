package com.ek.earlykross.controller;

import com.ek.earlykross.entity.Fixture;
import com.ek.earlykross.repository.FixtureRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fixture")
public class FixtureController {

  @Autowired
  FixtureRepository fixtureRepository;

  @GetMapping("/fixture.do")
  public void fixture(Model model) {

    List<Fixture> fixtures = fixtureRepository.findAll();
    model.addAttribute("fixtures", fixtures);
  }
}
