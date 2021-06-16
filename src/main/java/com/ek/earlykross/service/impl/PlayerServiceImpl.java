package com.ek.earlykross.service.impl;

import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.repository.PlayerRepository;
import com.ek.earlykross.service.PlayerService;
import com.ek.earlykross.vo.MemberDTO;
import com.ek.earlykross.vo.PlayerDTO;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
// 의존성 자동 주입
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

  private final PlayerRepository PLrepository; // 반드시 파이널

  @Override
  public List<PlayerDTO> getAllPlayer() {
    List<Player> result = PLrepository.findAll();

    //entity to dto
    Function<Player, PlayerDTO> fn = (entity -> entityToDto(entity));
    List<PlayerDTO> playerDTOList = result.stream().map(fn).collect(Collectors.toList());
    return playerDTOList;
  }

  //player entity to dto
  PlayerDTO entityToDto(Player entity){
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
