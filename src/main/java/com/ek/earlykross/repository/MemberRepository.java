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

  Member findMemberByEmail(String email);
  // 관리자 페이지 회원조회
//  findAll();
//  List<Member> findAll();


  //SocialMember 수 가져오기
  @Query(value = "select from_social, count(*) from member group by from_social",nativeQuery = true)
  List<List> countSocialMember();
  //Table에서 데이터를 가져올때는 매개변수가 필요없다
  //Table에 데이터를 집어 넣을때는 매개변수가 필요하다.
}
