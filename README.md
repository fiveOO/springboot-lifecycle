# SpringBoot Lifecycle

Spring / SpringBoot implements a lifecycle used to startup / shutdown components and beans. There are several possibilities
a developer could use to hook his own beans into this lifecycle.

This application shows these techniques and prints messages to the log to review in which sequence startup / shutdown
is processed.

Therefore start the application, wait until the message `--- Application up and running ---` is shown and
stop the application by sending ^C or SIGTERM.

The result will be something like

```
INFO 17376 --- [           main] .f.s.b.l.a.ApplicationEventOnAppListener : A) ApplicationEventOnAppListener: ApplicationEnvironmentPreparedEvent

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.2)

INFO 17376 --- [           main] .f.s.b.l.a.ApplicationEventOnAppListener : A) ApplicationEventOnAppListener: ApplicationContextInitializedEvent
INFO 17376 --- [           main] .f.s.b.l.a.ApplicationEventOnAppListener : A) ApplicationEventOnAppListener: ApplicationPreparedEvent
INFO 17376 --- [           main] c.g.f.s.b.l.s.ServletContextListenerBean : H) ServletContextListener: init
INFO 17376 --- [           main] c.g.f.s.b.l.b.DefaultBeanLifecycleBean   : D) BeanLifecycleBean: PostConstruct
INFO 17376 --- [           main] c.g.f.s.b.l.b.DefaultBeanLifecycleConfig : F) BeanLifecycleConfig: PostConstruct
INFO 17376 --- [           main] c.g.f.s.b.l.bean.DisposableBeanBean      : G) InitializingBean
INFO 17376 --- [           main] c.g.f.s.b.lifecycle.jvm.JvmShutdownHook  : E) Installing JvmShutdownHook
INFO 17376 --- [           main] c.g.f.s.b.l.l.MinSmartLifecycleBean      : C) MinSmartLifecycle: start()
INFO 17376 --- [           main] g.f.s.b.l.a.ApplicationEventListenerBean : B) ApplicationEventListener Bean: ServletWebServerInitializedEvent
INFO 17376 --- [           main] c.g.f.s.b.l.l.MaxSmartLifecycleBean      : C) MaxSmartLifecycle: start()
INFO 17376 --- [           main] g.f.s.b.l.a.ApplicationEventListenerBean : B) ApplicationEventListener Bean: ContextRefreshedEvent
INFO 17376 --- [           main] .f.s.b.l.a.ApplicationEventOnAppListener : A) ApplicationEventOnAppListener: ApplicationStartedEvent
INFO 17376 --- [           main] g.f.s.b.l.a.ApplicationEventListenerBean : B) ApplicationEventListener Bean: ApplicationStartedEvent
INFO 17376 --- [           main] g.f.s.b.l.a.ApplicationEventListenerBean : B) ApplicationEventListener Bean: AvailabilityChangeEvent(CORRECT}
INFO 17376 --- [           main] .f.s.b.l.a.ApplicationEventOnAppListener : A) ApplicationEventOnAppListener: ApplicationReadyEvent
INFO 17376 --- [           main] g.f.s.b.l.a.ApplicationEventListenerBean : B) ApplicationEventListener Bean: ApplicationReadyEvent
INFO 17376 --- [           main] g.f.s.b.l.a.ApplicationEventListenerBean : B) ApplicationEventListener Bean: AvailabilityChangeEvent(ACCEPTING_TRAFFIC}
INFO 17376 --- [           main] g.f.s.b.l.a.ApplicationEventListenerBean : --- Application up and running ---
INFO 17376 --- [extShutdownHook] g.f.s.b.l.a.ApplicationEventListenerBean : B) ApplicationEventListener Bean: AvailabilityChangeEvent(REFUSING_TRAFFIC}
INFO 17376 --- [       Thread-1] c.g.f.s.b.lifecycle.jvm.JvmShutdownHook  : E) JvmShutdownHook
INFO 17376 --- [extShutdownHook] g.f.s.b.l.a.ApplicationEventListenerBean : B) ApplicationEventListener Bean: ContextClosedEvent
INFO 17376 --- [extShutdownHook] c.g.f.s.b.l.l.MaxSmartLifecycleBean      : C) MaxSmartLifecycle: stop()
INFO 17376 --- [extShutdownHook] c.g.f.s.b.l.s.ServletContextListenerBean : H) ServletContextListener: destroy
INFO 17376 --- [extShutdownHook] c.g.f.s.b.l.l.MinSmartLifecycleBean      : C) MinSmartLifecycle: stop()
INFO 17376 --- [extShutdownHook] c.g.f.s.b.l.bean.DisposableBeanBean      : G) DisposableBean
INFO 17376 --- [extShutdownHook] c.g.f.s.b.l.b.DefaultBeanLifecycleConfig : F) BeanLifecycleConfig: PreDestroy
INFO 17376 --- [extShutdownHook] c.g.f.s.b.l.b.DefaultBeanLifecycleBean   : D) BeanLifecycleBean: PreDestroy
```

Here you could see the order in which the different components are initialized and destroyed.

Be aware that this order is not 100% reproducible as

  * different listeners subscribed to the same event are not called in a reproducible order
  * the JvmShutdownHook executes as separate thread which could be called on some point
    during the shutdown

but it gives a good hint when which "lifecycle aware" technology gets called.
