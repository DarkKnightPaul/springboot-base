package top.huhuiyu.myspringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.huhuiyu.myspringboot.entity.JsonMessage;
import top.huhuiyu.myspringboot.entity.TbTest;
import top.huhuiyu.myspringboot.model.DemoModel;
import top.huhuiyu.myspringboot.service.DemoService;

@RestController
public class DemoController {

  @Autowired
  private DemoService demoService;

  private static final Logger log = LoggerFactory.getLogger(DemoController.class);

  @RequestMapping("/")
  public String index() {
    return "我的SpringBoot演示!";
  }

  @RequestMapping("/demo/echo")
  @ResponseBody
  public JsonMessage echo(DemoModel model) {
    log.info("测试info");
    try {
      JsonMessage message = JsonMessage.getSuccessMessage("echo测试");
      message.getDataMap().put("test", model.getTest());
      message.getDataMap().put("page", model.getPage());
      log.debug("测试debug:" + (100 / model.getTest().getTid()));
      return message;
    } catch (Exception e) {
      return JsonMessage.getFailMessage(e);
    }
  }

  @RequestMapping("/demo/queryAll")
  @ResponseBody
  public JsonMessage queryAll(DemoModel model) {
    try {
      PageHelper.startPage(model.getPage().getPageNumber(), model.getPage().getPageSize());
      Page<TbTest> list = (Page<TbTest>) demoService.queryAll();
      JsonMessage message = JsonMessage.getSuccessMessage("查询成功");
      message.getDataMap().put("list", list);
      message.getDataMap().put("page", model.getPage().setPageInfo(list));
      return message;

    } catch (Exception e) {
      return JsonMessage.getFailMessage(e.getMessage());
    }
  }

  @RequestMapping("/demo/queryMapping")
  @ResponseBody
  public JsonMessage queryMapping(DemoModel model) {
    try {

      JsonMessage message = JsonMessage.getSuccessMessage("查询成功");
      message.getDataMap().put("list", demoService.queryMapping());
      return message;

    } catch (Exception e) {
      return JsonMessage.getFailMessage(e.getMessage());
    }
  }

}
