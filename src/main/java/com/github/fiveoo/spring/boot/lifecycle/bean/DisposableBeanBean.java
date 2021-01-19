package com.github.fiveoo.spring.boot.lifecycle.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DisposableBeanBean
    implements
        InitializingBean,
        DisposableBean
{
    @Override
    public void afterPropertiesSet()
        throws Exception
    {
        log.info( "G) InitializingBean" );
    }

    @Override
    public void destroy()
        throws Exception
    {
        log.info( "G) DisposableBean" );
    }
}
