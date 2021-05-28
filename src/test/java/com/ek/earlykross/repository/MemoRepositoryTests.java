package com.ek.earlykross.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
//        // 새로운 객체 100개를 insert
//        IntStream.rangeClosed(1, 100).forEach(i -> {
//            Memo memo = Memo.builder().memoText("Sample..." + i).build();
//            memoRepository.save(memo);
//        });
//    }

//    @Test
//    public void testSelect() {
//
//        // 데이터베이스에 존재하는 mno
//        Long mno = 100L;
//
//        // memoRepository VO 나 <Memo> 에서 100 이 있느냐?
//        Optional<Memo> result = memoRepository.findById(mno);
//
//        System.out.println("===================================");
//
//        if (result.isPresent()) {
//            Memo memo = result.get();
//            System.out.println(memo);
//        }
//    }

//    @Transactional// getOne() 에 필요한 트랜잭션 처리
//    @Test
//    public void testSelect2() {
//        Long mno = 100L;
//
//        // 테이블에서 mno id 가 100 인 것, 값을 찾아도 탐색은 끝까지
//        Memo memo = memoRepository.getOne(mno);
//
//        // 탐색이 진행되는 중간에 다른 동작 실행
//        System.out.println("====================================");
//
//        System.out.println(memo);
//
//    }

//    @Test
//    public void testUpdate() {
//        // mno 의 해당 id(100) 의 memoText 컬럼을 "Update Text"로 설정한 Memo VO 를
//        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
//
//        // 테이블에 save insert
//        System.out.println(memoRepository.save(memo));
//    }

//    @Test
//    public void testDelete(){
//        Long mno = 100L;
//
//        // 리턴되는 값이 없으니 print X, 삭제할 데이터 없으면, Empty Data Result Access Exception
//        memoRepository.deleteById(mno);
//    }

//    @Test
//    public void testPageDefalut() {
//
//        //1페이지에 데이터 10개 가져옴, Pageable 객체 중 domain, 페이징 한 갯수도 가져옴
//        Pageable pageable = PageRequest.of(0, 10);
//
//        Page<Memo> result = memoRepository.findAll(pageable);
//
//        System.out.println(result);
//
//        System.out.println("======================================");
//
//        System.out.println("총 페이지 수: " + result.getTotalPages()); // 10 페이지
//        System.out.println("전체 데이터 수: " + result.getTotalElements()); // 99개
//        System.out.println("현재 페이지 번호 ( 0부터 시작 ): " + result.getNumber()); // 0
//        System.out.println("페이지 당 데이터 수: " + result.getSize()); // 10개
//        System.out.println("다음 페이지 존재 여부: " + result.hasNext()); // true
//        System.out.println("시작페이지 여부: " + result.isFirst()); // true
//
//        System.out.println("=======================================");
//
//        // getContent 로 VO를 배열로 받거나, Stream<VO> 반환
//        for(Memo memo : result.getContent()){
//            System.out.println(memo.getMemoText());
//        }
//    }

    //    @Test
//    public void testSort() {
//        //내림차순
//        Sort sort1 = Sort.by("mno").descending();
//        Sort sort2 = Sort.by("memoText").ascending();
//
//        Sort sortAll = sort1.and(sort2);
//
//        Pageable pageable = PageRequest.of(0, 10, sortAll);
//
//        Page<Memo> result = memoRepository.findAll(pageable);
//
//        result.get().forEach(memo -> {
//            System.out.println(memo);
//        });
//    }

//    @Test
//    public void testQueryMethods() {
//
//        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);
//
//        for (Memo memo : list) {
//            System.out.println(memo);
//        }
//    }

//    @Test
//    public void testQueryMethodWithPageable() {
//
//        // 페이징 규칙
//        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
//
//        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);
//
//        result.get().forEach(memo -> {
//            System.out.println(memo.getMemoText());
//        });
//    }

//    @Commit
//    @Transactional
//    @Test
//    public void testDeleteQueryMethods() {
//        memoRepository.deleteMemoByMnoLessThan(10L);
//    }

//    @Commit
//    @Transactional
//    @Test
//    public void testDeleteQueryMethods2() {
//        memoRepository.deleteMemoByMnoBetween(5L, 10L);
//    }


//    @Test
//    public void testQueryAno(){
//        Memo m2 = new Memo(11L, "쿼리어노테이션");
//        // @Query 어노테이션
//        memoRepository.updateMemoText(m2);
//    }
}