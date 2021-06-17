package com.ek.earlykross.controller;

import com.ek.earlykross.entity.BestEleven;
import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.repository.BestRepository;
import com.ek.earlykross.security.dto.AuthMemberDTO;
import com.ek.earlykross.security.service.MemberDetailService;
import com.ek.earlykross.service.BestService;
import com.ek.earlykross.vo.BestElevenDTO;
import com.ek.earlykross.vo.MemberDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.PlayerDTO;
import java.util.ArrayList;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("best11")
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
public class BestController {

    private final BestService service;
    private final MemberDetailService memberservice;
//
//    @GetMapping("/")
//    public String index(){
//        System.out.println("리다이렉트");
//        return "redirect:/datacenter/team_overview.do";
//    }

    @Autowired
    BestRepository bestRepository;

//    @GetMapping("{step}.do")
//    public String viewPage(@PathVariable String step) {
//        System.out.println("main에서 자신 반환하는 모든 동작 : " + step);
//        return "sample/" + step;
//    }

    @GetMapping({"best.do"})
    public void ex1(Model model, @AuthenticationPrincipal AuthMemberDTO memberDTO) {
        log.info("bestController");
        System.out.println("bestController");
        Optional<BestEleven> bestEleven = bestRepository.findBestElevenBymIdAndRoundAndSeason(service.findBestByEmail(memberDTO.getUsername()),20,"2021");

//        System.out.println(bestEleven.get().getFormationText());

        String formation = "";
        if(bestEleven.isPresent()){
            formation = bestEleven.get().getFormationText();
        }
        //고쳐라 제와피
        model.addAttribute("formation", formation);
    }

//    @PostMapping("formation.do")
//    @ResponseBody
//    public String formation(){
//
//        return bestEleven.isPresent()?bestEleven.get().getFormationText():null;
//    }

    @PostMapping("searchPlayer.do")
    @ResponseBody
    public List<PlayerDTO> search(PageRequestDTO requestDTO){
        System.out.println(requestDTO.getKeyword());
        PageResultDTO<PlayerDTO, Player> dto = service.serach(requestDTO);
//        System.out.println(dto.getDtoList().get());
        return dto.getDtoList();
    }
    @PostMapping("savePlayer.do")
    @ResponseBody
    public String save(String players, String formationText, @AuthenticationPrincipal AuthMemberDTO memberDTO) {
        System.out.println(memberDTO.getUsername());
        String[] arr = players.split("]");
        List<Player> mIdArr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String[] player = arr[i].split("\\[");
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setName(player[0]);
            playerDTO.setPosition(player[1]);
            mIdArr.add(service.selectPidByPlayer(playerDTO));// 20210274
        }
        for(Player p : mIdArr){
            System.out.println(p);
        }

        BestElevenDTO bestElevenDTO = new BestElevenDTO();
        bestElevenDTO.setRound(20);
        bestElevenDTO.setSeason("2021");
        bestElevenDTO.setFormationText(formationText);
        bestElevenDTO.setFormation(formationText.substring(1,3));
        bestElevenDTO.setP1(mIdArr.get(0));
        bestElevenDTO.setP2(mIdArr.get(1));
        bestElevenDTO.setP3(mIdArr.get(2));
        bestElevenDTO.setP4(mIdArr.get(3));
        bestElevenDTO.setP5(mIdArr.get(4));
        bestElevenDTO.setP6(mIdArr.get(5));
        bestElevenDTO.setP7(mIdArr.get(6));
        bestElevenDTO.setP8(mIdArr.get(7));
        bestElevenDTO.setP9(mIdArr.get(8));
        bestElevenDTO.setP10(mIdArr.get(9));
        bestElevenDTO.setP11(mIdArr.get(10));
        bestElevenDTO.setMId(service.findBestByEmail(memberDTO.getUsername()));
        service.save(bestElevenDTO);

        System.out.println(formationText);
        return "성공";
    }

}