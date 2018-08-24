package com.example.testjenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/hello")
  public String helloController(){
    return "Hello!";
  }
}
