package com.ek.earlykross.vo;

import com.ek.earlykross.entity.Club;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data // 게터 세터 투스티링 이퀄 해시코드 자동생성
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PlayerDTO {

    private int pId; // 선수번호
    private Club cId; // 클럽번호 - 선수는 소속클럽이 없을 수 있음
    private String name; // 이름
    private String ename; // 영문명
    private String position; // 포지션
    private int backNo; // 등번호
    private String nationality; // 국적
    private int height; // 키
    private int weight; // 몸무게
    private String birthday; // 생년월일
}
