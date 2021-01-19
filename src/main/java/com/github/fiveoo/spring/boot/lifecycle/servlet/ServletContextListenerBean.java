package com.github.fiveoo.spring.boot.lifecycle.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ServletContextListenerBean
    implements
        ServletContextListener
{
    @Override
    public void contextInitialized( final ServletContextEvent sce )
    {
        log.info( "H) ServletContextListener: init" );
    }

    @Override
    public void contextDestroyed( final ServletContextEvent sce )
    {
        log.info( "H) ServletContextListener: destroy" );
    }
}
