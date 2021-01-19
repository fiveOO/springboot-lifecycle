package com.github.fiveoo.spring.boot.lifecycle.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DefaultBeanLifecycleConfig
{
    @PostConstruct
    public void postConstruct()
    {
        log.info( "F) BeanLifecycleConfig: PostConstruct" );
    }

    @PreDestroy
    public void preDestroy()
    {
        log.info( "F) BeanLifecycleConfig: PreDestroy" );
    }
}
