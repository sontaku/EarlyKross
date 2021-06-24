package com.ek.earlykross.controller;

import com.ek.earlykross.entity.Fixture;
import com.ek.earlykross.entity.Relay;
import com.ek.earlykross.repository.FixtureRepository;
import com.ek.earlykross.repository.RelayRepository;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

  @Autowired
  FixtureRepository fixtureRepository;

  @Autowired
  RelayRepository relayRepository;

  @GetMapping("/chat.do")
  public void chat(Model model, HttpServletRequest request) {
    String fId = request.getParameter("fId");

    Optional<Fixture> result = fixtureRepository.findById(Long.parseLong(fId));

    Fixture fixture = result.get();

    List<Relay> list = relayRepository.findByfId(Long.parseLong(fId));


    model.addAttribute("result", fixture);
    model.addAttribute("list", list);
  }
}
