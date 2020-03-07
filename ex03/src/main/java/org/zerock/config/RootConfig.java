package org.zerock.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"org.zerock.service"})
@ComponentScan(basePackages = "org.zerock.aop")
@EnableAspectJAutoProxy
@EnableScheduling
@EnableTransactionManagement
@MapperScan(basePackages = {"org.zerock.mapper"})
public class RootConfig {
	
}
