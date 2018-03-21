package top.huhuiyu.myspringboot.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import top.huhuiyu.myspringboot.service.DemoService;

public class DemoInterceptor implements HandlerInterceptor {
  private static final Logger log = LoggerFactory.getLogger(DemoInterceptor.class);
  @Autowired
  private DemoService demoService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    log.debug("DemoInterceptor.preHandle" + demoService.queryAll());
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    log.debug("DemoInterceptor.postHandle");
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    log.debug("DemoInterceptor.afterCompletion");
  }

}
