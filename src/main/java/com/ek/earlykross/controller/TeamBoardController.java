package com.ek.earlykross.controller;

import com.ek.earlykross.entity.ClubBoard;
import com.ek.earlykross.repository.ClubBoardRepository;
import com.ek.earlykross.repository.MemoRepository;
import com.ek.earlykross.security.dto.AuthMemberDTO;
import com.ek.earlykross.service.SampleService;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("teamboard")
@Log4j2
@RequiredArgsConstructor // 자동 주입 어노테이션
public class TeamBoardController {

    @GetMapping("mainBoard")
    public void MainBoard(){

    }
}
