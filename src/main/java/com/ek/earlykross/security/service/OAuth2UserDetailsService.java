package com.ek.earlykross.security.service;

import com.ek.earlykross.entity.Member;
import com.ek.earlykross.entity.MemberRole;
import com.ek.earlykross.repository.MemberRepository;
import com.ek.earlykross.security.dto.AuthMemberDTO;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class OAuth2UserDetailsService extends DefaultOAuth2UserService {

  private final MemberRepository repository;

  private final PasswordEncoder passwordEncoder;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
    log.info("=============");
    log.info("userRequest : " + userRequest);

    String clientName = userRequest.getClientRegistration().getClientName();

    log.info("clientName : " + clientName);
    log.info(userRequest.getAdditionalParameters());

    OAuth2User oAuth2User = super.loadUser(userRequest);

    log.info("===============");
    oAuth2User.getAttributes().forEach((k,v)->{
      log.info(k +" : " + v);
    });

    String email = null;
    if(clientName.equals("Google")){// 구글 사용하는 경우
      email=oAuth2User.getAttribute("email");
    }

    log.info("Email : " + email);

    Member member = saveSocialMember(email);

//    return oAuth2User;

    AuthMemberDTO authMember = new AuthMemberDTO(
        member.getEmail(),
        member.getPassword(),
        true,
        member.getRoleSet().stream().map(role->new SimpleGrantedAuthority("ROLE_" + role.name())).collect(
            Collectors.toList()),
        oAuth2User.getAttributes()
    );
    authMember.setName(member.getName());
    return authMember;
  }


  private Member saveSocialMember(String email){
    // 기존에 소셜 가입 했었는지 확인
    Optional<Member> result = repository.findByEmail(email,true);

    // 있으면 로그인 가자
    if(result.isPresent()){
      return result.get();
    }

    Member member = Member.builder().email(email)
        .name(email)
        .password(passwordEncoder.encode("1111"))
        .fromSocial(true)
        .build();
    member.addMemberRole(MemberRole.USER);

    repository.save(member);
    return member;
  }

}
