package com.yuxue.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


/**
 * @author Andong
 * @date 2022/5/17
 */
@Configuration
public class PageHelperConfig {

  @Value("${pagehelper.helperDialect}")
  private String helperDialect;

  @Bean
  public PageInterceptor pageInterceptor() {
    PageInterceptor pageInterceptor = new PageInterceptor();
    Properties properties = new Properties();
    properties.setProperty("helperDialect", helperDialect);
    pageInterceptor.setProperties(properties);
    return pageInterceptor;
  }
}
