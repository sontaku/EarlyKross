package com.ek.earlykross;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// BaseEntity 의 리스너 활성화
@EnableJpaAuditing
public class EarlyKrossApplication {

  public static void main(String[] args) {
    SpringApplication.run(EarlyKrossApplication.class, args);
  }

}
