package org.zhouwei.algorithm;

/**
 * Created by zhouwei on 2018/3/27.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

/**
 * 服务启动类
 *
 * @author zhouwei
 */
@SpringBootApplication
@ComponentScan(basePackages = {"org.zhouwei.algorithm"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class, VelocityAutoConfiguration.class})
@EnableTransactionManagement
@EnableScheduling
public class Entrance {

    private static ApplicationContext context = null;

    public static void main(String[] args) {
        context = SpringApplication.run(Entrance.class, args);
        final String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (final String beanName : beanNames) {
            System.out.println(beanName);
        }
        System.out.println("algorithm started");
    }

    public static ApplicationContext getContext(){
        return Entrance.context;
    }

}