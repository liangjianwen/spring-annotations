package com.ljw.ext;

import com.ljw.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展原理：
 * BeanPostProcessor: bean后置处理器，bean创建对象初始化前后进行拦截工作的
 * BeanFactoryPostProcessor: beanFactory的后置处理器；
 *      在BeanFactory标准初始化之后调用；所有的bean定义已经保存加载到BeanFactory，但是Bean的实例还未创建
 * 1)、ioc容器创建对象
 * 2）、invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessors；
 *          如何找到所有的BeanFactoryPostProcessor并执行他们的方法？；
 *              1）、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
 *              2）、在初始化创建其它组件前面执行
 *
 * 2、BeanDefinitionRegistryPostProcessor
 */
@ComponentScan("com.ljw.ext")
@Configuration
public class ExtConfig {

    @Bean
    public Blue blue(){
        return new Blue();
    }
}
