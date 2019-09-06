/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.alibaba.dubbo.samples.echo;

import com.alibaba.dubbo.samples.echo.api.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class EchoConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(EchoConsumer.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/echo-consumer.xml"});
        context.start();
        EchoService echoService = (EchoService) context.getBean("echoService"); // get remote service proxy

        new Thread(() -> {
            for (; ; ) {
                try {
                    TimeUnit.SECONDS.sleep(10L);
                    String status1 = echoService.echo("Hello world!");
                    LOGGER.info(">>>>>>>> echo result: " + status1);
                } catch (Exception e) {
                    LOGGER.error(">>>>>>>> echo result: " + e.getMessage());
                }
            }
        }).start();
    }
}
