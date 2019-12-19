package com.ljw.test;

import com.ljw.ext.ExtConfig;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Ext {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);

    @Test
    public void test1() {

        //发布事件
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
        });
        //关闭容器
        applicationContext.close();
    }
}
