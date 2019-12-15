package com.ljw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配；
 * Spting利用依赖注入（DI），完成对IOC容器中的各个组件的依赖关系赋值；
 * 1）、@Autowired
 */
@Configuration
@ComponentScan({"com.ljw.service", "com.ljw.dao", "com.ljw.controller"})
public class MainConfigOfAutowired {
}
