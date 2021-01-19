package com.github.fiveoo.spring.boot.lifecycle.appevent;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApplicationEventListenerBean
    implements
        ApplicationListener<ApplicationEvent>
{
    @Override
    public void onApplicationEvent( final ApplicationEvent event )
    {
        if( event instanceof AvailabilityChangeEvent<?>)
        {
            log.info( "B) ApplicationEventListener Bean: {}({}}", event.getClass().getSimpleName(),
                    ( (AvailabilityChangeEvent<?>)event ).getState() );
            if( ReadinessState.ACCEPTING_TRAFFIC == ( (AvailabilityChangeEvent<?>)event ).getState() )
            {
                // seems that this is the correct moment ;-)
                log.info( "--- Application up and running ---" );
            }
        }
        else
        {
            log.info( "B) ApplicationEventListener Bean: {}", event.getClass().getSimpleName() );
        }
    }
}
