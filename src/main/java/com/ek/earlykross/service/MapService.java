package com.ek.earlykross.service;

import com.ek.earlykross.entity.Map;
import com.ek.earlykross.entity.MapMember;
import com.ek.earlykross.entity.Member;
import com.ek.earlykross.vo.MapDTO;
import com.ek.earlykross.vo.MapMemberDTO;

import java.util.List;

public interface MapService {
  
  

  default Map dtoToEntity(MapDTO dto) {
    Map entity = Map.builder()
        .mId(dto.getMId())
        .xLoc(dto.getXLoc())
        .yLoc(dto.getYLoc())
        .content(dto.getContent())
        .date(dto.getDate())
        .team(dto.getTeam())
        .host(dto.getHost())
        .mCount(dto.getMCount())
        .build();
    return entity;
  }

  // entity 를 dto 로 변환
  default MapDTO entityToDto(Map entity) {
    MapDTO dto = MapDTO.builder()
        .mId(entity.getMId())
        .xLoc(entity.getXLoc())
        .yLoc(entity.getYLoc())
        .content(entity.getContent())
        .date(entity.getDate())
        .team(entity.getTeam())
        .host(entity.getHost())
        .mCount(entity.getMCount())
        .build();
    return dto;
  }


  default MapMember dtoToEntity(MapMemberDTO dto) {
    MapMember entity = MapMember.builder()
            .uId(dto.getUId())
            .mId(dto.getMId())
            .user(dto.getUser())
            .build();
    return entity;
  }

  // entity 를 dto 로 변환
  default MapMemberDTO entityToDto(MapMember entity) {
    MapMemberDTO dto = MapMemberDTO.builder()
            .uId(entity.getUId())
            .mId(entity.getMId())
            .user(entity.getUser())
            .build();
    return dto;
  }

  void save(MapDTO mapDTO);

  List<Map> getAll();

  void countMap(Long mId, Member memberDTO);

  //팀별 수 데이터 가져오기
  List<List> countTeam();
}
