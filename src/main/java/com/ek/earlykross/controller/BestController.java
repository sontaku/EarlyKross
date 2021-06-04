package com.ek.earlykross.controller;

import com.ek.earlykross.entity.Player;
import com.ek.earlykross.repository.BestRepository;
import com.ek.earlykross.service.BestService;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.PlayerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void ex1(Model model) {
        log.info("bestController");
        System.out.println("bestController");
//        log.info("ex1.........");
//        System.out.println("sample 의 ex1");
//
//        Pageable pageable = PageRequest.of(0, 10);
//
//        Page<ClubBoard> result = clubBoardRepository.findAll(pageable);
//
//        System.out.println(result);
//
//        System.out.println("======================================");
//
//        System.out.println("총 페이지 수: " + result.getTotalPages()); // 10 페이지
//        System.out.println("전체 데이터 수: " + result.getTotalElements()); // 99개
//        System.out.println("현재 페이지 번호 ( 0부터 시작 ): " + result.getNumber()); // 0
//        System.out.println("페이지 당 데이터 수: " + result.getSize()); // 10개
//        System.out.println("다음 페이지 존재 여부: " + result.hasNext()); // true
//        System.out.println("시작페이지 여부: " + result.isFirst()); // true
//
//        System.out.println("=======================================");
//
//        // getContent 로 VO를 배열로 받거나, Stream<VO> 반환
//        for (ClubBoard clubBoard : result.getContent()) {
//            System.out.println(clubBoard);
//        }
//        model.addAttribute("list", result.getContent());
    }

    @PostMapping("searchPlayer.do")
    @ResponseBody
    public List<PlayerDTO> search(PageRequestDTO requestDTO){
        System.out.println(requestDTO.getKeyword());
        PageResultDTO<PlayerDTO, Player> dto = service.serach(requestDTO);
//        System.out.println(dto.getDtoList().get());
        return dto.getDtoList();
    }

}