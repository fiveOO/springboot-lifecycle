package com.github.fiveoo.spring.boot.lifecycle.lifecycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MaxSmartLifecycleBean
    implements
        SmartLifecycle
{
    private boolean initialized = false;

    @Override
    public void start()
    {
        initialized = true;
        log.info( "C) MaxSmartLifecycle: start()" );
    }

    @Override
    public void stop()
    {
        log.info( "C) MaxSmartLifecycle: stop()" );
    }

    @Override
    public boolean isRunning()
    {
        // start()/stop() is only called if this method returns false/true
        return initialized;
    }

    @Override
    public int getPhase()
    {
        return Integer.MAX_VALUE;
    }
}
