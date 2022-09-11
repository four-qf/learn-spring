package com.qx.learnspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author qiux
 * @Date 2022/9/11
 * @since
 */
public class Teacher implements Person {

    @Autowired
    private Person classTeacher;

    @Autowired
    private Student student;

    public Teacher() {
        System.out.println(" constructor teacher-------------");
    }

    public Student getStudent() {
        return student;
    }

    public Person getHeaderMaster() {
        return classTeacher;
    }
}

