package com.ek.earlykross.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

  @GetMapping("admin")
  public void AdminPage(){

  }

  @GetMapping("admin/admin_header")
  public void AdminPageHeader(){

  }
}
