package com.wk.study.demo.springdemo;

import com.wk.study.demo.event.DemoEvent;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.ResolvableType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * @auther: kai2.wang
 * @date: 2019/12/17 17:22
 * @description:
 * @version: 1.0
 */
@Component
public class DemoListener implements GenericApplicationListener {

    /**
     * 该方法不为ApplicationListener的实现方法，当DemoListener实现了业务接口时，spring默认采用
     * JDK自带的动态代理方式（需要业务类实现接口）， 如果实现类存在不属于接口的方法，则会出现以下异常
     * Caused by: java.lang.IllegalStateException:
     *  Need to invoke method 'handleDemoEvent' declared on target class 'DemoListener',
     *  but not found in any interface(s) of the exposed proxy type.
     *  Either pull the method up to an interface
     *  or switch to CGLIB proxies by enforcing proxy-target-class mode in your configuration.
     *  此时需要将@EnableAsync设置为@EnableAsync(proxyTargetClass=true)
     * @param event
     */
//    @Async("myExecutor")
//    @EventListener //注意此处 此时不用implements ApplicationListener<DemoEvent>
//    public void handleDemoEvent(DemoEvent event){
//        System.out.println("handleDemoEvent:我监听到了pulisher发布的message为:"+event.getMsg()+Thread.currentThread().getName());
//
//    }

    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @EventListener
    public void demo2(DemoEvent event){
        System.out.println("------demo2-----");
    }


    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public boolean supportsEventType(ResolvableType resolvableType) {
        return false;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent)
    {
        Server server = new Server(8080);
        ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        servletContext.setResourceBase(".");
        servletContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        servletContext.addServlet(new ServletHolder(new DemoHttpServlet()), "/");
        servletContext.setDisplayName("thrift");
        server.setHandler(servletContext);
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-----------");
    }
}
