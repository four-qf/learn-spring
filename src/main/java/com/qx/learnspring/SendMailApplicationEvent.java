package com.qx.learnspring;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @author qiux
 * @Date 2022/9/11
 * @since
 */
public class SendMailApplicationEvent extends ApplicationEvent {
    public SendMailApplicationEvent(Object source) {
        super(source);
        System.out.println("发送邮件事件："+ source);
    }

    public SendMailApplicationEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
