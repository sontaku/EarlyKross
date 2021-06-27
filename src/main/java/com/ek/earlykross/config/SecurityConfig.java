package com.ek.earlykross.config;

import com.ek.earlykross.security.handle.LoginSuccessHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) // 접근 제한 설정
public class SecurityConfig extends WebSecurityConfigurerAdapter { //시큐리티 관련 기능 쉽게

  @Autowired
  private UserDetailsService userDetailsService;

  @Bean
  PasswordEncoder passwordEncoder() {// 비밀번호를 암호화 하는 것
    return new BCryptPasswordEncoder();
  }
//
//  @Override
//  public void configure(WebSecurity web) throws Exception {
//    web
//        .ignoring()
//        .antMatchers(HttpMethod.GET, "users-ws/users/status/check")
//        .antMatchers(HttpMethod.POST, "users-ws/users/h2-console/**")
//        .antMatchers(HttpMethod.POST, "users-ws/users/createUser")
//        .antMatchers(HttpMethod.POST, "users-ws/users/login");
//
//    //completely bypass the Spring Security Filter Chain.
//  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/sample/all").permitAll()// 이 사이트는 모든 사용자에게 허락
//        .antMatchers("/sample/member","/best11/best.do","/map/*").hasRole("USER")
        .antMatchers("/sample/member","/best11/best.do","/map/*").hasRole("ADMIN");
    http.formLogin();
//        .loginPage("/member/loginForm");
    http.csrf().disable();// 토큰 발행 비활성화
    http.logout()
        .logoutSuccessUrl("/");
    http.oauth2Login().successHandler(successHandler());
    http.rememberMe().tokenValiditySeconds(60 * 60 * 7)
        .userDetailsService(userDetailsService); // 자동로그인 7일을 뜻 함
  }

  @Bean
  public LoginSuccessHandler successHandler() {
    return new LoginSuccessHandler(passwordEncoder());
  }

//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//    auth.inMemoryAuthentication().withUser("user1") // 임의 사용자 계정
//    .password("$2a$10$YhOXwzj6t75Qr28MaWoPvOzrPS9EIFt0uq6ghRW0D0OmJ6yRrnDXG")
//    .roles("USER");
//  }
}