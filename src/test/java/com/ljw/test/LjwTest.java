package com.ljw.test;

import com.ljw.annotation.Apple;
import com.ljw.annotation.FruitColor;
import com.ljw.annotation.FruitName;
import org.junit.Test;

import java.lang.reflect.Field;

public class LjwTest {

    @Test
    public void test1(){
        Integer a =1;
        Integer b =2;
        Integer c =3;
        Integer d =3;
        Integer e =321;
        Integer f =321;
        Long g =3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a+b));
        System.out.println(g.equals(a+b));
    }

    @Test
    public void test2(){
        if (true){
            System.out.println("1");
        }else{
            System.out.println("323");
        }
    }

    @Test
    public void test3(){
        Apple apple = new Apple();
        System.out.println(apple.toString());
        Class c = Apple.class;
        c.getDeclaredFields();
        for (Field field : c.getDeclaredFields()){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = field.getAnnotation(FruitName.class);
                System.out.println("名字：" + fruitName.value());
            }

            if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                System.out.println("颜色：" + fruitColor.fruitColor());
            }
        }
    }
}
