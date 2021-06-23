package com.ek.earlykross.service.impl;

import com.ek.earlykross.repository.MemberRepository;
import com.ek.earlykross.service.AdminService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

  private final MemberRepository memberRepository;

  //각 Social 별 회원 수 가져오기
  @Override
  public List<List> countSocialMember() {
    return memberRepository.countSocialMember();
  }
}
