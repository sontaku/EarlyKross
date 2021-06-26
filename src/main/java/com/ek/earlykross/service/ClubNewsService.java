package com.ek.earlykross.service;

import com.ek.earlykross.entity.ClubNews;
import com.ek.earlykross.vo.ClubNewsVO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;


public interface ClubNewsService {

  // 뉴스 한 개 읽기
  ClubNewsVO read(Long nId);

  // 뉴스 전체 읽기
//  List<ClubNewsVO> getList();

  // 뉴스 페이지 단위로 읽기
  PageResultDTO<ClubNewsVO,ClubNews> getList(PageRequestDTO requestDTO);


  // dto 를 entity 로 변환
  default ClubNews dtoToEntity(ClubNewsVO dto) {
    ClubNews entity = ClubNews.builder()
        .nId(dto.getNId())
        .title(dto.getTitle())
        .updateTime(dto.getUpdateTime())
        .imageurl(dto.getImageurl())
        .source(dto.getSource())
        .cName(dto.getCName())
        .build();
    return entity;
  }

  // entity 를 dto 로 변환
  default ClubNewsVO entityToDto(ClubNews entity) {
    ClubNewsVO dto = ClubNewsVO.builder()
        .nId(entity.getNId())
        .title(entity.getTitle())
        .updateTime(entity.getUpdateTime())
        .imageurl(entity.getImageurl())
        .source(entity.getSource())
        .cName(entity.getCName())
        .build();
    return dto;
  }
}
