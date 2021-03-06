package com.ek.earlykross.vo;

// 전달 되는 목록 관련 DTO

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
    private int page;
    private int size;
    private String type;
    private String keyword;

    // 기본값은 1, 10이 좋으니까
    public PageRequestDTO() {
        this.page = 1;
        this.size = 10;
    }

    public PageRequestDTO(int page, int size) {
        this.page = page;
        this.size = size;
    }

    // JPA 에서 사용할 Pageable 객체를 생성, JPA 는 0번부터 시작하니까 -1, 정렬은 나중에 다양한 상황을 위해
    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page-1, size, sort);
    }
}
