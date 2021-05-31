package com.ek.earlykross.repository;


import com.ek.earlykross.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass() {
        System.out.println(memoRepository.getClass().getName());
    }

//    @Test
//    public void testInsertDummies() {
//        IntStream.rangeClosed(1, 100).forEach(i -> {
//            Memo memo = Memo.builder().memoText("Sample..." + i).build();
//            memoRepository.save(memo);
//        });
//    }

    // findById()
//    @Test
//    public void testSelect() {
//        Long mno = 100L;
//        Optional<Memo> result = memoRepository.findById(mno);
//
//        System.out.println("===========================1");
//
//        if(result.isPresent()) {
//            Memo memo = result.get();
//            System.out.println(memo);
//        }
//    }

    // getOne()
//    @Transactional // 트랜잭션 처리
//    @Test
//    public void testSelect2() {
//        Long mno = 100L;
//        Memo memo = memoRepository.getOne(mno);
//
//        System.out.println("===========================2");
//        System.out.println(memo);
//    }

    // 수정
//    @Test
//    public void testUpdate() {
//        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
//        System.out.println(memoRepository.save(memo));
//    }

    // 삭제
//    @Test
//    public void testDelete() {
//        Long mno = 100L;
//        // 존재하지않으면 EmptyDataAccessException 예외 발생
//        memoRepository.deleteById(mno);
//    }

    // 페이징
//    @Test
//    public void testPageDefault() {
//        // 1페이지의 데이터 10개
//        Pageable pageble = PageRequest.of(0, 10);
//
//        Page<Memo> result = memoRepository.findAll(pageble);
//
//        System.out.println(result);
//        System.out.println("============================");
//        System.out.println("Total Pages: " + result.getTotalPages()); // 총 몇페이지
//        System.out.println("Total Count: " + result.getTotalElements()); // 전체 개수
//        System.out.println("Page Number: " + result.getNumber()); // 현재 페이지 번호 0부터 시작
//        System.out.println("Page Size: " + result.getSize()); // 페이지당 데이터 갯수
//        System.out.println("has next Page?: " + result.hasNext()); // 다음 페이지
//        System.out.println("first page: " + result.isFirst()); // 시작 페이지(0) 여부
//
//        System.out.println("============================");
//
//        // 실제 페이지 데이터 처리
//        for(Memo memo : result.getContent()) {
//            System.out.println(memo);
//        }
//    }

    // 페이지 정렬
//    @Test
//    public void testSort() {
//        Sort sort1 = Sort.by("mno").descending(); // 역순 정렬
//
//        // 정렬 조건
//        Sort sort2 = Sort.by("memoText").ascending(); // 순차 정렬
//        Sort sortAll = sort1.and(sort2); // and를 이용한 연결
//
////        Pageable pageable = PageRequest.of(0, 10, sort1);
//        Pageable pageable = PageRequest.of(0, 10, sortAll);
//
//
//        Page<Memo> result = memoRepository.findAll(pageable);
//
//        result.get().forEach(memo -> {
//            System.out.println(memo);
//        });
//    }

    // 쿼리 메소드
//    @Test
//    public void testQueryMethods() {
//        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L); // 조건 70~80
//
//        for(Memo memo : list) {
//            System.out.println(memo);
//        }
//    }

    // 쿼리 메소드 + Pageable
    @Test
    public void testQueryMethodWithPageable() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());

        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);

        result.get().forEach(memo -> System.out.println(memo));
    }

    // deleteBy
    // 실제 개발시에는 @Query를 이용허자
    @Commit // 최종 결과 커밋
    @Transactional
    @Test
    public void testDeleteQueryMethods() {
        memoRepository.deleteMemoByMnoLessThan(10L);
    }
    

}

