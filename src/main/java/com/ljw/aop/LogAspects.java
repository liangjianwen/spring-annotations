package com.ljw.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 * @Aspect ：告诉Spring当前类是一个切面类
 */
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1、本类引用，切入点表达式只需写pointCut的方法名(pointCut())
    //2、其它的切面类要引用的话，切入点表达式要写pointCut方法的全名（com.ljw.aop.LogAspects.pointCut()）
    @Pointcut("execution(public int com.ljw.aop.MathCalculator.*(..))")
    public void pointCut(){}

    //@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
    //JoinPoint一定要出现在参数表的第一位
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] objects = joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"除法运行。。。@Before:参数列表是:{"+ Arrays.asList(objects) +"}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(""+joinPoint.getSignature().getName()+"除法结束。。。@After");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result){
        System.out.println(""+joinPoint.getSignature().getName()+"除法正常返回。。。@AfterReturning运行结果:{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception){
        System.out.println(""+joinPoint.getSignature().getName()+"除法异常。。。异常信息:{"+exception+"}");
    }
}
