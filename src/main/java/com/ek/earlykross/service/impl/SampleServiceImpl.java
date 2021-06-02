package com.ek.earlykross.service.impl;

import com.ek.earlykross.entity.Memo;
import com.ek.earlykross.entity.QMemo;
import com.ek.earlykross.repository.MemoRepository;
import com.ek.earlykross.service.SampleService;
import com.ek.earlykross.vo.MemoDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

// Bean 처리
@Service
@Log4j2
// 의존성 자동 주입
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {

    private final MemoRepository repository; // 반드시 파이널

    @Override
    public Long register(MemoDTO dto) {

        log.info("DTO---------------------------");
        log.info(dto);

        Memo entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);

        return entity.getMno();
    }

    @Override
    public PageResultDTO<MemoDTO, Memo> getList(PageRequestDTO requestDTO){
        // 요청한 DTO 를 페이징
        Pageable pageable = requestDTO.getPageable(Sort.by("mno").descending());

        // 검색 조건 탐색
        BooleanBuilder booleanBuilder = getSearch(requestDTO);

        // JPA 로 DB 탐색, Querydsl 사용
        Page<Memo> result = repository.findAll(booleanBuilder, pageable);

        // 엔티티를 DTO 로 변환
        Function<Memo, MemoDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public MemoDTO read(Long mno) { // PK 자료형
        Optional<Memo> result = repository.findById(mno);
        // JPA 에서 엔티티 객체를 가져왔다면 DTO로 반환해서 리턴
        return result.isPresent() ? entityToDto(result.get()):null;
    }

    @Override
    public void remove(Long mno) {

        repository.deleteById(mno);
    }

    @Override
    public void modify(MemoDTO dto) {
        Optional<Memo> result = repository.findById(dto.getMno());

        if(result.isPresent()){
            Memo entity = result.get();

            entity.changeMemoText(dto.getMemoText());

            repository.save(entity);
        }
    }


    // Querydsl 처리
    private BooleanBuilder getSearch(PageRequestDTO requestDTO){

        String type = requestDTO.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QMemo qMemo = QMemo.memo;

        String keyword = requestDTO.getKeyword();

        // 기본 검색 규칙
        BooleanExpression expression = qMemo.mno.gt(0L);

        booleanBuilder.and(expression);

        // 검색을 하지 않으면
        if(type == null || type.trim().length()==0){
            return booleanBuilder;
        }

        // 검색 조건 작성
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(type.contains("t")){
            conditionBuilder.or((qMemo.memoText.contains(keyword)));
        }
        // 위의 검색조건을 타입을 변경하며 여러개 작성 가능

        //위의 모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }
}
