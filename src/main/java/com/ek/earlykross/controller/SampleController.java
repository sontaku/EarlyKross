package com.ek.earlykross.controller;

import com.ek.earlykross.entity.ClubBoard;
import com.ek.earlykross.repository.ClubBoardRepository;
import com.ek.earlykross.vo.SampleVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("sample")
@Log4j2
public class SampleController {

    @Autowired
    ClubBoardRepository clubBoardRepository;

//    @GetMapping("{step}.do")
//    public String viewPage(@PathVariable String step) {
//        System.out.println("main에서 자신 반환하는 모든 동작 : " + step);
//        return "sample/" + step;
//    }

    @GetMapping({"ex1.do"})
    public void ex1(Model model) {
        log.info("ex1.........");
        System.out.println("sample 의 ex1");

        Pageable pageable = PageRequest.of(0, 10);

        Page<ClubBoard> result = clubBoardRepository.findAll(pageable);

        System.out.println(result);

        System.out.println("======================================");

        System.out.println("총 페이지 수: " + result.getTotalPages()); // 10 페이지
        System.out.println("전체 데이터 수: " + result.getTotalElements()); // 99개
        System.out.println("현재 페이지 번호 ( 0부터 시작 ): " + result.getNumber()); // 0
        System.out.println("페이지 당 데이터 수: " + result.getSize()); // 10개
        System.out.println("다음 페이지 존재 여부: " + result.hasNext()); // true
        System.out.println("시작페이지 여부: " + result.isFirst()); // true

        System.out.println("=======================================");

        // getContent 로 VO를 배열로 받거나, Stream<VO> 반환
        for (ClubBoard clubBoard : result.getContent()) {
            System.out.println(clubBoard);
        }
        model.addAttribute("list", result.getContent());
    }

    @GetMapping({"ex2.do"})
    public void exModel(Model m) {
        List<SampleVO> list = IntStream.rangeClosed(1,20).asLongStream().mapToObj(i -> {
            SampleVO vo = SampleVO.builder()
                    .sno(i)
                    .first("First.."+i)
                    .last("Last.." +i)
                    .regTime(LocalDateTime.now())
                    .build();
            return vo;
        }).collect(Collectors.toList());

        m.addAttribute("list",list);
    }

    @GetMapping("ex3.do")
    public void ex3(Model m) {
//        String user = "id";
//        ClubBoardVO.ClubBoardVOBuilder vo = ClubBoardVO.builder().user(user);
//        m.addAttribute("user",vo);

        List<SampleVO> list = IntStream.rangeClosed(1,20).asLongStream().mapToObj(i -> {
            SampleVO vo = SampleVO.builder()
                    .sno(i)
                    .first("First.."+i)
                    .last("Last.." +i)
                    .regTime(LocalDateTime.now())
                    .build();
            return vo;
        }).collect(Collectors.toList());

        m.addAttribute("list",list);
    }

}
