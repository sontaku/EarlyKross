package com.ek.earlykross.controller;

import com.ek.earlykross.entity.ClubBoard;
import com.ek.earlykross.repository.ClubBoardRepository;
import com.ek.earlykross.repository.MemoRepository;
import com.ek.earlykross.security.dto.AuthMemberDTO;
import com.ek.earlykross.service.SampleService;
import com.ek.earlykross.vo.MemoDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.SampleVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("sample")
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
public class SampleController {

    private final SampleService service;

    @PreAuthorize("permitAll()")
    @GetMapping("all")
    public void exAll(){//로그인 하지 않아도 접근
        log.info("exAll....");
    }

    @GetMapping("member")
    public void exMember(@AuthenticationPrincipal AuthMemberDTO authMemberDTO){//멤버만 접근
        System.out.println("hello");
        log.info("exMember....");
        log.info("-----------------");
        log.info(authMemberDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("admin")
    public void exAdmin(){//관리자만 접근
        log.info("exAdmin....");
    }

    @PreAuthorize("#authMember != null && #authMember.username eq \"a@a\"")
    @GetMapping("exOnly")
    public String exMemberOnly(@AuthenticationPrincipal AuthMemberDTO authMember){
        log.info("member only : " + authMember);

        return "/sample/admin";
    }

    @GetMapping("/")
    public String index(){
        System.out.println("리다이렉트");
        return "redirect:/sample/ex_read.do";
    }


    @Autowired
    ClubBoardRepository clubBoardRepository;

    @Autowired
    MemoRepository memoRepository;

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
//        List<SampleVO> list = IntStream.rangeClosed(1,20).asLongStream().mapToObj(i -> {
//            SampleVO vo = SampleVO.builder()
//                    .sno(i)
//                    .first("First.."+i)
//                    .last("Last.." +i)
//                    .regTime(LocalDateTime.now())
//                    .build();
//            return vo;
//        }).collect(Collectors.toList());
//
//        m.addAttribute("list",list);
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

    @GetMapping({"ex_read.do"})
    public void ex_read(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list-------------------------------" + pageRequestDTO);

        model.addAttribute("result", service.getList(pageRequestDTO));
    }

    // 겟 방식만 들어옴
    @GetMapping("ex_create.do")
    public void ex_create(){
        log.info("write 하는 중");
    }

    // 포스트 방식만 들어옴
    @PostMapping("ex_create.do")
    public String registerPost(MemoDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto..." + dto);

        //새로 추가된 엔티티의 번호
        Long mno = service.register(dto);


        // 모델이 아닌 리다이렉트로 브라우저에 데이터를 한 번만 전달
        redirectAttributes.addFlashAttribute("msg",mno);

        return "redirect:/sample/ex_read.do";
    }

    @GetMapping({"ex_detail.do", "ex_modify.do"}) // 나중에 다시 목록으로 돌아가는 데이터 같이 저장하기 위해 requestDTO 사용
    public void detail(long mno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        log.info("mno : " + mno);
        MemoDTO dto = service.read(mno);
        model.addAttribute("dto",dto);
    }

    @PostMapping("ex_remove.do")
    public String remove(long mno, RedirectAttributes redirectAttributes){

        log.info("mno : " + mno);

        service.remove(mno);

        redirectAttributes.addFlashAttribute("msg",mno);

        return "redirect:/sample/ex_read.do";
    }

    @PostMapping("ex_modify.do")
    public String modfiy(MemoDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes redirectAttributes){

        log.info("post modify.do.....");
        log.info("dto : "+dto);

        service.modify(dto);

        redirectAttributes.addAttribute("page",requestDTO.getPage());
        redirectAttributes.addAttribute("type",requestDTO.getType());
        redirectAttributes.addAttribute("mno",requestDTO.getKeyword());
        redirectAttributes.addAttribute("mno",dto.getMno());

        return "redirect:/sample/ex_detail.do";
    }

}
