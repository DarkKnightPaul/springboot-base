package top.huhuiyu.myspringboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import top.huhuiyu.myspringboot.util.JsonMessage;

@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {
  private static final Logger LOG = LoggerFactory.getLogger(MyExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  public JsonMessage handleException(Exception ex) {
    LOG.error("处理发生错误", ex);
    return JsonMessage.getFailMessage("服务器忙，请稍后重试...");
  }

}
