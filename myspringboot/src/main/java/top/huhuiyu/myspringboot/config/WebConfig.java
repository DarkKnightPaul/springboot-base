package top.huhuiyu.myspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import top.huhuiyu.myspringboot.filter.DemoInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

  @Bean
  public DemoInterceptor getDemoInterceptor() {
    return new DemoInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(getDemoInterceptor()).addPathPatterns("/**");
    super.addInterceptors(registry);
  }
}
