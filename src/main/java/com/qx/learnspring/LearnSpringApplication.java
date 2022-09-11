package com.qx.learnspring;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class LearnSpringApplication {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {

        ConfigurableApplicationContext context = SpringApplication.run(LearnSpringApplication.class, args);

        //通过反射获得单例对象的字段
        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        singletonObjects.setAccessible(true);
        //获取beanFactory里面的单例
        Map<String, Object> singletons = (Map<String, Object>) singletonObjects.get(beanFactory);

//        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
//        System.out.println("beanDefinitionNames:" + Arrays.stream(beanDefinitionNames).collect(Collectors.toList()));
//        String[] singletonNames = beanFactory.getSingletonNames();
//        System.out.println("singletonNames:" + Arrays.stream(singletonNames).collect(Collectors.toList()));
        System.out.println(singletons.entrySet().stream().filter(singleton -> singleton.getKey().indexOf("student")> -1).collect(Collectors.toList()));

        //ApplicationContext有4个父类:MessageSource(国际资源化)、  ResourcePatterResolver、EnvironmentCapable
        //1.MessageSource
        System.out.println(context.getMessage("hi",null,Locale.ENGLISH));
        System.out.println(context.getMessage("hi",null, Locale.CHINESE));

        //2.ResourcePatterResolver
        Resource[] resource = context.getResources("classpath*:META-INF/spring.factories");
        List<String> filenames = Arrays.stream(resource).map(Resource::getDescription).collect(Collectors.toList());
        System.out.println(filenames);

        //3.EnvironmentCapable
        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println(environment.getProperty("path"));
        System.out.println(environment.getProperty("server.port"));

        //4.ApplicationEventPublisher
        context.publishEvent(new SendMailApplicationEvent("tidy"));

    }

}
