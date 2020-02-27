package com.ryz2593.happy.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * 在IOC的容器的启动过程，当所有的bean都已经处理完成之后，
 * spring ioc容器会有一个发布事件的动作。
 * 从 AbstractApplicationContext 的源码中就可以看出：
 *
 *protected void finishRefresh() {
 *     // Initialize lifecycle processor for this context.
 *     initLifecycleProcessor();
 *     // Propagate refresh to lifecycle processor first.
 *     getLifecycleProcessor().onRefresh();
 *     // Publish the final event.
 *     publishEvent(new ContextRefreshedEvent(this));
 *     // Participate in LiveBeansView MBean, if active.
 *     LiveBeansView.registerApplicationContext(this);
 * }
 *
 * 这样，当ioc容器加载处理完相应的bean之后，也给我们提供了一个机会（先有InitializingBean，
 * 后有ApplicationListener<ContextRefreshedEvent>），
 * 可以去做一些自己想做的事。其实这也就是spring ioc容器给提供的一个扩展的地方。
 * 我们可以这样使用这个扩展机制。
 *
 *spring容器加载完成后执行消息队列监听的方法
 * @author ryz2593
 */
@Component
public class InitListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent ev) {
        if (ev.getApplicationContext().getParent() == null) {
            ApplicationContext ctx = ev.getApplicationContext();

            UserEmailHandlerTask userEmailHandlerTaskThread = ctx.getBean(UserEmailHandlerTask.class);
            userEmailHandlerTaskThread.start();
        }
    }
}
