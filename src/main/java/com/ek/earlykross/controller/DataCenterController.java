package com.ek.earlykross.controller;

import com.ek.earlykross.repository.ClubRepository;
import com.ek.earlykross.service.DataCenterService;
import com.ek.earlykross.vo.MemoDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.SampleVO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping("datacenter")
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
public class DataCenterController {

//    private final DataCenterService service;

    @GetMapping("/")
    public String index(){
        System.out.println("리다이렉트");
        return "redirect:/datacenter/league_overview.do";
    }

    @Autowired
    ClubRepository clubRepository;

//    @GetMapping("{step}.do")
//    public String viewPage(@PathVariable String step) {
//        System.out.println("main에서 자신 반환하는 모든 동작 : " + step);
//        return "sample/" + step;
//    }

    // 리그 정보 페이지
    @GetMapping({"/league_overview.do"})
    public void leagueOverview(Model model) {
        log.info("dcController.league_overview 호출");
    }

    //
    @GetMapping({"/team_overview.do"})
    public void teamOverview(Model model) {
        log.info("dcController.team_overview 호출");
    }
}