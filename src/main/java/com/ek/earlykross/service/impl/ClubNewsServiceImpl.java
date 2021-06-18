package com.ek.earlykross.service.impl;

import com.ek.earlykross.entity.ClubNews;
import com.ek.earlykross.entity.QClubNews;
import com.ek.earlykross.repository.ClubNewsRepository;
import com.ek.earlykross.service.ClubNewsService;
import com.ek.earlykross.vo.ClubNewsVO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
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
public class ClubNewsServiceImpl implements ClubNewsService {

    private final ClubNewsRepository repository; // 반드시 파이널


    @Override
    public PageResultDTO<ClubNewsVO, ClubNews> getList(PageRequestDTO requestDTO) {
        System.out.println("getList 호출");
        Pageable pageable = requestDTO.getPageable(Sort.by("nId").ascending());

        // 검색 조건 탐색
        BooleanBuilder booleanBuilder = getSearch(requestDTO);

        // PA 로 DB 탐색, Querydsl 사용
        Page<ClubNews> result = repository.findAll(booleanBuilder, pageable);

        Function<ClubNews, ClubNewsVO> fn = entity -> entityToDto(entity);

        return new PageResultDTO<>(result, fn);
    }

//    @Override
//    public List<ClubNewsVO> getList() {
//        // 요청한 DTO 를 페이징
//
//        List<ClubNews> result = repository.findAll();
//        // 엔티티를 DTO 로 변환
//        Function<ClubNews, ClubNewsVO> fn = (entity -> entityToDto(entity));
//
//        return result.stream().map(fn).collect(Collectors.toList());
////    return new PageResultDTO<>(result, fn);
//    }


    @Override
    public ClubNewsVO read(Long nId) { // PK 자료형
        Optional<ClubNews> result = repository.findById(nId);
        // JPA 에서 엔티티 객체를 가져왔다면 DTO로 반환해서 리턴
        return result.isPresent() ? entityToDto(result.get()) : null;
    }

    // Querydsl 처리
    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {

        String type = requestDTO.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
//
        QClubNews qClubNews = QClubNews.clubNews;
//
        String keyword = requestDTO.getKeyword();

        // 기본 검색 규칙

        BooleanExpression expression = qClubNews.nId.gt(0L);

        booleanBuilder.and(expression);

        // 검색을 하지 않으면
        if (type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }

        // 검색 조건 작성
        BooleanBuilder conditionBuilder = new BooleanBuilder();

//        if (type.contains("t")) {
//            conditionBuilder.or(qClubNews());
//        }
        // 위의 검색조건을 타입을 변경하며 여러개 작성 가능

        //위의 모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }


    //모든 뉴스 소식 가져오기
    public List<ClubNewsVO> getAllNews(){
        List<ClubNews> result = repository.findAll();
        //entity to dto
        Function<ClubNews, ClubNewsVO> fn = (entity -> entityToDto(entity));
        List<ClubNewsVO> newsAllList = result.stream().map(fn).collect(Collectors.toList());
        return newsAllList;
    }
}
