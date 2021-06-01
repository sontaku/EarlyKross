package com.ek.earlykross.service;

import com.ek.earlykross.entity.Memo;
import com.ek.earlykross.vo.MemoDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;

public interface SampleService {

    // 메모 하나 읽기
    MemoDTO read(Long mno);

    //메모 등록
    Long register(MemoDTO dto);

    // 메모 전체 읽기
    PageResultDTO<MemoDTO, Memo> getList(PageRequestDTO requestDTO);

    //메모 삭제
    void remove(Long mno);

    //메모 수정
    void modify(MemoDTO dto);


    // dto 를 entity 로 변환
    default Memo dtoToEntity(MemoDTO dto) {
        Memo entity = Memo.builder()
                .mno(dto.getMno())
                .memoText(dto.getMemoText())
                .build();
        return entity;
    }

    // entity 를 dto 로 변환
    default MemoDTO entityToDto(Memo entity) {
        MemoDTO dto = MemoDTO.builder()
                .mno(entity.getMno())
                .memoText(entity.getMemoText())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}
