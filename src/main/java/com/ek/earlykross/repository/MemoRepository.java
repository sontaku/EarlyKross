package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> { // <테이블 명, PK의 자료형)

//    // 이름 자체가 쿼리문인 쿼리메소드
//    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
//
//    // 페이징 규칙은 따로 정하기 위한 쿼리메소드
//    Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);
//
//    // mno 보다 아래인 놈들만 지우겠다.
//    void deleteMemoByMnoLessThan(Long num);
//
//    // mno 보다 아래인 놈들만 지우겠다.
//
//
//    @Transactional
//    @Modifying
//    @Query("update Memo m set m.memoText = :#{#param.memoText} where m.mno = :#{#param.mno}")
//    int updateMemoText(@Param("param")Memo memo);
}
