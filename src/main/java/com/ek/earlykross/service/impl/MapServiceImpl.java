package com.ek.earlykross.service.impl;

import com.ek.earlykross.entity.BestEleven;
import com.ek.earlykross.entity.Map;
import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.Player;
import com.ek.earlykross.entity.QPlayer;
import com.ek.earlykross.repository.BestRepository;
import com.ek.earlykross.repository.MapRepository;
import com.ek.earlykross.repository.MemberRepository;
import com.ek.earlykross.repository.PlayerRepository;
import com.ek.earlykross.service.BestService;
import com.ek.earlykross.service.MapService;
import com.ek.earlykross.vo.BestElevenDTO;
import com.ek.earlykross.vo.MapDTO;
import com.ek.earlykross.vo.PageRequestDTO;
import com.ek.earlykross.vo.PageResultDTO;
import com.ek.earlykross.vo.PlayerDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

// Bean 처리
@Service
@Log4j2
// 의존성 자동 주입
@RequiredArgsConstructor
public class MapServiceImpl implements MapService {

    private final MapRepository mapRepository;
    @Override
    public void save(MapDTO mapDTO) {

        Map map = dtoToEntity(mapDTO);

        mapRepository.save(map);
    }

    @Override
    public List<Map> getAll() {
        return mapRepository.findAll();
    }

}
