package com.ek.earlykross.service.impl;

import com.ek.earlykross.entity.Map;
import com.ek.earlykross.entity.MapMember;
import com.ek.earlykross.entity.Member;
import com.ek.earlykross.repository.*;
import com.ek.earlykross.service.MapService;
import com.ek.earlykross.vo.MapDTO;

import java.util.List;
import java.util.Optional;

import com.ek.earlykross.vo.MapMemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

// Bean 처리
@Service
@Log4j2
// 의존성 자동 주입
@RequiredArgsConstructor
public class MapServiceImpl implements MapService {

    private final MapRepository mapRepository;
    private final MapMemberRepository mapMemberRepository;


    @Override
    public void save(MapDTO mapDTO) {

        Map map = dtoToEntity(mapDTO);

        mapRepository.save(map);
    }

    @Override
    public List<Map> getAll() {
        return mapRepository.findAll();
    }

    @Override
    public void countMap(Long mId, Member memberDTO) {
        Optional<Map> map = mapRepository.findById(mId);

        Map map1 = map.get();
        map1.changeMCount(map1.getMCount()+1);
        mapRepository.save(map1);

        MapMemberDTO mapMemberDTO = new MapMemberDTO();
        mapMemberDTO.setMId(map1);
        mapMemberDTO.setUser(memberDTO);

        MapMember mapMember = dtoToEntity(mapMemberDTO);
        mapMemberRepository.save(mapMember);

    }

    //각 팀별 건수 가져오기
    @Override
    public List<List> countTeam() {
        return mapRepository.countTeam();
    }

}
