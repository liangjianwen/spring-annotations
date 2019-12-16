package com.ljw.test;

import com.ljw.bean.Boss;
import com.ljw.bean.Car;
import com.ljw.bean.Color;
import com.ljw.bean.Person;
import com.ljw.config.MainConfigOfAutowired;
import com.ljw.config.MainConfigOfPropertyValue;
import com.ljw.dao.BookDao;
import com.ljw.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest_Autowired {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
    @Test
    public void test1(){
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);

       /* BookDao bookDao = applicationContext.getBean(BookDao.class);
        System.out.println(bookDao);*/
        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);
        System.out.println(applicationContext);
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
