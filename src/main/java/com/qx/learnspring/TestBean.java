package com.qx.learnspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiux
 * @Date 2022/9/11
 * @since
 */
@Configuration
public class TestBean {

    public TestBean() {
        System.out.println("test bean constructor");
    }

    @Bean
    public Student student(){
        return new Student();
    }

    @Bean
    public Teacher teacher() {
        return new Teacher();
    }

    @Bean
    public HeaderMaster headerMaster(){
        return new HeaderMaster();
    }

    @Bean
    public ClassTeacher classTeacher() {
        return new ClassTeacher();
    }

}
