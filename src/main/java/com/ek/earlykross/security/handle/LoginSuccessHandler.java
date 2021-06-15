package com.ek.earlykross.security.handle;

import com.ek.earlykross.security.dto.AuthMemberDTO;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Log4j2
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

  private final RedirectStrategy redirrectStrategy = new DefaultRedirectStrategy();

  private final PasswordEncoder passwordEncoder;

  public LoginSuccessHandler(PasswordEncoder passwordEncoder){
    this.passwordEncoder=passwordEncoder;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    log.info("------------------------");
    log.info("onAuthenticationsSuccess");

    AuthMemberDTO authMember = (AuthMemberDTO)authentication.getPrincipal();

    boolean fromSocial = authMember.isFromSocial();

    log.info("Need Modify Member? : " + fromSocial);

    boolean passwordResult = passwordEncoder.matches("1111",authMember.getPassword());

    if(fromSocial && passwordResult){ // 소셜에다가 패스워드도 1111 이면
      redirrectStrategy.sendRedirect(request,response,"/");
//      redirrectStrategy.sendRedirect(request,response,"/member/modify?from=social");
    }

  }


//  @Override
//  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//      FilterChain chain, Authentication authentication) throws IOException, ServletException {
//    AuthenticationSuccessHandler.super
//        .onAuthenticationSuccess(request, response, chain, authentication);
//  }
}
