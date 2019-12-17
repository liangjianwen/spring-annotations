package com.ljw.test;

import com.ljw.aop.MathCalculator;
import com.ljw.bean.Boss;
import com.ljw.bean.Car;
import com.ljw.bean.Color;
import com.ljw.config.MainConfigOfAOP;
import com.ljw.config.MainConfigOfAutowired;
import com.ljw.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_AOP {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
    @Test
    public void test1(){
        //1、不要自己创建对象，要使用容器中的组件
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1, 1);

        //关闭容器
        applicationContext.close();
    }

    private void printBean(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println(name);
        }
    }
}
