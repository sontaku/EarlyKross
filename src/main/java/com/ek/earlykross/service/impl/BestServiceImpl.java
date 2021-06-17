package com.ek.earlykross.service.impl;

import com.ek.earlykross.entity.BestEleven;
import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.entity.QPlayer;
import com.ek.earlykross.repository.BestRepository;
import com.ek.earlykross.repository.MemberRepository;
import com.ek.earlykross.repository.PlayerRepository;
import com.ek.earlykross.service.BestService;
import com.ek.earlykross.vo.BestElevenDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.PlayerDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

// Bean 처리
@Service
@Log4j2
// 의존성 자동 주입
@RequiredArgsConstructor
public class BestServiceImpl implements BestService {

    private final PlayerRepository repository; // 반드시 파이널
    private final BestRepository bestRepository; // 반드시 파이널
    private final MemberRepository memberRepository; // 반드시 파이널

    @Override
    public PageResultDTO<PlayerDTO, Player> serach(PageRequestDTO requestDTO) {

//        요청한 DTO 를 페이징
        Pageable pageable = requestDTO.getPageable(Sort.by("pId").descending());

        // 검색 조건 탐색
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
//
//        // JPA 로 DB 탐색, Querydsl 사용
        Page<Player> result = repository.findAll(booleanBuilder, pageable);
//
//
//        // 엔티티를 DTO 로 변환
        Function<Player, PlayerDTO> fn = (entity -> entityToDto(entity));
//
        return new PageResultDTO<>(result, fn);
//        return null;
    }

    @Override
    public Player selectPidByPlayer(PlayerDTO playerDTO) {
        Player player = dtoToEntity(playerDTO);
        Player result = repository.findPlayerByNameEqualsAndPositionEquals(player.getName(),player.getPosition());

        return result;
//        return result.isPresent() ? entityToDto(result.get()):null;
    }

    @Override
    public Member findBestByEmail(String username) {
        Member member = memberRepository.findMemberByEmail(username);
//        member.ifPresent(value -> System.out.println(value.getEmail()));

        return member;
    }

    @Override
    public boolean findBest(String username) {
        Optional<BestEleven> bestEleven = bestRepository.findBestElevenBymIdAndRoundAndSeason(findBestByEmail(username),20,"2021");
        bestEleven.ifPresent(eleven -> System.out.println(eleven.getFormationText()));
        ;
        return bestEleven.isEmpty();
    }

    @Override
    public void save(BestElevenDTO bestElevenDTO) {
        BestEleven bestEleven = dtoToEntity(bestElevenDTO);
        System.out.println("===========================");
        System.out.println(bestEleven.getFormationText());

        bestRepository.save(bestEleven);
    }

    // Querydsl 처리
    private BooleanBuilder getSearch(PageRequestDTO requestDTO){

        BooleanBuilder booleanBuilder = new BooleanBuilder();

//        QMemo qMemo = QMemo.memo;

        QPlayer qPlayer = QPlayer.player;
        String keyword = requestDTO.getKeyword();

        // 기본 검색 규칙
        BooleanExpression expression = qPlayer.pId.gt(0L);

        booleanBuilder.and(expression);

        // 검색 조건 작성
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        conditionBuilder.or((qPlayer.name.contains(keyword)));
        // 위의 검색조건을 타입을 변경하며 여러개 작성 가능

        //위의 모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }



}
