package com.ek.earlykross.service;

import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.repository.PlayerRepository;
import com.ek.earlykross.vo.MemberDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.PlayerDTO;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface BestService {

  default void message(){
    System.out.println("dc service");
  }

  //선수 검색 아약스
  PageResultDTO<PlayerDTO, Player> serach(PageRequestDTO requestDTO);

//    // 메모 하나 읽기
//    MemoDTO read(Long mno);
//    //메모 등록
//    Long register(MemoDTO dto);
//    // 메모 전체 읽기
//    PageResultDTO<MemoDTO, Memo> getList(PageRequestDTO requestDTO);
//    //메모 삭제
//    void remove(Long mno);
//    //메모 수정
//    void modify(MemoDTO dto);
    // dto 를 entity 로 변환
    default Player dtoToEntity(PlayerDTO dto) {
        Player entity = Player.builder()
                .pId(dto.getPId())
                .cId(dto.getCId())
                .name(dto.getName())
                .ename(dto.getEname())
                .position(dto.getPosition())
                .backNo(dto.getBackNo())
                .nationality(dto.getNationality())
                .height(dto.getHeight())
                .weight(dto.getWeight())
                .birthday(dto.getBirthday())
                .build();
        return entity;
    }
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

  int selectPidByPlayer(PlayerDTO playerDTO);
}
