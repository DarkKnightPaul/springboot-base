package top.huhuiyu.myspringboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import top.huhuiyu.myspringboot.util.JsonMessage;

@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {
  private static final Logger LOG = LoggerFactory.getLogger(MyExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  public JsonMessage handleException(Exception ex) {
    LOG.error("处理发生错误", ex);
    LOG.debug("错误类型：" + ex.getClass());
    if (ex instanceof NoHandlerFoundException) {
      JsonMessage json = JsonMessage.getFailMessage("请求的资源不存在。。。");
      json.setCode(404);
      return json;
    }
    return JsonMessage.getFailMessage("服务器忙，请稍后重试...");
  }

}
