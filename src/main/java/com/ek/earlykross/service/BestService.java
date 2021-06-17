package com.ek.earlykross.service;

import com.ek.earlykross.entity.BestEleven;
import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.repository.BestRepository;
import com.ek.earlykross.vo.BestElevenDTO;
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

  default Member dtoToEntity(MemberDTO dto) {
    Member entity = Member.builder()
        .mId(dto.getMId())
        .email(dto.getEmail())
        .name(dto.getName())
        .password(dto.getPassword())
        .build();
    return entity;
  }

  // entity 를 dto 로 변환
  default MemberDTO entityToDto(Member entity) {
    MemberDTO dto = MemberDTO.builder()
        .mId(entity.getMId())
        .email(entity.getEmail())
        .password(entity.getPassword())
        .name(entity.getName())
        .build();
    return dto;
  }

  default BestEleven dtoToEntity(BestElevenDTO dto) {
    BestEleven entity = BestEleven.builder()
        .season(dto.getSeason())
        .round(dto.getRound())
        .mId(dto.getMId())
        .p1(dto.getP1())
        .p2(dto.getP2())
        .p3(dto.getP3())
        .p4(dto.getP4())
        .p5(dto.getP5())
        .p6(dto.getP6())
        .p7(dto.getP7())
        .p8(dto.getP8())
        .p9(dto.getP9())
        .p10(dto.getP10())
        .p11(dto.getP11())
        .build();
    return entity;
  }

  // entity 를 dto 로 변환
  default BestElevenDTO entityToDto(BestEleven entity) {
    BestElevenDTO dto = BestElevenDTO.builder()
        .season(entity.getSeason())
        .round(entity.getRound())
        .mId(entity.getMId())
        .p1(entity.getP1())
        .p2(entity.getP2())
        .p3(entity.getP3())
        .p4(entity.getP4())
        .p5(entity.getP5())
        .p6(entity.getP6())
        .p7(entity.getP7())
        .p8(entity.getP8())
        .p9(entity.getP9())
        .p10(entity.getP10())
        .p11(entity.getP11())
        .build();
    return dto;
  }
  Player selectPidByPlayer(PlayerDTO playerDTO);

  Member findBestByEmail(String username);

  boolean findBest(String username);

  void save(BestElevenDTO bestElevenDTO);
}
