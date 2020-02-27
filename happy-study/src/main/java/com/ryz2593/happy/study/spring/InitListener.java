package com.ryz2593.happy.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
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
