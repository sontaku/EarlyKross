package com.ek.earlykross.repository;

import com.ek.earlykross.entity.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {

  @EntityGraph(attributePaths = {"roleSet"},type = EntityGraphType.LOAD)
  @Query("select m from Member m where m.fromSocial=:social and m.email=:email")
  Optional<Member> findByEmail(String email, boolean social);

  // 관리자 페이지 회원조회
//  findAll();
//  List<Member> findAll();
}
