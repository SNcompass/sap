package com.orient.sap.config;

import com.orient.sap.service.impl.SapServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class SapConfigration {
    @Bean
    public ServletRegistrationBean dispatcherServlet1() {
        // 这个方法名报错了，查了一下解决办法就是改个名，随便加个1就行了。
        //接口路径，可根据实际情况自定义
        return new ServletRegistrationBean(new CXFServlet(),"/orient/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    // 此方法为每一个接口的实现类都创建一个
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new SapServiceImpl());
        endpoint.publish("/sap");
        return endpoint;

    }
}
