package com.github.fiveoo.spring.boot.lifecycle.appevent;

import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationEventOnAppListener
    implements
        ApplicationListener<SpringApplicationEvent>
{
    @Override
    public void onApplicationEvent( final SpringApplicationEvent event )
    {
        log.info( "A) ApplicationEventOnAppListener: {}", event.getClass().getSimpleName() );
    }
}
