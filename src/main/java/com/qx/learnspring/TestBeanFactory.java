package com.qx.learnspring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author qiux
 * @Date 2022/9/11
 * @since
 */
public class TestBeanFactory {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(TestBean.class).setScope("singleton").getBeanDefinition();
        beanFactory.registerBeanDefinition("testBean", beanDefinition);

        //注册bean初始化后的信息配置处理
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
//
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(facotryPostProcessor -> {
            facotryPostProcessor.postProcessBeanFactory(beanFactory);
        });

        beanFactory.getBeansOfType(BeanPostProcessor.class).values().forEach(beanPostProcessor -> beanFactory.addBeanPostProcessor(beanPostProcessor));

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(beanNames -> System.out.println(beanNames));
//        beanFactory.preInstantiateSingletons();
        System.out.println("--------------------------");
        Teacher teacher = beanFactory.getBean(Teacher.class);
        Student student = teacher.getStudent();
        System.out.println(student);
        System.out.println(teacher.getHeaderMaster());


    }

}
