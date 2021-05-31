package com.ek.earlykross.entity;

import java.io.Serializable;
import lombok.Data;

// 다중 복합키 설정
@Data
public class BestElevenPK implements Serializable {
  private String season; // 시즌
  private int round; // 라운드
}
