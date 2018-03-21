package top.huhuiyu.myspringboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import top.huhuiyu.myspringboot.service.DemoService;

@Component
@WebFilter(urlPatterns = "/*", filterName = "demoFilter")
public class DemoFilter implements Filter {
  private static final Logger log = LoggerFactory.getLogger(DemoFilter.class);
  @Autowired
  private DemoService demoService;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    log.debug("DemoFilter.init");
    log.debug("DemoFilter.doFilter" + demoService.queryAll());
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    log.debug("DemoFilter.doFilter path:" + req.getRequestURI());
    log.debug("DemoFilter.doFilter session:" + req.getSession().getId());
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    log.debug("DemoFilter.destroy");
  }

}
