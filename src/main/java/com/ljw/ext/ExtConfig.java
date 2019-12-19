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
 *
 * 3、ApplicationListener：监听容器中发布的事件。完成事件驱动模型的开发
 *      public interface ApplicationListener<E extends ApplicationEvent>
 *          监听ApplicationEvent及其下面的子事件；
 *
 *   步骤：
 *      1）、写一个监听器（ApplicationListener实现类）来监听某个事件（ApplicationEvent及其子类）
 *          @EventListener ；
 *          原理：使用EventListenerMethodProcessor处理器来解析方法上的@EventListener注解
 *      2）、把监听器加入到容器中；
 *      3）、只要容器中有相关事件的发布，我们就能监听到这个事件；
 *              ContextRefreshedEvent：容器刷新完成（所有Bean都完全创建）会发布这个事件；
 *              ContextClosedEvent：关闭容器会发布这个事件；
 *      4）、发布一个事件：
 *              applicationContext.publishEvent();
 *  原理：
 *      ContextRefreshedEvent、ContextRefreshedEvent、ContextClosedEvent
 *  1）、ContextRefreshedEvent事件：
 *      1）、容器创建对象：refresh()；
 *      2）、finishRefresh()：容器刷新完成会发布ContextRefreshedEvent事件
 * 2）、自己发布事件
 * 3）、容器关闭会发布ContextClosedEvent；
 *  【事件发布流程】：
 *      3）、publishEvent(new ContextRefreshedEvent(this));
 *                  1）、获取时间的多播器（派发器）:getApplicationEventMulticaster()
 *                  2）、multicastEvent派发事件；
 *                  3）、获取所有的ApplicationListener；
 *                          for (final ApplicationListener<?> listener : getApplicationListeners(event, type))
 *                          1）、如果有Executor，可以支持使用Executor进行异步派发；
 *                              Executor executor = getTaskExecutor();
 *                          2）、否则，同步的方法直接执行listener方法：invokeListener(listener, event);
 *                          拿到listener回调listener.onApplicationEvent(event)方法;
 * 【事件多播器（派发器）】
 *      1）、容器创建对象：refresh();
 *      2）、initApplicationEventMulticaster();
 *          1）、先去容器中找有没有id="applicationEventMulticaster"的组件；
 *          2）、如果没有this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *               并且加入到容器中，我们就可以在其它组件要派发事件，自动注入这个applicationEventMulticaster；
 * 【容器中有哪些监听器】
 *      1）、容器创建对象：refresh();
 *      2）、registerListeners();
 *          从容器中拿到所有的监听器，把他们注册到applicationEventMulticaster中；
 *          String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *          //将listener注册到ApplicationEventMulticaster中
 *          getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *
 *   SmartInitializingSingleton的原理：->afterSingletonsInstantiated();
 *          1）、IOC容器创建对象并刷新容器refresh()；
 *          2）、finishBeanFactoryInitialization(beanFactory);初始化剩下的单实例Bean；
 *              1）、先创建所有的单实例Bean；getBean(beanName);
 *              2）、获取所有创建好的单实例Bean，判断是否是SmartInitializingSingleton类型的；
 *                  如果是就调用afterSingletonsInstantiated()；
 *
 */
@ComponentScan("com.ljw.ext")
@Configuration
public class ExtConfig {

    @Bean
    public Blue blue(){
        return new Blue();
    }
}
