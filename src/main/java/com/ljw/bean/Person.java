package com.ljw.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    /**
     * 使用@Value赋值
     * 1、基本数值
     * 2、可以写成SqEL; #{}
     * 3、可以写成${}; 取出配置文件中的值（在运行环境变量里面的值）
     */
    @Value("张三")
    private String name;
    @Value("#{20-2}")
    private int age;
    @Value("${person.nikName}")
    private String nikName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nikName='" + nikName + '\'' +
                '}';
    }
}
