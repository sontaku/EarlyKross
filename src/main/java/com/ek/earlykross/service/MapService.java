package com.ek.earlykross.service;

import com.ek.earlykross.entity.BestEleven;
import com.ek.earlykross.entity.Map;
import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.vo.BestElevenDTO;
import com.ek.earlykross.vo.MapDTO;
import com.ek.earlykross.vo.MemberDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.PlayerDTO;
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
        .build();
    return dto;
  }

  void save(MapDTO mapDTO);

  List<Map> getAll();
}
