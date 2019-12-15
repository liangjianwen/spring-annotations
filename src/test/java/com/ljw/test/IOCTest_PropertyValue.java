package com.ljw.test;

import com.ljw.bean.Person;
import com.ljw.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest_PropertyValue {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
    @Test
    public void test1(){
        printBean(applicationContext);
        System.out.println("==================");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String nikName = environment.getProperty("person.nikName");
        System.out.println(nikName);

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
