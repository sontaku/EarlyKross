package com.ek.earlykross.repository;


import com.ek.earlykross.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    // 쿼리 메서드
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);

    // 쿼리 메서드 + Pageable
    Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);

    // deleteBy 삭제처리
    void deleteMemoByMnoLessThan(Long num);

    // @Query 어노테이션
    // select 가능
    // DML 가능 (@Modyfying)
    @Query("select m from Memo m order by m.mno desc")
    List<Memo> getListDesc();

    // 파라미터 바인딩 중요!!
//    @Transactional
//    @Modifying
//    @Query("update Memo m set m.memoText = :memoText where m.mno = :mno")
//    int updateMemoText(@Param("mno") Long mno, @Param("memoText") String memoText);

    // 바인딩 객체로 처리
    @Transactional
    @Modifying
    @Query("update Memo m set m.memoText = :#{#param.memoText} where m.mno = :#{#param.mno}")
    int updateMemoText(@Param("param") Memo memo);

    // @Query 페이징
    // 리턴타입 : Page<엔티티 타입>
    // countQuery : Pageable 타입 파라미터 전달
    @Query(value = "select m from Memo m where m.mno > :mno", countQuery = "select count(m) from Memo m where m.mno > :mno")
    Page<Memo> getListWithQuery(Long mno, Pageable pageable);

    // Object[] 객체로 리턴
    @Query(value = "select m.mno, m.memoText, CURRENT_DATE from Memo m where m.mno > :mno", countQuery = "select count(m) from Memo m where m.mno > :mno")
    Page<Object[]> getListWithQueryObejct(Long mno, Pageable pageable);

    // Native SQL 처리
    // join 문 처리에 유연함
    // SQL 고유의 문법대로 활용
    @Query(value = "select * from memo where mno > 0", nativeQuery = true)
    List<Object[]> getNativeResult();
}
