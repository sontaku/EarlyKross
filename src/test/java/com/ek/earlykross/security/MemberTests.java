package com.ek.earlykross.security;

import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.MemberRole;
import com.ek.earlykross.repository.MemberRepository;
import java.util.Optional;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class MemberTests {

  @Autowired
  private MemberRepository repository;

  @Autowired
  private PasswordEncoder passwordEncoder;

//  @Test
//  public void insertDummies() {
//    IntStream.rangeClosed(1, 100).forEach(i -> {
//      Member member = Member.builder()
//          .email("user" + i + "@zerock.org")
//          .name("사용자" + i)
//          .fromSocial(false)
//          .password(passwordEncoder.encode("1111"))
//          .build();
//      member.addMemberRole(MemberRole.USER);
//      if (i > 80) {
//        member.addMemberRole(MemberRole.MANAGER);
//      }
//      if (i > 90) {
//        member.addMemberRole(MemberRole.ADMIN);
//      }
//      repository.save(member);
//    });
//  }

//  @Test
//  public void testRead(){
//    Optional<Member> result = repository.findByEmail("user95@zerock.org",false);
//    Member member = result.get();
//    System.out.println(member);
//  }
}
