package com.github.fiveoo.spring.boot.lifecycle.jvm;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JvmShutdownHook
{
    public JvmShutdownHook()
    {
        log.info( "E) Installing JvmShutdownHook" );
        Runtime.getRuntime().addShutdownHook( new Thread( () ->
        {
            log.info( "E) JvmShutdownHook" );
        } ) );
    }
}
