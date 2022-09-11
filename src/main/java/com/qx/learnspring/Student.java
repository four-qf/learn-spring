package com.qx.learnspring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qiux
 * @Date 2022/9/11
 * @since
 */
public class Student implements Person {

    public Student() {
        System.out.println("student构造器---------");
    }
}
