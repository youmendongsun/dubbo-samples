/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.alibaba.dubbo.samples.echo;

import com.alibaba.dubbo.samples.echo.api.EchoService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/**
 * @author yiji
 * @version : ClientInvoke.java, v 0.1 2019年08月29日 5:13 下午 yiji Exp $
 */
public class ClientInvoke implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent>, Ordered {

    ApplicationContext applicationContext;

    EchoService echoService;

    public void init() {

        // EchoService echoService = (EchoService) applicationContext.getBean("echoRefer"); // get remote service proxy



    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // trigger create proxy
        EchoService echoService = (EchoService) applicationContext.getBean("echoRefer");

        String status = echoService.echo("Hello world!");
        System.out.println("echo result: " + status);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}