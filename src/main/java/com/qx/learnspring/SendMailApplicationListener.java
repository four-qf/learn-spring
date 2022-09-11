package com.qx.learnspring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @author qiux
 * @Date 2022/9/11
 * @since
 */
@Configuration
public class SendMailApplicationListener {

    @EventListener
    public void sendMail(SendMailApplicationEvent applicationEvent) {
        System.out.println("监听到，需要发送邮件-----"+ applicationEvent.getSource());
    }

}
