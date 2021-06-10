package com.ek.earlykross.security.dto;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Log4j2
@Getter
@Setter
@ToString
public class AuthMemberDTO extends User { // 시큐리티 용 DTO
  private String email;

  private String name;

  private boolean fromSocial;

  public AuthMemberDTO(String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities){
    super(username,password,authorities);
    this.email = username;
    this.fromSocial = fromSocial;
  }

}
