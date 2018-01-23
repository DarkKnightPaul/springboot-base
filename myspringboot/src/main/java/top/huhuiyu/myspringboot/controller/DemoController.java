package top.huhuiyu.myspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
  @RequestMapping("/")
  public String index() {
    return "我的SpringBoot演示!";
  }
}
