package com.ek.earlykross.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 리그 다중 복합키 설정
@Data
public class LeaguePK implements Serializable {
    private Club cId; // 클럽번호
    private String season; // 시즌
}
