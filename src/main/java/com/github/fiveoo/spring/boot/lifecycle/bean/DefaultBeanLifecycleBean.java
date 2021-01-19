package com.github.fiveoo.spring.boot.lifecycle.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DefaultBeanLifecycleBean
{
    @PostConstruct
    public void postConstruct()
    {
        log.info( "D) BeanLifecycleBean: PostConstruct" );
    }

    @PreDestroy
    public void preDestroy()
    {
        log.info( "D) BeanLifecycleBean: PreDestroy" );
    }
}
