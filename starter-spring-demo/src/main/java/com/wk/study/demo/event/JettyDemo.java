package com.wk.study.demo.event;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @auther: kai2.wang
 * @date: 2019/12/17 17:59
 * @description:
 * @version: 1.0
 */
public class JettyDemo {
    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);
        ServletContextHandler springMvcHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        springMvcHandler.setContextPath("/user");
        XmlWebApplicationContext context = new XmlWebApplicationContext();
//        context.setConfigLocation("spring.xml");
//        springMvcHandler.addEventListener(new ContextLoaderListener(context));
        springMvcHandler.addServlet(new ServletHolder(new DispatcherServlet(context)),"/*");
        springMvcHandler.setDisplayName("thrift");
        server.setHandler(springMvcHandler);
        server.start();
        server.join();

    }
}
