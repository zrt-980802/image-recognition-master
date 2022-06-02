package com.yuxue.aop;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Andong
 * @date 2022/5/17
 */
@Configuration
@ConditionalOnMissingBean(DefaultPointcutAdvisor.class)
public class DefaultAopConfig {
	
	// @Value("${test.aop.pointcut:com.yuxue..*.controller..*.*(..)}")
	@Value("${test.aop.pointcut:com.yuxue.controller..*.*(..)}")
	private String pattern;

	@Bean("resultAop")
	public DefaultPointcutAdvisor resultAop() {
		DefaultPointcutAdvisor pfb = new DefaultPointcutAdvisor();
		JdkRegexpMethodPointcut j = new JdkRegexpMethodPointcut();
		j.setPattern(pattern);
		AroundMethod method = new AroundMethod();
		pfb.setAdvice(method);
		pfb.setPointcut(j);
		return pfb;
	}
}
