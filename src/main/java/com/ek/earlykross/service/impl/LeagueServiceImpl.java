package com.ek.earlykross.service.impl;

import com.ek.earlykross.entity.League;
import com.ek.earlykross.entity.Memo;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.entity.QPlayer;
import com.ek.earlykross.repository.BestRepository;
import com.ek.earlykross.repository.LeagueRepository;
import com.ek.earlykross.service.BestService;
import com.ek.earlykross.service.LeagueService;
import com.ek.earlykross.vo.LeagueDTO;
import com.ek.earlykross.vo.MemoDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.PlayerDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

// Bean 처리
@Service
@Log4j2
// 의존성 자동 주입
@RequiredArgsConstructor
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository repository; // 반드시 파이널

    // 리그 순위
    @Override
    public List<LeagueDTO> getList() {
        // JPA 로 DB 탐색
        List<League> leagueTable = repository.findAll();

//        // Entity To DTO
        Function<League, LeagueDTO> fn = (entity -> entityToDto(entity));

        List<LeagueDTO> leagueDTO = leagueTable.stream().map(fn).collect(Collectors.toList());

//        return !leagueTable.isEmpty() ? entityToDto(leagueTable):null;
        return leagueDTO;
    }

}
