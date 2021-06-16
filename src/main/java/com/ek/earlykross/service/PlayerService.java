package com.ek.earlykross.service;

import com.ek.earlykross.entity.Player;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.PlayerDTO;

public interface PlayerService {

  PageResultDTO<PlayerDTO, Player> serach(PageRequestDTO requestDTO);

  // entity 를 dto 로 변환
  default PlayerDTO entityToDto(Player entity) {
    PlayerDTO dto = PlayerDTO.builder()
        .pId(entity.getPId())
        .cId(entity.getCId())
        .name(entity.getName())
        .ename(entity.getEname())
        .position(entity.getPosition())
        .backNo(entity.getBackNo())
        .nationality(entity.getNationality())
        .height(entity.getHeight())
        .weight(entity.getWeight())
        .birthday(entity.getBirthday())
        .build();
    return dto;
  }
}
