package com.ek.earlykross.controller;

import com.ek.earlykross.entity.BestEleven;
import com.ek.earlykross.entity.Map;
import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.repository.BestRepository;
import com.ek.earlykross.repository.MemberRepository;
import com.ek.earlykross.security.dto.AuthMemberDTO;
import com.ek.earlykross.security.service.MemberDetailService;
import com.ek.earlykross.service.BestService;
import com.ek.earlykross.service.MapService;
import com.ek.earlykross.vo.BestElevenDTO;
import com.ek.earlykross.vo.MapDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.PlayerDTO;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("map")
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
public class MapController {
    private final MapService mapService;

    private final MemberRepository memberRepository; // 반드시 파이널


    @GetMapping("main.do")
    public void mainPage(){

    }
    @GetMapping("create.do")
    public void createRoom(){

    }

    @PostMapping("create.do")
    public String saveRoom(MapDTO mapDTO, @AuthenticationPrincipal AuthMemberDTO memberDTO){
        Member member = memberRepository.findMemberByEmail(memberDTO.getUsername());
        mapDTO.setHost(member);

        mapService.save(mapDTO);

        return "redirect:/map/main.do";
    }

    @RequestMapping("readmarker.do")
    @ResponseBody
    public List<Map> readMarkder(){

        return mapService.getAll();
    }

}