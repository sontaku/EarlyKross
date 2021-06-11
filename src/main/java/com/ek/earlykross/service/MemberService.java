package com.ek.earlykross.service;


import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.Role;
import com.ek.earlykross.repository.MemberRepository;
import com.ek.earlykross.vo.MemberDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
//@AllArgsConstructor
//public class MemberService implements UserDetailsService {
//    private final MemberRepository memberRepository;
//
//    @Transactional
//    public Long joinUser(MemberDTO memberDTO) {
//        // 비밀번호 암호화
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
//
//        return memberRepository.save(memberDTO.toEntity()).getId();
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
//        Optional<Member> userEntityWrapper = memberRepository.findByEmail(userEmail);
//        Member userEntity = userEntityWrapper.get();
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        if (("admin@example.com").equals(userEmail)) {
//            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
//        } else {
//            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
//        }
//
//        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
//    }
//}