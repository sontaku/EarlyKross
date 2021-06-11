package com.ek.earlykross.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter { //시큐리티 관련 기능 쉽게

  @Bean
  PasswordEncoder PasswordEncoder(){// 비밀번호를 암호화 하는 것
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception{
    http.authorizeRequests()
        .antMatchers("/sample/all").permitAll()// 이 사이트는 모든 사용자에게 허락
        .antMatchers("/sample/member").hasRole("USER");
    http.formLogin();
//        .loginPage("/member/loginForm");
    http.csrf().disable();// 토큰 발행 비활성화
    http.logout()
        .logoutSuccessUrl("/");

  }

//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//    auth.inMemoryAuthentication().withUser("user1") // 임의 사용자 계정
//    .password("$2a$10$YhOXwzj6t75Qr28MaWoPvOzrPS9EIFt0uq6ghRW0D0OmJ6yRrnDXG")
//    .roles("USER");
//  }
}