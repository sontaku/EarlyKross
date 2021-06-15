package com.ek.earlykross.controller;

import com.ek.earlykross.repository.ClubNewsRepository;
import com.ek.earlykross.service.ClubNewsService;
import com.ek.earlykross.vo.PageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

@Log4j2
@RequiredArgsConstructor
public class MainController {

    private final ClubNewsService clubNewsService;

    @Autowired
    ClubNewsRepository clubNewsRepository;

    @RequestMapping("/")
    public String index(Model model) {
        log.info("Main....");
        PageRequestDTO pageRequestDTO = new PageRequestDTO(1,4);
        model.addAttribute("result", clubNewsService.getList(pageRequestDTO));

        return "index.html";
    }

//    @RequestMapping("/")
//    public void list(PageRequestDTO pageRequestDTO, Model model) {
//        log.info("list........news");
//
//    }


}
