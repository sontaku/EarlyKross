package com.ek.earlykross.service;

import com.ek.earlykross.entity.Memo;
import com.ek.earlykross.repository.MemoRepository;
import com.ek.earlykross.vo.MemoDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
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

        // JPA 로 DB 탐색
        Page<Memo> result = repository.findAll(pageable);

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
}
