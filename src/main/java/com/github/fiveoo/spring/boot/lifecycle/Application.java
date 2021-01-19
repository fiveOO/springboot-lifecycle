package com.github.fiveoo.spring.boot.lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.fiveoo.spring.boot.lifecycle.appevent.ApplicationEventOnAppListener;

@SpringBootApplication
public class Application
{
    public static void main( final String[] args )
    {
        SpringApplication springApplication = new SpringApplication( Application.class );
        springApplication.addListeners( new ApplicationEventOnAppListener() );
        springApplication.run( args );
    }
}
