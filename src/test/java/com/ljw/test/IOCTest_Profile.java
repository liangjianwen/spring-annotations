package com.ljw.test;

import com.ljw.bean.Yellow;
import com.ljw.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {

    //1、使用命令行动态参数的方式：在虚拟机参数位置加载-Dspring.profile.active=test
    //2、用代码的方式激活某种环境
    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //1、创建一个applicationContext
        //2、设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test", "dev");
        //3、注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4、启动刷新容器
        applicationContext.refresh();

        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name : namesForType){
            System.out.println(name);
        }

        Yellow yellow = applicationContext.getBean(Yellow.class);
        System.out.println(yellow);
        //关闭容器
        applicationContext.close();
    }
}
