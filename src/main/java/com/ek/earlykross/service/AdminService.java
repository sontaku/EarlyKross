package com.ek.earlykross.service;

import java.util.List;

public interface AdminService {

  //Social회원 가입자 수
  List<List> countSocialMember();

  //월별 회원 가입자 수
  List<List> countReg_dateMember();
}
