package top.huhuiyu.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import top.huhuiyu.myspringboot.model.DemoModel;

@Controller
@RequestMapping("/html")
public class TemplateController {

  @RequestMapping("/index")
  public String index(DemoModel demoModel, Model model) {
    model.addAttribute("test", demoModel.getTest());
    return "index";
  }
  
  @RequestMapping("/test")
  public String test(DemoModel demoModel, Model model) {
    model.addAttribute("test", demoModel.getTest());
    return "other/test";
  }
}
